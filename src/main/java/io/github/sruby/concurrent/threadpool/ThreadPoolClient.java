package io.github.sruby.concurrent.threadpool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
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
		
		/**
		 * 使用execute提交执行的任务，execute没有返回值，无法判断是否执行成功
		 */
		cachedThreadPool.execute(new MyThread());
		cachedThreadPool.execute(new MyThread());
		cachedThreadPool.execute(new MyThread());
		cachedThreadPool.execute(new MyThread());
		cachedThreadPool.execute(new MyThread());
		
		/**
		 * 使用submit提交执行的任务,通过返回值future来判断线程执行是否成功，get方法会阻塞直到任务执行完毕再返回结果；
		 * get(long timeout, TimeUnit unit)方法则会阻塞一段时间后立即返回，这时有可能任务没有执行完。
		 */
		Future<?> future = cachedThreadPool.submit(new MyThread());
		
		//callback接口的实现可以返回结果值
		Future<Integer> future2 = cachedThreadPool.submit(new MyCallback());
		try
		{
			//thread没有返回值
			Object object = future.get();
			Integer integer = future2.get();
			System.out.println("callback :"+ integer);
			System.out.println("future:"+object);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		catch( ExecutionException e)
		{
			e.printStackTrace();
		}
		finally
		{
			cachedThreadPool.shutdown();
		}
	}
}
