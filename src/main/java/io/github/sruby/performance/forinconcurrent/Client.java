package io.github.sruby.performance.forinconcurrent;

import org.junit.Test;

/**
 * for循环在高并发下的表现
 * @author liuwf on Jun 19, 2017 8:22:01 PM
 */
public class Client
{
	/**
	 * 线程数
	 */
	long threadNum = 50000L;
	
	/**
	 * 没有for循环的测试(10000-》1246ms)
	 * 50000-》6091
	 * @author liuwf on Jun 19, 2017 8:28:44 PM
	 * @param args
	 */
	@Test
	public void tester()
	{
		long startTime = System.currentTimeMillis();
		/**
		 * 回调函数用来做计时
		 */
		Callback callback = new Callback()
		{
			@Override
			public void countTime()
			{
				System.out.println("花费时间："+(System.currentTimeMillis()-startTime));
			}
		};
		
		
		for (int i = 0; i < threadNum; i++)
		{
			TestThread testThread = new TestThread(i,callback);
			new Thread(testThread).start();
		}
	}
	
	/**
	 * for循环的测试（10000-》1624ms）
	 * 50000-》9478
	 * @author liuwf on Jun 19, 2017 8:28:44 PM
	 * @param args
	 */
	@Test
	public void testInFor()
	{
		long startTime = System.currentTimeMillis();
		/**
		 * 回调函数用来做计时
		 */
		Callback callback = new Callback()
		{
			@Override
			public void countTime()
			{
				System.out.println("花费时间："+(System.currentTimeMillis()-startTime));
			}
		};
		
		for (int i = 0; i < threadNum; i++)
		{
			TestIntForThread testThread = new TestIntForThread(i,callback);
			new Thread(testThread).start();
		}
	}
	
	
	
	class TestThread implements Runnable
	{
		Callback callback;
		private int i ;
		public TestThread(int i,Callback callback)
		{
			this.i = i;
			this.callback = callback;
		}
		
		@Override
		public void run()
		{
			test();
			callback.countTime();
		}
		
		public void test()
		{
			System.out.println("test"+this.i);
		}
	}
	
	class TestIntForThread implements Runnable
	{
		Callback callback;
		private int i ;
		public TestIntForThread(int i,Callback callback)
		{
			this.i = i;
			this.callback = callback;
		}
		
		@Override
		public void run()
		{
			test();
			callback.countTime();
		}
		
		public void test()
		{
			for (int i = 0; i < 10; i++)
			{
				System.out.println("test"+this.i);
			}
		}
	}
	
	interface Callback
	{
		public void countTime();
	}
}
