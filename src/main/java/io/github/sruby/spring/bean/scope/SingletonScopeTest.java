package io.github.sruby.spring.bean.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import io.github.sruby.spring.bean.HelloWorld;

/**
 * bean单例作用域
 * @author sruby on 2016年10月3日 上午1:12:46
 */
public class SingletonScopeTest
{
	
	public static void main(String[] args)
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		HelloWorld objA = (HelloWorld) context.getBean("helloWorld");
		objA.setMessage("I'm object A");
		objA.getMessage();
		HelloWorld objB = (HelloWorld) context.getBean("helloWorld");
		objB.getMessage();
	}
}
