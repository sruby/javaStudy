package io.github.sruby.designpattern.iterator;

import java.util.Iterator;

/**
 * 集合容器接口
 * @author sruby on 2016年9月17日 下午8:55:45
 */
public interface Aggregate
{
	public Iterator createIterator();
}
