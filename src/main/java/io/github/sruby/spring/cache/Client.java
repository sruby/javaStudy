package io.github.sruby.spring.cache;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Client
{
	public static void main(String[] args)
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringCacheConfig.xml");
		UserService userService = (UserService) context.getBean("userService");
		
		User user = userService.findUser();
		System.out.println(user.toString());
		
		User user3 = userService.findUser2();
		System.out.println(user3.toString());
		
		User user2 = userService.findUser();
		System.out.println(user2.toString());
	}
}
