package io.github.sruby.spring.di.collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 集合注入
 * @author sruby on 2016年10月4日 上午12:16:19
 */
public class Client
{
	public static void main(String[] args)
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		JavaCollection jc = (JavaCollection) context.getBean("javaCollection");
		jc.getAddressList();
		jc.getAddressSet();
		jc.getAddressMap();
		jc.getAddressProp();
	}
}
