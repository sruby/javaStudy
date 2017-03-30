package io.github.sruby.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * 集合工具，使用
 * @author liuwf on 2017年1月22日 下午6:14:40
 */
public class CollectionUtils
{
	
	public static List map(List input, Function processor)
	{
		ArrayList result = new ArrayList();
		for (Object object : input)
		{
			result.add(processor.apply(object));
		}
		
		return result;
	}
	
	public static void main(String[] args)
	{
		List input = Arrays.asList(new String[] { "apple", "orange", "pear" });
//		List lengths = CollectionUtils.map(input, (String v) -> v.length());
//		List uppercases = CollectionUtils.map(input, (String v) -> v.toUpperCase());
	}
}
