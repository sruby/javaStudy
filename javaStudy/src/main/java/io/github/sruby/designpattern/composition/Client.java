package io.github.sruby.designpattern.composition;

import java.util.Iterator;
import java.util.List;

/**
 * 安全的组合模式：
 * 高层模块直接关联了具体的实现类，违反了依赖倒转原则
 * @author sruby on 2016年9月20日 下午10:41:37
 */
public class Client
{
	public static void main(String[] args)
	{
		Composition root = new Composition();
		
		/**
		 * 具体实现类
		 */
		Composition branch = new Composition(); 
		
		Leaf leaf = new Leaf();
		
		branch.add(leaf);
		
		root.add(branch);
		
		display(root);
	}

	private static void display(Composition root)
	{
		List<Component> childs = root.getChilds();
		for (Iterator iterator = childs.iterator(); iterator.hasNext();)
		{
			Component component = (Component) iterator.next();
			if (component instanceof Leaf)
			{
				component.operate();
			}
			if (component instanceof Composition)
			{
				component.operate();
				/**
				 * 向下强转
				 */
				display((Composition)component);
				
			}
		}
	}
}
