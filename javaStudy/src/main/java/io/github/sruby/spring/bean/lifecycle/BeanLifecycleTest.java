package io.github.sruby.spring.bean.lifecycle;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import io.github.sruby.spring.bean.HelloWorld;

/**
 * bean 的生命周期
 * @author sruby on 2016年10月3日 上午1:21:14
 */
public class BeanLifecycleTest
{
	public static void main(String[] args)
	{
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		HelloWorld objA = (HelloWorld) context.getBean("helloWorld");
		objA.getMessage();
		
		//执行完之后bean会被销毁
		context.registerShutdownHook();
	}
}
