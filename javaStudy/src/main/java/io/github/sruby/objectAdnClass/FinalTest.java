package io.github.sruby.objectAdnClass;

import java.util.Date;

/**
 * final
 * @author sruby on 2016年8月15日 上午12:41:11
 */
public class FinalTest
{
	public static void main(String[] args)
	{
		final int a = 1;
		//不可改变对象的引用
//		a = 2;
		
		/**
		 * final只是表示不能改变对象的引用，一般用来修饰基本数据类型或者不可变对象String；
		 * 修饰Date这样的可变对象会造成混乱，对象内部的变量还是可以改变。
		 */
		final Date date = new Date();
		System.out.println(date);
		date.setHours(11);
		System.out.println(date);
	}
}
