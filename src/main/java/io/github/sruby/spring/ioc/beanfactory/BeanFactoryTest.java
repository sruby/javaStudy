package io.github.sruby.spring.ioc.beanfactory;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import io.github.sruby.spring.bean.HelloWorld;

/**
 * BeanFactory
 * @author sruby on 2016年10月3日 上午12:37:08
 */
public class BeanFactoryTest
{
	
	public static void main(String[] args)
	{
		/**
		 * 第一步利用框架提供的 XmlBeanFactory() API 去生成工厂 bean 以及利用 ClassPathResource() API
		 * 去加载在路径 CLASSPATH 下可用的 bean 配置文件。XmlBeanFactory() API 负责创建并初始化所有的
		 * 对象，即在配置文件中提到的 bean。
		 */
		XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("Beans.xml"));
		
		/**
		 * 第二步利用第一步生成的 bean 工厂对象的 getBean() 方法得到所需要的 bean。 这个方法通过配置文件中
		 * 的 bean ID 来返回一个真正的对象，该对象最后可以用于实际的对象。一旦得到这个对象，就可以利用这个
		 * 对象来调用任何方法。
		 */
		HelloWorld obj = (HelloWorld) factory.getBean("helloWorld");
		obj.getMessage();
	}
}
