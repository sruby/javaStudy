package io.github.sruby.concurrent;

/**
 * Runnable的实现:
 * 实现资源的共享,count被几个线程共享
 * @author liuwf on 2016年6月2日 上午12:54:59
 */
public class RunnableTest
{
	public static void main(String[] args)
	{
//		ThreadSon t = new ThreadSon();
		RunnableImpl runnableImpl = new RunnableImpl();
		new Thread(runnableImpl).start();
		new Thread(runnableImpl).start();
		new Thread(runnableImpl).start();
	}
}

class RunnableImpl implements Runnable
{
	private int count = 0;
	public void run()
	{
		Thread currentThread = Thread.currentThread();
		
			while (count < 10)
			{
				System.out.println("线程名:"+currentThread.getName()+"线程id:"
			+currentThread.getId()+",count:"+count+"线程state:"+currentThread.getState());
				count ++;
			}
	}
}
