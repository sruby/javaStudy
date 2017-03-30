package io.github.sruby.messagequeue.my;

/**
 * 消息队列基本使用
 * @author sruby on 2016年12月11日 下午11:16:42
 */
public class MessageQueueClient
{
	public static void main(String[] args)
	{
		final MyMessageQueue messageQueue = new MyMessageQueue();
		
		new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				try
				{
					for (int i = 0; i < 100; i++)
					{
//						Thread.sleep(100L);
						messageQueue.addMessage(i);
					}
					
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		}).start();
		
		new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				try
				{
					for (int i = 100; i < 200; i++)
					{
//						Thread.sleep(100L);
						messageQueue.addMessage(i);
					}
					
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		}).start();
		
		
		new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				try
				{
					while (true)
					{
						Object message = messageQueue.getMessage();
						System.out.println(message);
					}
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		}).start();
	}
}
