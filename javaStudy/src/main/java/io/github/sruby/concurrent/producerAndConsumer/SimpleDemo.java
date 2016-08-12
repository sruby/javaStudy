package io.github.sruby.concurrent.producerAndConsumer;

/**
 * 简单的生产者消费者模型，只有一个生产者线程和一个消费者线程
 * @author liuwf on 2016年8月10日 下午4:08:06
 */
public class SimpleDemo
{
	public static void main(String[] args)
	{
		SimpleDemo demo = new SimpleDemo();
		Info info = demo.new Info();
		
		Producer producer = demo.new Producer(info);
		Consumer consumer = demo.new Consumer(info);
		
		Thread threadProducer = new Thread(producer);
		Thread threadConsumer = new Thread(consumer);
		
		threadProducer.start();
		threadConsumer.start();
	}
	
	class Info
	{
		private String name;
		private String content;
		private boolean flag = true;	//默认的标志位，可以生产
		
		public synchronized void set(String name,String content) throws InterruptedException
		{
			if(!flag)
			{
				this.wait();
			}
			
			
			Thread.sleep(2000L);
			
			this.name = name;
			this.content = content;
			flag = false;
			this.notify();
		}
		
		public  synchronized String get() throws InterruptedException
		{
			if(flag)
			{
				this.wait();
			}
			
			flag = true;
			this.notify();
			return this.name+this.content;
		}
	}
	
	/**
	 * 生产者
	 * @author liuwf on 2016年8月10日 下午4:42:37
	 */
	class Producer implements Runnable
	{
		Info info;
		public Producer(Info info)
		{
			this.info = info;
		}
		
		@Override
		public void run()
		{
			for (int i = 0; i < 10; i++)
			{
				try
				{
					this.info.set("张三"+i, "张三的内容"+i);
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		}
		
	}
	
	/**
	 * 消费者
	 * @author liuwf on 2016年8月10日 下午4:42:45
	 */
	class Consumer implements Runnable
	{
		Info info;
		public Consumer(Info info)
		{
			this.info = info;
		}

		@Override
		public void run()
		{
			for (int i = 0; i < 10; i++)
			{
				try
				{
					System.out.println(this.info.get());
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		}
		
	}
}
