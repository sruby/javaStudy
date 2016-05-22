package io.github.sruby.collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import io.github.sruby.utils.SoutUtil;

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
			SoutUtil.systou(object.toString());
		}
	}
	
	/**
	 * iterable,iterator区别:
	 * An Iterable is a simple representation of a series of elements that can be iterated over. It does not have any iteration state such as a "current element". Instead, it has one method that produces an Iterator.
	 * An Iterator is the object with iteration state. It lets you check if it has more elements using hasNext() and move to the next element (if any) using next().
     * Typically, an Iterable should be able to produce any number of valid Iterators.
	 * @author liuwf on 2016年5月23日 上午12:18:41
	 */
	@Test
	public void iterableAndIterator()
	{
		//
		Iterable<String> iterable = new ArrayList<>();
		
		Iterator<String> iterator = iterable.iterator();
		
		for (; iterator.hasNext();)
		{
			String str = iterator.next();
			SoutUtil.systou(str);
		}
	}
}
