package io.github.sruby.concurrent;

public class JoinTest2 implements Runnable
{
	
	
	public static int a = 0;
	
	public void run()
	{
		for (int k = 0; k < 5; k++)
		{
			a = a + 1;
		}
	}
	
	public static void main(String[] args) throws Exception
	{
		Runnable r = new JoinTest2();
		Thread t = new Thread(r);
		t.start();
		///Thread.sleep(1000L); //在此处加上sleep,让main线程睡眠1s,则可以输出5
		t.join(); //t线程加入main线程执行
		System.out.println(a); //out : 0,t线程还没有执行
	}
}
