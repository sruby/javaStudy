package io.github.sruby.concurrent.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest
{
	
	public static void main(String[] args)
	{
		for (int i = 0; i < 10; i++)
		{
			new Thread(new Runnable()
			{
				@Override
				public void run()
				{
					ConditionTest conditionTest = new ConditionTest();
					BoundedBuffer boundedBuffer = conditionTest.new BoundedBuffer();
					while(true)
					{
						try
						{
							Thread.sleep(100L);
							System.out.println(Thread.currentThread());
							boundedBuffer.put(100*Math.random());
							boundedBuffer.get();
						}
						catch (InterruptedException e)
						{
							e.printStackTrace();
						}
					}
				}
			}).start();
		}
	}
	
	public class BoundedBuffer
	{
		final Lock lock = new ReentrantLock();
		final Condition notFullCondition = lock.newCondition();
		final Condition notEmptyCondition = lock.newCondition();
		final Object[] items = new Object[100];
		
		int putIndex; //写索引
		int getIndex; //读索引
		int count;   //items中数据的个数
		
		public void put(Object item) throws InterruptedException
		{
			lock.lock();
			try
			{
				if(putIndex == 0)
				{
					System.out.println("count is 0:" + System.currentTimeMillis());
				}
				if(count == items.length)
				{
					System.out.println("notFullCondition.wait");
					notFullCondition.wait();
				}
				
				items[putIndex] = item;
				
				if(++putIndex == items.length)
				{
					putIndex = 0;
				}
				
				System.out.println(++count);
				System.out.println("putIndex"+putIndex+",value:" + item);
				notEmptyCondition.signalAll();
			}
			finally
			{
				lock.unlock();
			}
			
		}
		
		public Object get() throws InterruptedException
		{
			lock.lock();
			try
			{
				if(getIndex == items.length)
				{
					System.out.println("count is max:" + System.currentTimeMillis());
				}
				
				if(count == 0)
				{
					System.out.println("notEmptyCondition.await");
					notEmptyCondition.await();
				}
				
				System.out.println(--count);
				
				if(++getIndex == items.length)
				{
					getIndex = 0; //取到最后一列,从头开始获取
				}
				notFullCondition.signalAll();
				
				System.out.println("getIndex"+getIndex+",value:" + items[getIndex]);
				return items[getIndex];
			}
			finally
			{
				lock.unlock();
			}
		}
	}
}
