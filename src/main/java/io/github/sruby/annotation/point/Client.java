package io.github.sruby.annotation.point;

import io.github.sruby.spring.aop.xml.Student;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试类
 * @author liuwf on May 6, 2017 6:36:59 PM
 */
public class Client
{
	public static void main(String[] args)
	{
//		LoginService loginService = new LoginService();
		/**
		 * 切面的对象必须通过spring来管理
		 */
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		LoginService loginService = (LoginService) context.getBean("loginService");
		loginService.login();
	}
}
