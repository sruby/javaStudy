package io.github.sruby.spring.aop.annotate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import io.github.sruby.spring.aop.xml.Student;

/**
 * 基于注解的切面示例
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
