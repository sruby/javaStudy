package io.github.sruby.designpattern.strategy.enumedition;

/**
 * 高层模块，使用策略
 * @author sruby on 2016年9月16日 下午2:44:03
 */
public class EnumStrategyClient
{
	
	public static void main(String[] args)
	{
		int a = 1;
		int b = 2;
		String operator = "-";
		if ("+".equals(operator))
		{
			Context context = new Context(EnumStrategy.ADD);
			int operate = context.operate(a, b);
			System.out.println(operate);
		}
		else if ("-".equals(operator))
		{
			Context context = new Context(EnumStrategy.SUB);
			int operate = context.operate(a, b);
			System.out.println(operate);
		}
		
	}
}
