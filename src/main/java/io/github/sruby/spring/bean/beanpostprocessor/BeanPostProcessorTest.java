package io.github.sruby.spring.bean.beanpostprocessor;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import io.github.sruby.spring.bean.HelloWorld;

public class BeanPostProcessorTest
{
	
	public static void main(String[] args)
	{
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
		obj.getMessage();
		context.registerShutdownHook();
	}
}
