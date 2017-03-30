package io.github.sruby.designpattern.composition;

import java.util.ArrayList;
import java.util.List;

/**
 * 树枝构件
 * @author sruby on 2016年9月20日 下午9:58:03
 */
public class Composition extends Component
{
	private List<Component> list = new ArrayList<Component>();
	
	public void add(Component component)
	{
		list.add(component);
	}
	
	public void remove(Component component)
	{
		list.remove(component);
	}
	
	public List<Component> getChilds()
	{
		return this.list;
	}
	
	@Override
	public void operate()
	{
		System.out.println("composition");
	}
}
