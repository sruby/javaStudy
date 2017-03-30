package io.github.sruby.enumtest;


public enum ConstructionEnum
{
	/**
	 * 枚举值必须放在变量和方法前面
	 */
	SMALL("S"), MEDIUM("M"),LARGE("L");
	
	private String name;
	private ConstructionEnum(String name)
	{
		this.name = name ;
	}
	public String getName()
	{
		return this.name;
	}
	
}
