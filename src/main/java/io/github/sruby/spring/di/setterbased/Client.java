package io.github.sruby.spring.di.setterbased;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 注入内部bean
 * @author sruby on 2016年10月3日 上午1:54:49
 */
public class Client
{
	public static void main(String[] args)
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		TextEditor te = (TextEditor) context.getBean("textEditor2");
		te.spellCheck();
	}
}
