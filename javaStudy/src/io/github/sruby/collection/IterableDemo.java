package io.github.sruby.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author sruby
 *
 */
public class IterableDemo
{
	
	public static void main(String[] args)
	{
		List<String> list = new ArrayList<>();
		list.add("1");
		forEach(list);
		
//		Map<String, String> map = new HashMap<>();
//		map.put("key", "value");
//		forEach(map);
		Set<String> set = new HashSet<>();
		set.add("key");
		forEach(set);
	}
	
	public static void forEach(Iterable iterable)
	{
		for (Object object : iterable)
		{
			System.out.println(object.toString());
		}
	}
}
