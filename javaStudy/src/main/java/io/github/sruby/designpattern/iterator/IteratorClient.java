package io.github.sruby.designpattern.iterator;

import java.util.Iterator;

public class IteratorClient
{
	public static void main(String[] args)
	{
		ConcreteAggregate aggregate = new ConcreteAggregate();
		aggregate.add(1);
		aggregate.add(2);
		aggregate.add(3);
		Iterator createIterator = aggregate.createIterator();
		while (createIterator.hasNext())
		{
			Object object = (Object) createIterator.next();
			System.out.println(object);
		}
	}
}
