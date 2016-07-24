package io.github.sruby.concurrent.lock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest
{
	/**
	 * 每个对象都有自己的ReentrantLock对象,如果在方法内部声明初始化,则不能达到锁的目的
	 * Synchronize是隐式的使用锁,lock是显式的
	 */
	private static ReentrantLock lock = new ReentrantLock();
	/**
	 * 加上true的参数,初始化的是一个公平锁,公平锁偏爱等待时间长的线程,但是会影响性能
	 */
	private static ReentrantLock fireLock = new ReentrantLock(true);
	
	public static void main(String[] args)
	{
		new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				test();
			}
		}).start();
		
		new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				test();
			}
		}).start();
		
	}
	
	public static void test()
	{
		
		lock.lock();
		try
		{
			System.out.println("critical section!");
			Thread.sleep(3000L);
		}
		catch (Exception e)
		{
			
		}
		finally 
		{
			lock.unlock();
		}
	}
}
