package io.github.sruby.spring.bean;

public class HelloWorld
{
	
	private String message;
	
	public void getMessage()
	{
		System.out.println("message:" + message);
	}
	
	public void setMessage(String message)
	{
		this.message = message;
	}
	
	public void init()
	{
		System.out.println("Bean is going through init.");
	}
	
	public void destroy()
	{
		System.out.println("Bean will destroy now.");
	}
}
