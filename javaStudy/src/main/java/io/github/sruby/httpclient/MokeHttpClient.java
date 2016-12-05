package io.github.sruby.httpclient;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import com.alibaba.fastjson.JSONObject;

/**
 * 模拟http请求
 * @author sruby on 2016年12月5日 下午11:51:17
 */
public class MokeHttpClient
{
	private static Logger logger = Logger.getLogger(HttpClientDemo.class);
	
	private String url;	//请求的url
	private List<NameValuePair> formparams; //请求的参数
	public MokeHttpClient(String url, List<NameValuePair> formparams)
	{
		super();
		this.url = url;
		this.formparams = formparams;
	}
	
	
	/**
	 * post方式请求
	 * @author sruby on 2016年12月5日 下午11:51:58
	 * @return
	 */
	public JSONObject postForm()
	{
		JSONObject jsonObject = null;
		// 创建默认的httpClient实例.    
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httppost = new HttpPost(this.url);
		UrlEncodedFormEntity uefEntity;
		try
		{
			uefEntity = new UrlEncodedFormEntity(this.formparams, "UTF-8");
			httppost.setEntity(uefEntity);
			httppost.setHeader("User-Agent", "Mozilla/5.0 (Linux; Android 5.1; M57AC Build/LMY47D) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.85 Mobile Safari/537.36");
			httppost.setHeader("Connection", "keep-alive");    

			logger.info("executing request " + httppost.getURI());
			CloseableHttpResponse response = httpclient.execute(httppost);
			try
			{
				HttpEntity entity = (HttpEntity) response.getEntity();
				
				if (entity != null)
				{
					String result = EntityUtils.toString(entity, "UTF-8");
					jsonObject = new JSONObject();
					jsonObject = jsonObject.parseObject(result);
					logger.info("Response content: " + result);
				}
			}
			finally
			{
				response.close();
			}
		}
		catch (ClientProtocolException e)
		{
			logger.error(e.getMessage(),e);
		}
		catch (UnsupportedEncodingException e1)
		{
			logger.error(e1.getMessage(),e1);
		}
		catch (IOException e)
		{
			logger.error(e.getMessage(),e);
		}
		finally
		{
			// 关闭连接,释放资源    
			try
			{
				httpclient.close();
			}
			catch (IOException e)
			{
				logger.error(e.getMessage(),e);
			}
		}
		return jsonObject;
	}
	
}
