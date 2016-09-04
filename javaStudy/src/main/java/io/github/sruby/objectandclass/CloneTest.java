package io.github.sruby.objectandclass;

import io.github.sruby.bean.Employee;

/**
 * 克隆测试类
 * 
 * @author sruby on 2016年9月4日 下午7:00:31
 */
public class CloneTest
{
	public static void main(String[] args) throws CloneNotSupportedException
	{
		//克隆的类需要实现Cloneable接口，并复写clone方法
		Employee employee = new Employee("test", 1, 1);
		Employee clone = employee.clone();
		System.out.println(clone.getName());
	}
}
