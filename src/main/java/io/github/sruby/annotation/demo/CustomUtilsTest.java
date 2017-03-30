package io.github.sruby.annotation.demo;

import org.junit.Test;

/**
 * 测试类
 * http://wiki.jikexueyuan.com/project/java-reflection/java-at.html
 * @author liuwf on 2017年3月30日 下午4:59:44
 */
public class CustomUtilsTest
{
	@Test
	public void testCustomUtils()
	{
		CustomUtils.getInfo(Person.class);
	}
}
