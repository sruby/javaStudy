package io.github.sruby.designpattern.iterator;

import java.util.Iterator;
import java.util.Vector;

/**
 * 迭代器实现类
 * @author sruby on 2016年9月17日 下午8:56:18
 */
public class ConcreteIterator implements Iterator
{
	private Vector vector;
	private int cursor = 0;
	public ConcreteIterator(Vector vector)
	{
		super();
		this.vector = vector;
	}

	@Override
	public boolean hasNext()
	{
		return this.cursor != this.vector.size();
	}


	@Override
	public void remove()
	{
		this.vector.remove(cursor++);
	}

	@Override
	public Object next()
	{
		return this.vector.get(cursor++);
	}
	
	
}
