package io.github.sruby.spring.task;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * test
 * @author liuwf on Jun 12, 2017 5:56:55 PM
 */
public class Client
{
	@Test
	public void test()
	{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-tasks.xml");
	}
}
