package io.github.sruby.designPattern.factory;


public class YellowHuman extends AbstractHuman
{
	@Override
	public void getColor()
	{
		System.out.println("i am Yellow!");
		
	}
	
	@Override
	public void speak()
	{
		System.out.println("we can understand!");
	}
	
}
