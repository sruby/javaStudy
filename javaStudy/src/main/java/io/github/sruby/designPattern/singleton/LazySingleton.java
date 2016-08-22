package io.github.sruby.designPattern.singleton;

/**
 * 双重锁检测机制
 * http://www.importnew.com/21141.html
 * @author sruby on 2016年8月21日 下午10:51:03
 */
public class LazySingleton
{
	private static LazySingleton lazySingleton = new LazySingleton();
	
	private LazySingleton(){}
	
	public static LazySingleton getInstance()
	{
		//第一重判断
		if(lazySingleton != null)
		{
			return lazySingleton;
		}
		else
		{
			//锁机制
			synchronized (LazySingleton.class)
			{
				//第二重判断
				if(lazySingleton != null)
				{
					lazySingleton = new LazySingleton();	//创建单例对象
				}
			}
		}
		return lazySingleton;
	}
	
	public static void main(String[] args)
	{
		for (int i = 0; i < 10; i++)
		{
			LazySingleton instance = getInstance();
			System.out.println(instance.hashCode());
		}
	}
}
