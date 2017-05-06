package io.github.sruby.annotation.point;

/**
 * 测试类
 * @author liuwf on May 6, 2017 6:36:59 PM
 */
public class Client
{
	public static void main(String[] args)
	{
		LoginService loginService = new LoginService();
		loginService.login();
	}
}
