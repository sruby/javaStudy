package io.github.sruby.designpattern.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * 人类工厂类
 * @author sruby on 2016年9月4日 下午6:20:30
 */
public class HumanFactory implements IHumanFacroty
{
	/**
	 * 缓存
	 */
	private static Map<String, AbstractHuman> humanCache = new HashMap<>();
	
	@Override
	public synchronized AbstractHuman createHuman(AbstractHuman human) throws InstantiationException, IllegalAccessException, CloneNotSupportedException
	{
		String name = human.getClass().getName();
		if(humanCache.containsKey(name))
		{
			return humanCache.get(name).clone();
		}
		else
		{
			AbstractHuman humanObject = human.getClass().newInstance();
			humanCache.put(name, humanObject);
			
			//返回克隆对象，保持内存中对象的纯净。
			return humanObject.clone();
		}
	}
	
}
