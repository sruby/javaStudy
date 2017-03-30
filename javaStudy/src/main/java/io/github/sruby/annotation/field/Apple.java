package io.github.sruby.annotation.field;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.sruby.annotation.field.FruitColor.Color;


public class Apple
{
	private Logger logger = LoggerFactory.getLogger(Apple.class);
	
	@FruitName("apple")
	private String appleName;
	
	@FruitColor(fruitColor=Color.RED)
	private String appleColor;
	
	public String getAppleName()
	{
		return appleName;
	}

	
	public void setAppleName(String appleName)
	{
		this.appleName = appleName;
	}

	
	public String getAppleColor()
	{
		return appleColor;
	}

	
	public void setAppleColor(String appleColor)
	{
		this.appleColor = appleColor;
	}

	public void displayName()
	{
		logger.debug("苹果名字{}",this.getAppleName());
	}
	
	public static void main(String[] args)
	{
		new Apple().displayName();
	}
}
