package io.github.sruby.designpattern.strategy.norm;


public class StrategyClient
{
	public static void main(String[] args)
	{
		Context context = new Context(new ConcreteStrategy1());
		
		context.doAnything();
		
		Context context2 = new Context(new ConcreteStrategy2());
		
		context2.doAnything();
		
	}
}
