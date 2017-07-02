package io.github.sruby.system;

/**
 * 测试当前用户目录
 * @author liuwf on Jul 2, 2017 4:28:32 PM
 */
public class UserDir
{
	public static void main(String[] args)
	{
		String property = System.getProperty("user.dir");
		System.out.println(property);
	}
}
