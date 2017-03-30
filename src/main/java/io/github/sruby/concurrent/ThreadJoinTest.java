package io.github.sruby.concurrent;

/**
 * join方法的使用
 * hread.Join把指定的线程加入到当前线程，可以将两个交替执行的线程合并为顺序执行的线程。
 * 比如在线程main中调用了线程threadA的Join()方法，直到线程threadA执行完毕后，才会继续执行线程B。
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
//					try
//					{
//						Thread.currentThread().join(3000L);
//					}
//					catch (InterruptedException e)
//					{
//						e.printStackTrace();
//					}
				}
			}
		});
		
		
		threadA.start();
		//join方法不带时间参数时,这会先执行完
		threadA.join(3000L);
		
		long i = 0;
		while (i < 2L)
		{
			try
			{
				Thread.sleep(10L);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			i++;
			System.out.println("main"+Thread.currentThread().getId());
		}
		
	}
}
