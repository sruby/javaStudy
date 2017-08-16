package io.github.sruby.encoding;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * encode demo
 * @author sruby on Jul 21, 2017 1:59:33 PM
 */
public class EncodeDemo
{
	public static void main(String[] args) throws UnsupportedEncodingException
	{	
		String encode = URLEncoder.encode("中文","utf-8");
		//%E4%B8%AD%E6%96%87
		System.out.println(encode);
	}
}
