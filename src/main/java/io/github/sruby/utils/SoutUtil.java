package io.github.sruby.utils;

/**
 * 输出工具类
 * @author liuwf on 2016年5月23日 上午12:50:57
 */
public class SoutUtil
{
	public static void systou(Object...strs)
	{
		if(strs == null)
		{
			System.out.println("strs is null");
			return;
		}
		for (int i = 0; i < strs.length; i++)
		{
			System.out.println("["+strs[i]+"], ");
		}
	}
}
