package io.github.sruby.designpattern.strategy.enumedition;

/**
 * 枚举方式实现策略模式
 * @author sruby on 2016年9月16日 下午2:41:08
 */
public enum EnumStrategy
{
	ADD("+") {
		
		@Override
		public int exec(int a, int b)
		{
			return a+b;
		}
	},SUB("-") {
		
		@Override
		public int exec(int a, int b)
		{
			return a-b;
		}
	};
	
	private String value;
	private EnumStrategy(String value)
	{
		this.value = value;
	}
	public abstract int exec(int a,int b);
}
