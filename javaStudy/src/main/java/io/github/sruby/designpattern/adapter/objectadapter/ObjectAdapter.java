package io.github.sruby.designpattern.adapter.objectadapter;

import io.github.sruby.designpattern.adapter.norm.Adapee;

/**
 * 对象适配器，源类ComplexAdapee有多个接口依赖
 * @author sruby on 2016年9月16日 下午3:52:40
 */
public class ObjectAdapter implements Target
{
	private Adapee adapee;
	private Adapee2 adapee2;
	
	
	public ObjectAdapter(Adapee adapee, Adapee2 adapee2)
	{
		super();
		this.adapee = adapee;
		this.adapee2 = adapee2;
	}


	@Override
	public void request()
	{
		adapee.specialRequest();
	}


	@Override
	public void responce()
	{
		adapee2.specialResponse();
	}
	
	
}
