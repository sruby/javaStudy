package io.github.sruby.concurrent.collection;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 线程安全的hashmap测试类
 * @author liuwf on 2016年8月10日 下午2:04:49
 */
public class ConcurrentHashMapTest
{
	public static void main(String[] args)
	{
		ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<String, String>();
		concurrentHashMap.put("1", "2");
	}
}
