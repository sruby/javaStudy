package io.github.sruby.concurrent;

/**
 * 多线程相关
 * @author liuwf on 2016年5月28日 下午9:14:49
 */
public class ConcurrentTest
{
	//并发在count的值在1百万以上时运行会比串行明显要快
	private static long count = 1000000000L;
	public static void main(String[] args)
	{
		concurrent();
		serial();
	}
	
	public static void concurrent()
	{
		System.out.println("concurrent"+System.currentTimeMillis());
		int  c = 0;
		Thread thread = new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				long i = 0L;
				for (int j = 0; j < count; j++)
				{
					i += j ;
//					System.out.println(c);
				}
			}
		});
		thread.start();
		
		System.out.println("concurrent"+System.currentTimeMillis());
		long b = 0L;
		for (long i = 0; i < count; i++)
		{
			b += i;
		}
		System.out.println("concurrent"+System.currentTimeMillis());
	}
	
	public static void serial()
	{
		System.out.println(System.currentTimeMillis());
		long i = 0L;
		for (int j = 0; j < count; j++)
		{
			i += j ;
		}
		
		System.out.println(System.currentTimeMillis());
		long b = 0L;
		for (long a = 0; a < count; a++)
		{
			b += a;
		}
		System.out.println(System.currentTimeMillis());
	}
}
