package io.github.sruby.concurrent;

/**
 * 新建线程
 * @author sruby on 2016年7月17日 下午11:45:15
 */
public class NewThreadTest
{
	public static void main(String[] args) throws Exception
	{
		/**
		 * new Thread才会创建新的线程. Runnable只是在原有的线程上运行
		 * 原因:Thread或Runnable的run方法,只会执行同一个线程中的任务,而不会启动新线程;
		 * Thread.start将创建一个执行run方法的新线程.(java核心卷一 p627)
		 */
		threadFactory();
		
		threadFactory();
		
		new Runnable()
		{
			public void run()
			{
				while (true)
				{
					try
					{
						Thread.sleep(1000L);
					}
					catch (InterruptedException e)
					{
						e.printStackTrace();
					}
					System.out.println("Runnable"+Thread.currentThread().getId());
				}
			}
		}.run();
		
		
		
		while (true)
		{
			System.out.println("main"+Thread.currentThread().getId());
		}
	}

	private static void threadFactory()
	{
		new Thread(new Runnable()
		{
			public void run()
			{
				while (true)
				{
					try
					{
						Thread.sleep(1000L);
					}
					catch (InterruptedException e)
					{
						e.printStackTrace();
					}
					System.out.println("Thread"+Thread.currentThread().getId());
				}
			}
		}).start();
	}
}
