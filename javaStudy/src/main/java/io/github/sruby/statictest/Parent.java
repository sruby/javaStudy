package io.github.sruby.statictest;


public class Parent
{
	static
	{
		System.out.println("parent static block");
	}
	
	{
		System.out.println("parent block");
	}
	
	public Parent()
	{
		System.out.println("parent constructor");
	}
}
