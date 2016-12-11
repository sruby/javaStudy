package io.github.sruby.concurrent.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程池
 * @author sruby on 2016年12月12日 上午12:47:46
 */
public class ThreadPoolClient
{
	
	public static void main(String[] args)
	{
		/**
		 * 实现自定义的ThreadFactory，可以对线程的创建做处理
		 */
		ExecutorService cachedThreadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 1, new ThreadFactory()
		{
			
			private AtomicInteger count = new AtomicInteger();
			
			public Thread newThread(Runnable r)
			{
				int c = count.incrementAndGet();
				System.out.println("create no " + c + " Threads");
				return new WorkThread(r, count);
				
			}
		});
		
		cachedThreadPool.execute(new MyThread());
		cachedThreadPool.execute(new MyThread());
		cachedThreadPool.execute(new MyThread());
		cachedThreadPool.execute(new MyThread());
		cachedThreadPool.execute(new MyThread());
		cachedThreadPool.shutdown();
	}
}
