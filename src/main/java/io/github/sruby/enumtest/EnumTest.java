package io.github.sruby.enumtest;

import org.junit.Test;

/**
 * 枚举的使用
 * @author sruby on 2016年9月16日 下午1:14:46
 */
public class EnumTest
{
	/**
	 * 普通枚举常量
	 * @author sruby on 2016年9月16日 下午1:16:50
	 */
	@Test
	public void test()
	{
		System.out.println(EnumNorm.GREEN);
	}
	
	/**
	 * 带构造函数的枚举
	 * @author sruby on 2016年9月16日 下午1:21:29
	 */
	@Test
	public void testConstructionEnum()
	{
		System.out.println(ConstructionEnum.MEDIUM.getName());
	}
	
	/**
	 * 带构造函数的枚举
	 * @author sruby on 2016年9月16日 下午1:21:29
	 */
	@Test
	public void testAbstractMethodEnum()
	{
		AbstractMethodEnum.MEDIUM.doSomething();
		AbstractMethodEnum.SMALL.doSomething();
	}
	
}
