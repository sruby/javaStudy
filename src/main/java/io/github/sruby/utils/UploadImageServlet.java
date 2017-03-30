package io.github.sruby.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * 图片上传并压缩
 * @author liuwf on 2016年11月26日 下午2:19:08
 */
public class UploadImageServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	private Logger logger = Logger.getLogger(UploadImageServlet.class);
	
	private String tempPath = "/uploadImageTemp";// 临时存储目录
	
	private String savePath = "/userImage";// 存储目录
	
	private String fileName = ""; //文件名
	
	private final static int PICTURE_WIDTH = 120; //用户头像图片宽度
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		JSONArray jsonArr = new JSONArray();
		JSONObject jsonObj = new JSONObject();
		
		try
		{
			
			
			//获取临时目录
			String tempPathDir = request.getSession().getServletContext().getRealPath(this.tempPath);
			File tempPathDirFile = new File(tempPathDir);
			if (!tempPathDirFile.exists())
			{
				tempPathDirFile.mkdirs();
			}
			
			//存储目录
			String realDir = request.getSession().getServletContext().getRealPath(this.savePath);
			File realDirFile = new File(realDir);
			if (!realDirFile.exists())
			{
				realDirFile.mkdirs();
			}
			
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(4096); // 设置缓冲区大小，这里是4kb
			factory.setRepository(tempPathDirFile);// 设置缓冲区目录
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setSizeMax(4194304); // 设置最大文件尺寸，这里是4MB
			
			List<FileItem> items = upload.parseRequest(request);// 得到所有的文件
			if (items == null || items.isEmpty())
			{
				throw new Exception("上传的文件为空！");
			}
			
			Iterator<FileItem> iterator = items.iterator();
			
			while (iterator.hasNext())
			{
				FileItem fi = (FileItem) iterator.next();
				String fileName = fi.getName();
				if (fileName != null)
				{
					//图片文件格式校验 (gif,jpg,jpeg,bmp,png)
					String suffixName = FilenameUtils.getExtension(fileName);
					if (!"gif".equalsIgnoreCase(suffixName) && !"jpg".equalsIgnoreCase(suffixName) && !"jpeg".equalsIgnoreCase(suffixName) && !"bmp".equalsIgnoreCase(suffixName)
							&& !"png".equalsIgnoreCase(suffixName))
					{
						throw new Exception("上传的图片文件非法");
					}
					
					//生成文件名
					this.fileName = new Date().getTime() + "." + FilenameUtils.getExtension(fileName);
					
					/**
					 * 压缩图片并写入磁盘
					 */
					InputStream inputStream = fi.getInputStream();
					ImgCompress imgCompress = new ImgCompress(inputStream, realDir + File.separator + this.fileName);
					imgCompress.resizeByWidth(PICTURE_WIDTH);
					
					//复制一份小图
					File savedFile = new File(realDir, this.fileName);
					File savedSmallFile = new File(realDir + "/small/", this.fileName);
					FileUtils.copyFile(savedFile, savedSmallFile);
					
					/**
					 * 响应
					 */
					jsonObj.put("picurl", this.fileName);
					jsonObj.put("result", "true");
				}
			}
		}
		catch (Exception e)
		{
			jsonObj.put("result", "false");
			jsonObj.put("message", "图片保存失败:"+e.getMessage());
			logger.error("图片上传失败"+e.getMessage(), e);
		}
		finally
		{
			PrintWriter writer = null;
			try
			{
				writer = response.getWriter();
				jsonArr.add(jsonObj);
				writer.print(jsonArr.toString());
				writer.flush();
			}
			catch (Exception e2)
			{
			}
			finally
			{
				writer.close();
			}
			
		}
	}
	
}
