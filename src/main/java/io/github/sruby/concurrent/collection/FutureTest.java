package io.github.sruby.concurrent.collection;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;


public class FutureTest
{
	public static void main(String[] args)
	{
		Future<String> future = new Future<String>()
		{
			
			@Override
			public boolean isDone()
			{
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean isCancelled()
			{
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public String get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException
			{
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String get() throws InterruptedException, ExecutionException
			{
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public boolean cancel(boolean mayInterruptIfRunning)
			{
				// TODO Auto-generated method stub
				return false;
			}
		};
	}
}
