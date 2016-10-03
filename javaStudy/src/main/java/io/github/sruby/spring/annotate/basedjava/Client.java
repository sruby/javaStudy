package io.github.sruby.spring.annotate.basedjava;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import io.github.sruby.spring.bean.HelloWorld;
import io.github.sruby.spring.di.constructorbased.TextEditor;

public class Client
{
	
	public static void main(String[] args)
	{
		ApplicationContext ctx = new AnnotationConfigApplicationContext(HelloWorldConfig.class);
		HelloWorld helloWorld = ctx.getBean(HelloWorld.class);
		helloWorld.setMessage("Hello World!");
		helloWorld.getMessage();
		
		TextEditor te = ctx.getBean(TextEditor.class);
		te.spellCheck();
	}
}
