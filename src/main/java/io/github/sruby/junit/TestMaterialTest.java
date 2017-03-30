package io.github.sruby.junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * junit测试用例
 * @author liuwf on 2017年1月24日 下午4:00:33
 */
public class TestMaterialTest
{
	/**
	 * 创建固定装置，例如，打开一个网络连接
	 * 当前类中每个测试方法执行都会先执行此方法
	 * @author liuwf on 2017年1月24日 下午4:00:30
	 */
	@Before
	public void setUp()
	{
		System.out.println("setUp");
	}
	
	@Test
	public void testMyMethod()
	{
		System.out.println("Not yet implemented");
	}
	
	@Test
	public void testMyMethod2()
	{
		System.out.println("Not yet implemented");
	}
	
	/**
	 * 拆除固定装置，例如，关闭一个网络连接
	 * 当前类中每个测试方法执行完都会执行此方法
	 * @author liuwf on 2017年1月24日 下午4:01:59
	 */
	@After
	public void tearDown()
	{
		System.out.println("tearDown");
	}
	
}
