package io.github.sruby.collection.queue;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 队列
 * @author liuwf on 2016年8月10日 下午5:18:14
 */
public class QueueTest
{
	public static void main(String[] args)
	{
		Queue<String> queue = new LinkedBlockingQueue<String>();
		queue.add("1");
		queue.add("2");
		queue.offer("3");
		//队列头部取出元素
		String poll = queue.poll();
		System.out.println(poll);
		//队列头部取出元素，与poll的区别是为空时抛出异常
		String remove = queue.remove();
		System.out.println(remove);
		//队列投顾取出元素，但是不删除
		String peek = queue.peek();
		System.out.println(peek);
		System.out.println(queue);
	}
}
