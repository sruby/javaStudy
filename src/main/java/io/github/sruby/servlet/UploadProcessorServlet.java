package io.github.sruby.servlet;

import io.github.sruby.utils.DateHelper;
import io.github.sruby.utils.FileHelper;
import io.github.sruby.utils.StringHelper;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;

/**
 * 
 * 文件上传 具体步骤： 
 * 1）获得磁盘文件条目工厂 DiskFileItemFactory 要导包 
 * 2） 利用 request 获取 真实路径
 * ，供临时文件存储，和 最终文件存储 ，这两个存储位置可不同，也可相同
 * 3）对 DiskFileItemFactory 对象设置一些 属性
 * 4）高水平的API文件上传处理 ServletFileUpload upload = new ServletFileUpload(factory);
 * 目的是调用 parseRequest（request）方法 获得 FileItem 集合list ，
 * 5）在 FileItem 对象中 获取信息， 遍历， 判断 表单提交过来的信息 是否是 普通文本信息 另做处理 
 * 6） 第一种. 用第三方 提供的 * item.write( new File(path,filename) ); 直接写到磁盘上 第二种. 手动处理
 * 
 */
public class UploadProcessorServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(UploadProcessorServlet.class);
	// 保存文件的目录
	private static String PATH_FOLDER = "/";
	// 存放临时文件的目录
	private static String TEMP_FOLDER = "/";
	
	@Override
	public void init(ServletConfig config) throws ServletException
	{
		ServletContext servletCtx = config.getServletContext();
		// 保存文件的目录
		PATH_FOLDER = servletCtx.getRealPath("/upload");
		// 存放临时文件的目录,存放xxx.tmp文件的目录
		TEMP_FOLDER = servletCtx.getRealPath("/uploadTemp");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("gbk"); // 设置编码
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		
		/**
		 * 原理 它是先存到 暂时存储室，然后在真正写到 对应目录的硬盘上， 按理来说 当上传一个文件时，其实是上传了两份，第一个是以 .tem
		 * 格式的 然后再将其真正写到 对应目录的硬盘上
		 * 如果没以下两行设置的话，上传大的 文件 会占用 很多内存，设置暂时存放的 存储室 , 这个存储室，可以和 最终存储文件 的目录不同
		 */
		// 获得磁盘文件条目工厂
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(new File(TEMP_FOLDER));
		// 设置 缓存的大小，当上传文件的容量超过该缓存时，直接放到 暂时存储室
		factory.setSizeThreshold(1024 * 1024);
		// 高水平的API文件上传处理
		ServletFileUpload upload = new ServletFileUpload(factory);
		JSONObject jsonObject = new JSONObject();
		try
		{
			// 这意味着可以上传多个文件
			List<FileItem> list = upload.parseRequest(request);
			// 获取上传的文件
			FileItem item = getUploadFileItem(list);
			
			/**
			 * 生成文件名
			 */
			String filename = getUploadFileName(item);
			String extName = FileHelper.getExtension(filename);
			String newFileName = String.valueOf(DateHelper.formatDate(new Date(), "yyyyMMdd") + System.currentTimeMillis());
			if (!StringHelper.isEmpty(extName))
			{
				newFileName = newFileName + "." + extName;
			}
			
			/**
			 * 保存文件
			 */
			String uploadPath = this.getUploadPath();
			item.write(new File(uploadPath, newFileName));
			
			/**
			 * 上传结果返回
			 */
			PrintWriter writer = response.getWriter();
			jsonObject.put("err_no", 0);
			writer.print(jsonObject.toString());
			writer.close();
			
		}
		catch (FileUploadException e)
		{
			jsonObject.put("err_no", -1);
			jsonObject.put("err_info", e.getMessage());
			logger.error(e.getCause());
		}
		catch (Exception e)
		{
			jsonObject.put("err_no", -2);
			jsonObject.put("err_info", e.getMessage());
			logger.error(e.getCause());
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		this.doGet(request, response);
	}
	
	private FileItem getUploadFileItem(List<FileItem> list)
	{
		for (FileItem fileItem : list)
		{
			if (!fileItem.isFormField())
			{
				return fileItem;
			}
		}
		return null;
	}
	
	private String getUploadFileName(FileItem item)
	{
		// 获取路径名
		String value = item.getName();
		// 索引到最后一个反斜杠
		int start = value.lastIndexOf("/");
		// 截取 上传文件的 字符串名字，加1是 去掉反斜杠，
		String filename = value.substring(start + 1);
		return filename;
	}
	
	/**
	 * 返回保存上传文件在项目的真实目录路径
	 */
	public static String getUploadPath()
	{
		String datePath = DateHelper.formatDate(new Date(), "yyyyMMdd");
		String uploadPath = PATH_FOLDER + "/" + datePath + "/";
		
		uploadPath = FileHelper.normalize(uploadPath);
		if (!FileHelper.isDirectory(uploadPath))
		{
			FileHelper.createDirectory(uploadPath);
		}
		
		logger.debug("保存的目录地址：" + uploadPath);
		return uploadPath;
	}
}
