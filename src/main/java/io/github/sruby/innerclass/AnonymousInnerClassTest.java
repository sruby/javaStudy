package io.github.sruby.innerclass;

/**
 * 匿名内部类
 * @author sruby on 2016年7月18日 上午12:34:58
 */
public class AnonymousInnerClassTest
{
	private static int a;
	public static void main(String[] args)
	{
		int i = 0;
		final int j = 0;
		new Runnable()
		{
			public void run()
			{
				/**
				 * 匿名内部类中只能访问final常量.
				 * reason:
				 * http://stackoverflow.com/questions/1299837/cannot-refer-to-a-non-final-variable-inside-an-inner-class-defined-in-a-differen
				 */
				System.out.println(j+a);
			}
		}.run();
	}
}
