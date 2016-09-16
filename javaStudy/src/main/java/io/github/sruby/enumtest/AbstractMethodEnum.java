package io.github.sruby.enumtest;

/**
 * 带抽象方法的枚举
 * @author sruby on 2016年9月16日 下午1:22:05
 */
public enum AbstractMethodEnum
{
	/**
	 * 枚举值需要实现其中的抽象方法
	 */
	SMALL {
		@Override
		public void doSomething()
		{
			System.out.println("small");	
		}
	},MEDIUM {
		
		@Override
		public void doSomething()
		{
			System.out.println("medium");
			
		}
	};
	
	public abstract void doSomething();
}
