package io.github.sruby.designpattern.factory;

/**
 * 人类
 * @author sruby on 2016年9月4日 下午6:18:02
 */
abstract class AbstractHuman implements Cloneable
{
	private String name;
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void getColor()
	{
	}
	
	public void speak()
	{
	}
	
	@Override
	public AbstractHuman clone() throws CloneNotSupportedException
	{
		return (AbstractHuman) super.clone();
	}
}
