package io.github.sruby.designpattern.strategy.norm;

/**
 * 上下文
 * @author sruby on 2016年9月16日 下午1:01:05
 */
public class Context
{
	private Strategy strategy = null;
	
	/**
	 * 构造注入
	 * @param strategy
	 */
	public Context(Strategy strategy)
	{
		this.strategy = strategy;
	}
	
	public void doAnything()
	{
		this.strategy.doSomething();
	}
}
