package io.github.sruby.serializable;

import java.io.Serializable;

/**
 * 需要序列化的类
 * @author liuwf on Jun 10, 2017 3:34:25 PM
 */
public class UserSerializable implements Serializable
{
	/**
	 * 变更serialVersionUID或导致反序列化失败：
	 * java.io.InvalidClassException local class incompatible
	 */
//	private static final long serialVersionUID = 2L;
	private String name;
	private int age;
	private String address;
	
	public String getAddress()
	{
		return address;
	}

	
	public void setAddress(String address)
	{
		this.address = address;
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
	
}
