package io.github.sruby.designpattern.iterator;

import java.util.Iterator;
import java.util.Vector;

/**
 * 集合实现类
 * @author sruby on 2016年9月17日 下午8:56:04
 */
public class ConcreteAggregate implements Aggregate
{
	private Vector vector = new Vector<>();
	
	@Override
	public Iterator createIterator()
	{
		return new ConcreteIterator(this.vector);
	}
	
	public void add(Object object)
	{
		this.vector.add(object);
	}
}
