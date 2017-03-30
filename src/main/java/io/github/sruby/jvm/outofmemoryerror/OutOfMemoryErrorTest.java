package io.github.sruby.jvm.outofmemoryerror;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * java堆内存溢出验证
 * 需要配置jvm参数：
 * -Xms20m -Xmx20m  -XX:+HeapDumpOnOutOfMemoryError
 * @author liuwf on 2017年1月24日 下午3:41:27
 */
public class OutOfMemoryErrorTest
{
	@Before
	public void setUp()
	{
		System.out.println(toMemoryInfo());
	}
	
	@Test
	public void testOutOfMemoryError()
	{
		List list = new ArrayList<Object>();
		while (true)
		{
			list.add(new Object());
		}
	}
	
	public static String toMemoryInfo()
	{
		Runtime currRuntime = Runtime.getRuntime();
		int nFreeMemory = (int) (currRuntime.freeMemory() / 1024 / 1024);
		int nTotalMemory = (int) (currRuntime.totalMemory() / 1024 / 1024);
		return nFreeMemory + "M/" + nTotalMemory + "M(free/total)";
	}
}
