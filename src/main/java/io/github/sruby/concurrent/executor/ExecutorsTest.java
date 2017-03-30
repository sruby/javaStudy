package io.github.sruby.concurrent.executor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 线程池使用
 * @author sruby on 2016年7月25日 上午2:23:23
 */
public class ExecutorsTest
{
	public static void main(String[] args) throws InterruptedException, ExecutionException
	{
		//1、创建一个缓存线程池:必要时会创建新线程,空闲超过60s,线程会被销毁
		ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
		Future<?> submit = newCachedThreadPool.submit(new Runnable()
		{
			public void run()
			{
				System.out.println(111);
			}
		});
		
		Object object = submit.get();
		
		System.out.println(submit.isDone());
		System.out.println(submit.isCancelled());
		
		//2、创建一个固定大小的线程池
		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(10);
		Future<?> submit2 = newFixedThreadPool.submit(new Runnable()
		{
			
			@Override
			public void run()
			{
				
			}
		});
	}
}
