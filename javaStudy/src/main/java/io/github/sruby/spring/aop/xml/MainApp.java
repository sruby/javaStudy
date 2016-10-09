package io.github.sruby.spring.aop.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 基于xml的切面示例
 * 注意：bean.xml配置需要在beans节点使用aop的schema
 * 需要放开xml中的aop节点注释
 * @author sruby on 2016年10月10日 上午12:14:29
 */
public class MainApp
{
	public static void main(String[] args)
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		Student student = (Student) context.getBean("student");
		student.getName();
		student.getAge();
//		student.printThrowException();
	}
}
