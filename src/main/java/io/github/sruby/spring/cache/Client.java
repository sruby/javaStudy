package io.github.sruby.spring.cache;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试类
 * @author sruby on 2018年3月14日 下午2:00:35
 */
public class Client
{
	UserService userService;
	
	@Before
	public void setUp()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringCacheConfig.xml");
		userService = (UserService) context.getBean("userService");
	}
	
	/**
	 * 测试设置缓存
	 * @author sruby on 2018年3月14日 下午2:03:00
	 */
	@Test
	public void testSetCache()
	{
		User user = userService.findUser();
		System.out.println(user.toString());
		
		User user2 = userService.findUser();
		System.out.println(user2.toString());
	}
	
	/**
	 * 使用不同方法，但是方法的都使用默认的key，因为都是无参，所以是相同的key
	 * 默认key生成： （所以findUser2和findUser是使用的同一个key）
		默认key的生成按照以下规则： 
		- 如果没有参数,则使用0作为key（如果注解在其他无入参的方法并且用默认key则会出现冲突）
		- 如果只有一个参数，使用该参数作为key 
		- 如果又多个参数，使用包含所有参数的hashCode作为key
	 * @author sruby on 2018年3月14日 下午2:04:56
	 */
	@Test
	public void testSetCacheBySameKey()
	{
		User user = userService.findUser();
		System.out.println(user.toString());
		
		User user2 = userService.findUser();
		System.out.println(user2.toString());
		
		User user3 = userService.findUser2();
		System.out.println(user3.toString());
	}
	
	/**
	 * 将缓存设置为失效
	 * @author sruby on 2018年3月14日 下午2:20:54
	 */
	@Test
	public void testEvictCache()
	{
		User user = userService.findUser();
		System.out.println(user.toString());
		
		userService.updateUser();
		
		user = userService.findUser();
	}
	
}
