package io.github.sruby.interfacetest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 接口测试
 * @author sruby on 2016年8月14日 下午11:01:41
 */
public class InterfaceTest
{
	public static void main(String[] args)
	{
		/**
		 * arrays的sort方法只能排序实现了Comparable接口的
		 */
		List<String> list = new ArrayList<>();
		list.add("29");
		list.add("21");
		list.add("23");
		list.add("24");
		Object[] array = list.toArray();
		Arrays.sort(array);
		
		for (int i = 0; i < array.length; i++)
		{
			System.out.println(array[i]);
		}
		
	}
}
