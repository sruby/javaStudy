package io.github.sruby.designpattern.adapter.objectadapter;

/**
 * 目标接口实现类
 * @author sruby on 2016年9月16日 下午3:45:35
 */
public class TargetImpl implements Target
{

	@Override
	public void request()
	{
		System.out.println("TargetImpl->request");
	}

	@Override
	public void responce()
	{
		System.out.println("TargetImpl->responce");
	}
	
}
