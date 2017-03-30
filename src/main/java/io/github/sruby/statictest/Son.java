package io.github.sruby.statictest;


public class Son extends Parent
{
	static
	{
		System.out.println("son static block");
	}
	
	{
		System.out.println("son block");
	}
	
	public Son()
	{
		System.out.println("son constructor");
	}
}
