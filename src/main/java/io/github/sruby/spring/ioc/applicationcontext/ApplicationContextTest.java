package io.github.sruby.spring.ioc.applicationcontext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import io.github.sruby.spring.bean.HelloWorld;

/**
 * ApplicationContext 包含 BeanFactory 所有的功能，一般情况下，相对于 BeanFactory，
 * ApplicationContext 会被推荐使用。
 * BeanFactory 仍然可以在轻量级应用中使用，比如移动设备或者基于 applet 的应用程序。
 * @author sruby on 2016年10月3日 上午12:38:49
 */
public class ApplicationContextTest
{
	
	public static void main(String[] args)
	{
		//文件的相对路径
		ApplicationContext context = new FileSystemXmlApplicationContext("javaStudy/src/main/resources/Beans.xml");
		//类路径下的文件
//		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
		obj.getMessage();
	}
}
