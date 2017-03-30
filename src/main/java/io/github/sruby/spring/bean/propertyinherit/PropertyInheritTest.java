package io.github.sruby.spring.bean.propertyinherit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import io.github.sruby.spring.bean.HelloIndia;
import io.github.sruby.spring.bean.HelloWorld;


/**
 * 子 bean 的定义继承父定义的配置数据。子定义可以根据需要重写一些值，或者添加其他值。
 * Spring Bean 定义的继承与 Java 类的继承无关，但是继承的概念是一样的。
 * 你可以定义一个父 bean 的定义作为模板和其他子 bean 就可以从父 bean 中继承所需的配置。
 *  “helloIndia” bean 的同时并没有传递 message，但是由于 Bean 定义的继承，所以它传递了 message。
 * @author sruby on 2016年10月3日 上午1:43:18
 */
public class PropertyInheritTest
{
	
	public static void main(String[] args)
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		HelloWorld objA = (HelloWorld) context.getBean("helloWorld");
		objA.getMessage();
		
		HelloIndia objB = (HelloIndia) context.getBean("helloIndia");
		objB.getMessage1();
		objB.getMessage2();
		objB.getMessage();
	}
}
