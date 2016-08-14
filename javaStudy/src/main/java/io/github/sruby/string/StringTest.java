package io.github.sruby.string;

import java.lang.reflect.Field;

/**
 * 字符串
 * @author sruby on 2016年8月15日 上午12:26:40
 */
public class StringTest
{
	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException
	{
		/**
		 * String 是不可变的对象，
		 * 不可变对象定义：如果一个对象，在它创建完成之后，不能再改变它的状态，那么这个对象就是不可变的。
		 * 不能改变状态的意思是，不能改变对象内的成员变量，包括基本数据类型的值不能改变，
		 * 引用类型的变量不能指向其他的对象，引用类型指向的对象的状态也不能改变。
		 */
		String s = "2222";
		s = "223";
		
		String a = s;
		a = "111";
		System.out.println(s);
		System.out.println(a);
		
		
		/**
		 * 使用反射改变String的值
		 */
		Field declaredField = String.class.getDeclaredField("value");
		declaredField.setAccessible(true);
		char[] charArray = (char[]) declaredField.get(s);
		//改变其第一个值
		charArray[0] = 'a';
		System.out.println(s);
	}
}
