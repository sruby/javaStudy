package io.github.sruby.classInit;

/**
 * 类和对象初始化过程：静态变量初始化和static代码块执行-》成员变量初始化-》构造函数执行
 * 静态变量和静态代码块初始化优先级按照代码顺序
 * @author sruby on 2016年12月27日 下午11:53:20
 */
public class SampleTest
{
	private static Sample sam = new Sample("静态成员sam初始化");
	
	private Sample sam1 = new Sample("sam1成员初始化");
	static
	{
		System.out.println("static块执行");
		if (sam == null)
			System.out.println("sam is null");
		sam = new Sample("静态块内初始化sam成员变量");
	}
	
	SampleTest()
	{
		System.out.println("Test默认构造函数被调用");
	}
	
	public static void main(String str[])
	{
		
		SampleTest a = new SampleTest();
		
	}
}
