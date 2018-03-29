package io.github.sruby.bean;


public class EmployeeImpl extends Employee
{

	public EmployeeImpl(String name, int age, int salary)
	{
		super(name, age, salary);
	}
	
	/**
	 * 在子类的内部重新实现受保护的方法，以便外部调用
	 * @author sruby on 2016年8月15日 上午12:13:44
	 */
	@Override
	public void protectedTest()
	{
		super.protectedTest();
	}
}
