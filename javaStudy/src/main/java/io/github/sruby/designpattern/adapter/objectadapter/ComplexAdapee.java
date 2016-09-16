package io.github.sruby.designpattern.adapter.objectadapter;

import io.github.sruby.designpattern.adapter.norm.Adapee;

/**
 * 复杂的适配源：依赖多个接口，无法通过继承的方式类实现适配
 * @author sruby on 2016年9月16日 下午3:46:13
 */
public class ComplexAdapee
{
	Adapee adapee;
	Adapee2 adapee2;
	
	
	public ComplexAdapee(Adapee adapee, Adapee2 adapee2)
	{
		super();
		this.adapee = adapee;
		this.adapee2 = adapee2;
	}


	public void specialRequest()
	{
		adapee.specialRequest();
	}
	
	public void specialResponse()
	{
		adapee2.specialResponse();
	}
}
