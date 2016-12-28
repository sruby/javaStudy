package io.github.sruby.concurrent.threadpool;

import java.util.concurrent.Callable;


public class MyCallback implements Callable<Integer>
{

	@Override
	public Integer call() throws Exception
	{
		System.out.println("call back");
		return 1+1;
	}
	
}
