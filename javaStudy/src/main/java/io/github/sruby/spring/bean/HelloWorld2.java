package io.github.sruby.spring.bean;


public class HelloWorld2
{
	private String message;

	public void getMessage()
	{
		System.out.println("message:"+message);
	}

	
	public void setMessage(String message)
	{
		this.message = message;
	}
}
