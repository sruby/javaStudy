package io.github.sruby.classInit;

import java.util.HashMap;
import java.util.Map;

/**
 * 类初始化和对象初始化过程
 * 
 * @author sruby on 2016年12月27日 下午10:58:53
 */
public class ClassInitTest2
{
	//TODO ?
	//此处定义的静态变量，导致整个类的初始化顺序变成：成员变量-》构造函数-》静态代码块-》静态方法-》静态变量
	//个人认为原因：CLASS_INIT_TEST作为静态变量，但是又执行了对象的初始化。所以导致ClassInitTest2类的初始化被延后了。
	private static final ClassInitTest2 CLASS_INIT_TEST = new ClassInitTest2();
	
	private static Map<String, String> cache = new HashMap<>();
	
	static
	{
		System.out.println("static block!");
		cache.put("beijing", "1");
		initData();
	}
	
	private static Person personStatic = new Person("personStatic"); 
	private Person person = new Person("person"); 
	
	private ClassInitTest2()
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
	
	public static ClassInitTest2 getInstance()
	{
		System.out.println("getInstance");
		return CLASS_INIT_TEST;
//		return new ClassInitTest2();
	}
	
	
	
	public static void main(String[] args)
	{
		System.out.println(ClassInitTest2.getInstance().cache);
	}
}
