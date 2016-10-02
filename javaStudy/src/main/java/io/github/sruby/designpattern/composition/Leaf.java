package io.github.sruby.designpattern.composition;

/**
 * 叶子构件
 * @author sruby on 2016年9月20日 下午9:58:56
 */
public class Leaf extends Component
{
	@Override
	public void operate()
	{
		System.out.println("leaf");
	}
}
