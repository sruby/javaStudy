package io.github.sruby.concurrent.synchronize;

public class ThreadSafeTest
{
	static volatile int a = 0;
	public static void main(String[] args)
	{
		
		new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				try
				{
					System.out.println(getA(a));
					Thread.sleep(1L);
					System.out.println(getA(a));
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
				
			}
		}).start();
		
		new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				getA(a);
				System.out.println("second:"+a);
			}
		}).start();
		
	}
	
	/**
	 * a的写操作在是线程安全的,避免线程安全问题.
	 * @author sruby on 2016年7月25日 上午2:04:17
	 * @param num
	 * @return
	 */
	public synchronized static int getA(int num){
		a += num;
		return a;
	}
}
