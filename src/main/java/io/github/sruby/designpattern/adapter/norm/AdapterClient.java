package io.github.sruby.designpattern.adapter.norm;

/**
 * 类适配模式，通过Adapter集成适配源来实现
 * @author sruby on 2016年9月16日 下午3:49:17
 */
public class AdapterClient
{
	public static void main(String[] args)
	{
		Target target = new TargetImpl();
		target.request();
		
		Target target2 = new Adapter();
		target2.request();
	}
}
