package io.github.sruby.statictest;

/**
 * 测试类的初始化顺序:
 * 父类静态代码块-》子类静态代码块-》父类代码块-》父类构造函数-》子类代码块-》子类构造函数
 * @author liuwf on 2016年12月26日 下午8:26:39
 */
public class StaticTest
{
	public static void main(String[] args)
	{
		Son son = new Son();
	}
}
