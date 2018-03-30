package io.github.sruby.bean;

import java.util.Date;

/**
 * 雇员实体类
 * @author sruby on 2016年8月14日 下午11:22:19
 */
public class Employee implements Cloneable
{
	private String name;
	private int age;
	private int salary;
	private Date hireDate;
	
	public Date getHireDate()
	{
		return hireDate;
	}

	
	public void setHireDate(Date hireDate)
	{
		this.hireDate = hireDate;
	}

	public Employee(String name, int age, int salary)
	{
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public int getAge()
	{
		return age;
	}
	
	public void setAge(int age)
	{
		this.age = age;
	}
	
	public int getSalary()
	{
		return salary;
	}
	
	public void setSalary(int salary)
	{
		this.salary = salary;
	}
	
	/**
	 * clone在Object中是受保护的，所有子类需要重新定义此方法,以便外部调用
	 * @author sruby on 2016年8月15日 上午12:03:19
	 * @return
	 * @throws CloneNotSupportedException
	 */
	@Override
	public Employee clone() throws CloneNotSupportedException
	{
		return (Employee) super.clone();
	}
	
	protected void protectedTest()
	{
		System.out.println("protected");
	}
}
