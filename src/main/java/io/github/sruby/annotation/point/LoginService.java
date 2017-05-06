package io.github.sruby.annotation.point;

/**
 * 登陆业务
 * @author liuwf on May 6, 2017 3:11:50 PM
 */
public class LoginService implements PointRelationsBusiness
{
	@PointAnnotation(pointRuleNo="1000",beforeClass="loginServicePointHandle")
	public void login()
	{
		System.out.println("login");
	}
}
