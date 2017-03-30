package io.github.sruby.designpattern.adapter.norm;

/**
 * 适配器类：实现目标接口，集成适配源
 * @author sruby on 2016年9月16日 下午3:47:16
 */
public class Adapter extends Adapee implements Target
{

	@Override
	public void request()
	{
		super.specialRequest();
	}
}
