package io.github.sruby.designPattern.singleton;

/**
 * 这种写法仍然使用JVM本身机制保证了线程安全问题；由于 SingletonHolder 是私有的，
 * 除了 getInstance() 之外没有办法访问它，因此它是懒汉式的；
 * 同时读取实例的时候不会进行同步，没有性能缺陷；也不依赖 JDK 版本。
 * 这种方法也是《Effective Java》上所推荐的。
 * 
 * 加载一个类时，其内部类不会同时被加载。一个类被加载，
 * 当且仅当其某个静态成员（静态域、构造器、静态方法等）被调用时发生。 
 * @author sruby on 2016年8月23日 上午12:08:31
 */
public class StaticNestedClassSingleton
{
	static
	{
		System.out.println("load static outer class...");
	}
	
	private static class SingletonHolder
	{
		//内部类在被调用的时候才加载
		static
		{
			System.out.println("load static inner class...");
		}
		
		static void staticInnerMethod()
		{
			System.out.println("static inner method...");
		}
		
		public SingletonHolder()
		{
			System.out.println("SingletonHolder Constructs");
		}
		
		private static StaticNestedClassSingleton nestedClassSingleton = new StaticNestedClassSingleton();
	}
	
	private StaticNestedClassSingleton()
	{
	}
	
	public static StaticNestedClassSingleton getInstance()
	{
		return SingletonHolder.nestedClassSingleton;
	}
	
	public static void main(String[] args)
	{
		for (int i = 0; i < 10; i++)
		{
			StaticNestedClassSingleton instance = getInstance();
			System.out.println(instance.hashCode());
		}
	}
}
