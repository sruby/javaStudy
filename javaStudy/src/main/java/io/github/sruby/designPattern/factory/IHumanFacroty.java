package io.github.sruby.designPattern.factory;

/**
 * 人类工厂借口
 * @author sruby on 2016年9月4日 下午6:21:15
 */
public interface IHumanFacroty
{
	/**
	 * 造人
	 * @author sruby on 2016年9月4日 下午6:21:45
	 * @param human
	 */
	public AbstractHuman createHuman(AbstractHuman human) throws InstantiationException, IllegalAccessException, CloneNotSupportedException;
}
