package io.github.sruby.annotation.point;

/**
 * 积分前置业务处理类
 * @author liuwf on May 6, 2017 3:25:51 PM
 */
public interface PointHandle
{
	/**
	 * 前置业务处理方法
	 * @author liuwf on May 6, 2017 4:03:18 PM
	 * @param ruleNo 积分编号
	 */
	public void invoke(String ruleNo);
}
