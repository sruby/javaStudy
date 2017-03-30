package io.github.sruby.spring.bean.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import io.github.sruby.spring.bean.HelloWorld;
import io.github.sruby.spring.bean.HelloWorld2;

/**
 * bean Prototype作用域
 * 该作用域将单一 bean 的定义限制在任意数量的对象实例。
 * @author sruby on 2016年10月3日 上午1:12:46
 */
public class PrototypeScopeTest
{
	
	public static void main(String[] args)
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		HelloWorld2 objA = (HelloWorld2) context.getBean("helloWorld2");
		objA.setMessage("I'm object A");
		objA.getMessage();
		
		HelloWorld2 objB = (HelloWorld2) context.getBean("helloWorld2");
		objB.getMessage();
	}
}
