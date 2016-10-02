package io.github.sruby.spring.bean;

public class HelloIndia
{
	
	private String message1;
	
	private String message2;
	
	private String message;
	
	public void setMessage1(String message)
	{
		this.message1 = message;
	}
	
	public void setMessage2(String message)
	{
		this.message2 = message;
	}
	
	public void setMessage(String message)
	{
		this.message = message;
	}
	
	public void getMessage1()
	{
		System.out.println("India Message1 : " + message1);
	}
	
	public void getMessage2()
	{
		System.out.println("India Message2 : " + message2);
	}
	
	public void getMessage()
	{
		System.out.println("India Message : " + message);
	}
}
