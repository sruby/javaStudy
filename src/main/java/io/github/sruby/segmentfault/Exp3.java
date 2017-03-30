package io.github.sruby.segmentfault;

import java.lang.reflect.*;

public class Exp3
{
	public static void main(String[] args)
	{
		A a1 = new A();
		Class<?> c = A.class;
		try
		{
			Method m = c.getMethod("print", new Class[] { int.class, int.class });
			Object o = m.invoke(a1, new Object[] { 10, 20 });
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}

class A
{
	
	public void print(int a, int b)
	{
		System.out.println(a + b);
	}
	
	public void print(String a, String b)
	{
		System.out.println(a.toUpperCase() + "," + b.toLowerCase());
	}
}