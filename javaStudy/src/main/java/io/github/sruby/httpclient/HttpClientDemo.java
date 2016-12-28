package io.github.sruby.httpclient;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.apache.log4j.Logger;
import com.alibaba.fastjson.JSONObject;

public class HttpClientDemo
{
	private static Logger logger = Logger.getLogger(HttpClientDemo.class);
	
	public static void main(String[] args)
	{
		String token = login();
		complaint(token);
	}
	
	/**
	 * 登陆
	 * @author sruby on 2016年12月5日 下午11:08:11
	 * @return
	 */
	public static String login()
	{
		String url = "http://api.52mlsz.com/App_v2/user/login";
		// 创建参数队列    
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		formparams.add(new BasicNameValuePair("mobile", "17727509289"));
		formparams.add(new BasicNameValuePair("password", "c7b3b13e5a6475dbc51bd955a8c7783f"));
		formparams.add(new BasicNameValuePair("xg_token", "0aef7f6443e4b06b47ac85f4f61e8ec6b2391b23"));
		formparams.add(new BasicNameValuePair("source", "1"));
		formparams.add(new BasicNameValuePair("device", "1"));
		MokeHttpClient mokeHttpClient = new MokeHttpClient(url, formparams);
		JSONObject parseObject = mokeHttpClient.postForm();
		String token = parseObject.getJSONObject("data").getString("token");
		logger.info("token" + token);
		return token;
	}
	
	/**
	 * 吐槽
	 * @author sruby on 2016年12月5日 下午11:08:44
	 */
	public static void complaint(String token)
	{
		// 创建参数队列    
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		formparams.add(new BasicNameValuePair("content", "content"));
		formparams.add(new BasicNameValuePair("location", "113.922912%2C22.54331"));
		formparams.add(new BasicNameValuePair("anonymous", "1"));
		formparams.add(new BasicNameValuePair("address", URLDecoder.decode("%E5%8D%97%E5%B1%B1%E5%8C%BA%E4%B8%AD%E5%B1%B1%E4%B8%9C%E8%A1%97%E5%8D%97%E5%A4%B4%E5%8F%A4%E5%9F%8E%E5%9E%A3")));
		formparams.add(new BasicNameValuePair("mobile", "17727509289"));
		formparams.add(new BasicNameValuePair("type", "9"));
		formparams.add(new BasicNameValuePair("mobile", "17727509289"));
		formparams.add(new BasicNameValuePair("source", "2"));
		formparams.add(new BasicNameValuePair("token", token));
		String url ="http://api.52mlsz.com/App_v2/complaint/doComplaint";
		MokeHttpClient mokeHttpClient = new MokeHttpClient(url, formparams);
		JSONObject parseObject = mokeHttpClient.postForm();
	}
	
}
