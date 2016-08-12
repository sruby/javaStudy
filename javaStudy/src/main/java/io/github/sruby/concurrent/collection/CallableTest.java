package io.github.sruby.concurrent.collection;

import java.util.concurrent.Callable;


public class CallableTest
{
	public static void main(String[] args) throws Exception
	{
		Callable<String> callable = new Callable<String>()
		{
			@Override
			public String call() throws Exception
			{
				System.out.println(1);
				
				return null;
			}
		};
		
		System.out.println(2);
		callable.call();
	}
}
