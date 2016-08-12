package io.github.sruby.concurrent.executor;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 定时执行线程
 * @author liuwf on 2016年8月10日 下午3:14:21
 */
public class ScheduledExecutorServiceTest
{
	public static void main(String[] args)
	{
		ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(1);
		
		/*
		 * command：线程任务；delay：延迟时长；unit ：时间单位
		 */
		scheduledExecutorService.schedule(new Runnable()
		{
			@Override
			public void run()
			{
				System.out.println(111);
			}
		}, 100, TimeUnit.MILLISECONDS);
		
		
		/*
		 * 关闭线程池，关闭后不再接收新的线程
		 */
		scheduledExecutorService.shutdown();
	}
}
