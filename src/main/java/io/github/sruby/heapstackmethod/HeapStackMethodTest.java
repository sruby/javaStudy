package io.github.sruby.heapstackmethod;

/**
 * 堆、栈、方法区的区别
 * 	堆区: 
	1.存储的全部是对象，每个对象都包含一个与之对应的class的信息。(class的目的是得到操作指令) 
	2.jvm只有一个堆区(heap)被所有线程共享，堆中不存放基本类型和对象引用，只存放对象本身 
	栈区: 
	1.每个线程包含一个栈区，栈中只保存基础数据类型的对象和自定义对象的引用(不是对象)，对象都存放在堆区中 
	2.每个栈中的数据(原始类型和对象引用)都是私有的，其他栈不能访问。 
	3.栈分为3个部分：基本类型变量区、执行环境上下文、操作指令区(存放操作指令)。 
	方法区: 
	1.又叫静态区，跟堆一样，被所有的线程共享。方法区包含所有的class和static变量。 
	2.方法区中包含的都是在整个程序中永远唯一的元素，如class，static变量。 
 * @author sruby on 2016年12月28日 上午12:43:14
 */
public class HeapStackMethodTest	//jvm把HeapStackMethodTest信息放到方法区
{
	private Object object = new Object();  //object-》栈， obect指向的对象-》堆
	private static Object staticObject = new Object(); //静态变量-》方法区， 静态变量指向的对象？
	private int age = 1;
	private static String name; //jvm
	
	public void setAge(int age)  //成员方法-》方法区？
	{
		this.age = age;
	}
	
	public static void printName() //静态方法？
	{
		System.out.println(name);
	}
	
}
