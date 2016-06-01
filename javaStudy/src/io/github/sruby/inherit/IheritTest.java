package io.github.sruby.inherit;


public class IheritTest
{
	public static void main(String[] args)
	{
		//调用无参构造函数
		Person person = new Coder();
		
		//无法编译通过,构造函数只能调用,不能被继承
//		Person coder = new Coder(1);
		
		Person person3 = new Person(1);
	}
	
}

class Person
{
	public Person()
	{
		
	}
	
	public Person(int age)
	{
		System.out.println(age);
	}
}

class Coder extends Person
{
	
}
