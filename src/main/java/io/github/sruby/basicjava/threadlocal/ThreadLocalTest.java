package io.github.sruby.basicjava.threadlocal;

import org.junit.Test;

/**
 * 通过ThreadLocal保证单实例的线程安全
 * http://stamen.iteye.com/blog/1535120
 * @author sruby on 2018年3月29日 下午5:21:53
 */
public class ThreadLocalTest
{
	/**
	 * 测试
	 * @author sruby on 2018年3月29日 下午5:22:27
	 */
	@Test
	public void test()
	{	
		/**
		 * 单个实例
		 */
		ThreadLocalTest threadLocalTest = new ThreadLocalTest();
		TestThread testThread = new TestThread(threadLocalTest);
		TestThread testThread2 = new TestThread(threadLocalTest);
		TestThread testThread3 = new TestThread(threadLocalTest);
		
		testThread.start();
		testThread2.start();
		testThread3.start();
	}
	
	private ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>()
			{
				@Override
				public Integer initialValue()
				{
					return 0;
				}
			};
	
	
	
	public Integer getSeqNum()
	{
		return seqNum.get()+1;
	}


	class TestThread extends Thread
	{
		ThreadLocalTest threadLocalTest;
		public TestThread(ThreadLocalTest threadLocalTest)
		{
			this.threadLocalTest = threadLocalTest;
		}
		
		@Override
		public void run()
		{
			System.out.println(Thread.currentThread().getId()+"==="+threadLocalTest.getSeqNum());
		}
	}
	
}
