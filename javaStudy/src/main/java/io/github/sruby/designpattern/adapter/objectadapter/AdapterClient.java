package io.github.sruby.designpattern.adapter.objectadapter;

import io.github.sruby.designpattern.adapter.norm.Adapee;

/**
 * 对象类适配模式，通过类的关联实现
 * @author sruby on 2016年9月16日 下午3:49:17
 */
public class AdapterClient
{
	public static void main(String[] args)
	{
		Adapee adapee = new Adapee();
		Adapee2 adapee2 = new Adapee2();
		Target objectAdapter = new ObjectAdapter(adapee,adapee2);
		objectAdapter.request();
		objectAdapter.responce();
	}
}
