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
