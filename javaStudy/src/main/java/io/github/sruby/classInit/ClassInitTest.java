package io.github.sruby.classInit;

import java.util.HashMap;
import java.util.Map;

/**
  * 类和对象初始化过程：静态变量或静态方法初始化和static代码块执行-》成员变量初始化-》构造函数执行
 * 静态变量、方法和静态代码块初始化优先级按照代码顺序
 * @author sruby on 2016年12月27日 下午10:58:53
 */
public class ClassInitTest
{
	//此处定义的静态变量，导致整个类的初始化顺序变成：成员变量-》构造函数-》静态代码块-》静态方法-》静态变量
//	private static final ClassInitTest CLASS_INIT_TEST = new ClassInitTest();
	private static ClassInitTest CLASS_INIT_TEST;
	
	private static Map<String, String> cache = new HashMap<>();
	
	private static Person personStatic = new Person("personStatic"); 
	private Person person = new Person("person"); 
	
	static
	{
		System.out.println("static block!");
		cache.put("beijing", "1");
//		initData();
	}
	
	
	
	private ClassInitTest()
	{
		System.out.println("constructor");
		/**
		 * 在对象初始化的时候，处理静态方法和静态变量。会导致类初始化错误。
		 * 因为类还没有初始化完成。
		 */
//		initData();
	}
	
	private static void initData()
	{
		System.out.println("static method");
		cache.put("上海", "2");
	}
	
	public static ClassInitTest getInstance()
	{
		System.out.println("getInstance");
//		return CLASS_INIT_TEST;
		if(CLASS_INIT_TEST == null)
		{
			CLASS_INIT_TEST = new ClassInitTest();
		}
		return CLASS_INIT_TEST;
	}
	
	
	
	public static void main(String[] args)
	{
		System.out.println(ClassInitTest.getInstance().cache);
	}
}
