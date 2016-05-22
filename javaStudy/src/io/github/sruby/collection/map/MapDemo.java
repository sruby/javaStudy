package io.github.sruby.collection.map;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * Map
 * @author liuwf on 2016年5月22日 下午11:03:03
 */
public class MapDemo
{
	/**
	 * 使用对象作为map的key;
	 * 实际上是使用对象的引用地址作为key
	 * @author liuwf on 2016年5月23日 上午12:09:06
	 */
	@Test
	public void keyWithObject()
	{
		Map map = new HashMap<>();
		map.put(new String("1"), "ObjectValue");
		Object obj = new Object();
		map.put(obj, "obj");
		
		String str = (String) map.get(new String("1"));
		Object object = map.get(obj);
		System.out.println(str); //ObjectValue
		System.out.println(object); //obj
	}
}
