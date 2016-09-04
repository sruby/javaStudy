package io.github.sruby.designPattern.factory;


public class BlackHuman extends AbstractHuman
{
	
	
	@Override
	public void getColor()
	{
		System.out.println("i am black!");
	}
	
	@Override
	public void speak()
	{
		System.out.println("no body can understand!");
	}
	
}
