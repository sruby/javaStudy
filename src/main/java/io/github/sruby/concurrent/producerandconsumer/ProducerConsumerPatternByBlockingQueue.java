package io.github.sruby.concurrent.producerandconsumer;

import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 使用BlockingQueue实现生产者消费者模式
 * @author sruby on 2016年12月11日 下午10:57:37
 */
public class ProducerConsumerPatternByBlockingQueue
{
	
	public static void main(String[] args)
	{
		BlockingQueue blockingQueue = new ArrayBlockingQueue<>(100);
		Producer producer = new ProducerConsumerPatternByBlockingQueue().new Producer(blockingQueue);
		Consumer consumer = new ProducerConsumerPatternByBlockingQueue().new Consumer(blockingQueue);
		
		new Thread(producer).start();;
		new Thread(consumer).start();;
	}
	
	class Producer implements Runnable
	{
		private BlockingQueue blockingQueue;
		
		public Producer(BlockingQueue blockingQueue){
			this.blockingQueue = blockingQueue;
		}

		@Override
		public void run()
		{
			while (true)
			{
				try
				{
					blockingQueue.put(new Date().toGMTString());
					Thread.sleep(1000L);
					System.out.println(blockingQueue);
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		}
		
	}
	
	class Consumer implements Runnable{
		private BlockingQueue blockingQueue;
		
		public Consumer(BlockingQueue blockingQueue){
			this.blockingQueue = blockingQueue;
		}
		
		@Override
		public void run()
		{
			while (true)
			{
				Object take;
				try
				{
					System.out.println(blockingQueue);
					take = blockingQueue.take();
					System.out.println(take);
					Thread.sleep(3000L);
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		}
	}

		
}
