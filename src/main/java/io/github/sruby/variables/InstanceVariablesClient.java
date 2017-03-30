package io.github.sruby.variables;

import io.github.sruby.variables.domain.Person;

public class InstanceVariablesClient
{
	public static void main(String[] args)
	{
		Person person = new Person();
		/**
		 * 实例变量默认初始化：int：0；String：null（对象默认初始值为null，String是对象）
		 */
		System.out.println(person.getAge()+person.getName());
		
		/**
		 * 局部变量不会默认初始化，所以19行报错（The local variable localVariables may not 
		 * have been initialized），无法编译
		 */
		int localVariables;
//		System.out.println(localVariables);
	}
}
