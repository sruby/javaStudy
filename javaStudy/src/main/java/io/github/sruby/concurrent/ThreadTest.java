package io.github.sruby.concurrent;

/**
 * thread的继承:
 * 1.继承Thread,无法实现资源的共享.count是每个线程内部的资源
 * 2.单继承,不利于扩展
 * @author liuwf on 2016年6月2日 上午12:54:59
 */
public class ThreadTest
{
	public static void main(String[] args)
	{
//		ThreadSon t = new ThreadSon();
		new ThreadSon().start();
		new ThreadSon().start();
		new ThreadSon().start();
	}
}

class ThreadSon extends Thread
{
//	private int count = 0;
	//为静态变量时可以实现多个线程数据的共享
	private static int count = 0;
	
	@Override
	public void run()
	{
		Thread currentThread = Thread.currentThread();
		System.out.println("线程名:"+currentThread.getName()+"线程id:"
				+currentThread.getId()+",count:"+count+"线程state:"+currentThread.getState());
					count ++;
		synchronized (this)
		{
			while (count < 10)
			{
				System.out.println("线程名:"+currentThread.getName()+"线程id:"
			+currentThread.getId()+",count:"+count+"线程state:"+currentThread.getState());
				count ++;
			}
		}
	}
}
