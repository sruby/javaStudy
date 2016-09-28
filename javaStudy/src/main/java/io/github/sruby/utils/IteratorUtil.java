package io.github.sruby.utils;

import java.util.Iterator;

/**
 * 迭代
 * @author liuwf on 2016年5月23日 上午1:14:44
 */
public class IteratorUtil
{
	public static void iterate(Iterable iterable)
	{
		Iterator iterator = iterable.iterator();
		for (; iterator.hasNext();)
		{
			Object obj = iterator.next();
			SoutUtil.systou(obj);
		}
	}
}
