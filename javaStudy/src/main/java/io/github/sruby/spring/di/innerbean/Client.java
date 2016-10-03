package io.github.sruby.spring.di.innerbean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import io.github.sruby.spring.di.setterbased.TextEditor;

/**
 * set注入
 * @author sruby on 2016年10月3日 上午1:54:49
 */
public class Client
{
	public static void main(String[] args)
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		TextEditor te = (TextEditor) context.getBean("textEditor3");
		te.spellCheck();
	}
}
