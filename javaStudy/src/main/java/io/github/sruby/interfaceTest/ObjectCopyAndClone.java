package io.github.sruby.interfaceTest;

import java.util.Date;

import io.github.sruby.bean.Employee;

/**
 * 对象拷贝和克隆
 * @author sruby on 2016年8月14日 下午11:20:49
 */
public class ObjectCopyAndClone
{
	public static void main(String[] args) throws CloneNotSupportedException
	{
		Employee employee = new Employee("test", 21, 5000);
		//拷贝，引用的是同一个对象
		Employee employeeCopy = employee;
		Date hireDate = new Date();
		employee.setHireDate(hireDate);
		System.out.println(hireDate);
		
		employeeCopy.setAge(27);
		System.out.println(employee.getAge());
		
		//克隆，employeeClone引用了与employee不同的对象
		Employee employeeClone = employee.clone();
		
		/**
		 * 默认是浅拷贝，并没有克隆对象中的内部对象
		 * 1、子对象不可变，比如String，则不会有影响
		 * 2、子对象可变的，比如Date
		 */
		String name = employeeClone.getName();
		name = "test22";
		Date hireDateClone = employeeClone.getHireDate();
		hireDateClone.setYear(2008);
		System.out.println(hireDateClone);
		
		/**
		 * 重置对象内部的子对象，不能反应浅拷贝的问题
		 */
//		Date dateClone = new Date(10000L);
//		employeeClone.setHireDate(dateClone);
//		System.out.println(dateClone);
		
		System.out.println(employee.getName());
		System.out.println(employeeClone.getName());
		
		System.out.println(employee.getHireDate());
		System.out.println(employeeClone.getHireDate());
		
	}
}
