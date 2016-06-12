package io.github.sruby.concurrent;

/**
 * 守护线程
 * @author sruby on 2016年6月13日 上午12:12:31
 */
public class DaemonThread
{
	public static void main(String[] args)
	{
		Thread thread = new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				while (true)
				{
					System.out.println("Daemon thread");
				}
				
			}
		});
		
		//当此线程不存在时,thread守护线程会停止
		new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				while (true)
				{
					System.out.println("son thread");
				}
			}
		}).start();
		
		thread.setDaemon(true);
		
		thread.start();
		
	}
}
