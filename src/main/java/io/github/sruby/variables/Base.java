package io.github.sruby.variables;

/**
 * java实例变量初始化步骤
 * http://blog.csdn.net/cauchyweierstrass/article/details/48943077
 * @author sruby on 2016年9月17日 下午11:35:40
 */
public class Base
{
	//2、堆中初始化实例变量baseName
	private String baseName = "base";
	
	//1、父类的构造方法
	public Base()
	{
		callName();
	}
	
	public void callName()
	{
		System.out.println(baseName);
	}
	
	static class Sub extends Base
	{
		
		private String baseName = "sub";
		
		/**
		 * 3、覆写了父类的方法，由于多态调用之类的callName
		 * 此时之类的实例变量baseName还没有初始化，所以是null
		 * @author sruby on 2016年9月17日 下午11:40:14
		 */
		public void callName()
		{
			System.out.println(baseName);
		}
	}
	
	public static void main(String[] args)
	{
		Base b = new Sub();
	}
}