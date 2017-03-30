package io.github.sruby.designpattern.strategy.enumedition;

/**
 * 上下文
 * @author sruby on 2016年9月16日 下午2:43:46
 */
public class Context
{
	private EnumStrategy enumStrategy;
	public Context(EnumStrategy enumStrategy)
	{
		this.enumStrategy = enumStrategy;
	}
	
	public int operate(int a,int b)
	{
		return enumStrategy.exec(a, b);
	}
}
