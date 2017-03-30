package io.github.sruby.concurrent;

/**
 * 线程中断
 * @author sruby on 2016年6月12日 下午11:55:27
 */
public class ThreadInterrupt
{
	public static void main(String[] args)
	{
		Thread currentThread = Thread.currentThread();
		//flase
		System.out.println(currentThread.isInterrupted());
		
		//interrupt中断线程.线程中断状态为true
		Thread.currentThread().interrupt();
		System.out.println(currentThread.isInterrupted());
		
		//isInterrupted,实例方法,获取线程的中断状态,不改变当前线程的状态.依然是true
		while (!Thread.currentThread().isInterrupted())
		{
			System.out.println("线程没有中断1");
		}
		System.out.println(currentThread.isInterrupted());
		
		//interrupted静态方法,改变线程状态为false.
		while (!Thread.interrupted())
		{
			System.out.println("线程没有中断2");
		}
		System.out.println(currentThread.isInterrupted());
		while (!Thread.interrupted())
		{
			System.out.println("线程没有中断3");
		}
	}
}
