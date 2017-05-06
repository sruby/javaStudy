package io.github.sruby.annotation.point;

/**
 * 登陆业务前置处理实现类
 * @author liuwf on May 6, 2017 3:26:21 PM
 */
public class LoginServicePointHandle implements PointHandle
{
	@Override
	public void invoke(String ruleNO)
	{
		System.out.println("登陆业务前置处理");
	}
	
}
