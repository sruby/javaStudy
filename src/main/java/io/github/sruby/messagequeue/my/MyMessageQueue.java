package io.github.sruby.messagequeue.my;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 一个简单的消息队列
 * @author sruby on 2016年12月11日 下午11:08:58
 */
public class MyMessageQueue
{
	public static BlockingQueue blockingQueue = new ArrayBlockingQueue<>(100);
	
	public synchronized void addMessage(Object object) throws InterruptedException
	{
		blockingQueue.put(object);
		System.out.println(blockingQueue);
		System.out.println(blockingQueue.size());
	}
	
	public synchronized Object getMessage() throws InterruptedException
	{
		System.out.println(blockingQueue);
		System.out.println(blockingQueue.size());
		return blockingQueue.take();
	}
}
