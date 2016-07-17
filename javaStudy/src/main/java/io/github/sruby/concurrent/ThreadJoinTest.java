package io.github.sruby.concurrent;

/**
 * join方法的使用
 * @author sruby on 2016年7月18日 上午12:42:25
 */
public class ThreadJoinTest
{
	public static void main(String[] args) throws InterruptedException
	{
		Thread threadA = new Thread(new Runnable()
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
		});
		
		threadA.start();
		
		threadA.wait();
		
		Thread.currentThread().join();
	}
}
