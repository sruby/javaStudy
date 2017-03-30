package io.github.sruby.inherit;

import io.github.sruby.bean.EmployeeImpl;

/**
 * 受保护方法测试
 * @author sruby on 2016年8月15日 上午12:09:01
 */
public class ProtectedTest
{
	public static void main(String[] args)
	{
		EmployeeImpl employeeImpl = new EmployeeImpl("test", 27, 5000);
		employeeImpl.protectedTest();
	}
}
