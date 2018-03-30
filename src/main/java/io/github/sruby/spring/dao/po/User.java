package io.github.sruby.spring.dao.po;

import java.io.Serializable;

/**
 * 用户对象
 * @author sruby on 2018年3月30日 下午5:53:12
 */
public class User implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private int userId;
	private String name;
	private int age;
	private String password;
	private String lastIp;
	private String lastVisit;
	
	public int getUserId()
	{
		return userId;
	}
	
	public void setUserId(int userId)
	{
		this.userId = userId;
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
	
	public String getPassword()
	{
		return password;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public String getLastIp()
	{
		return lastIp;
	}
	
	public void setLastIp(String lastIp)
	{
		this.lastIp = lastIp;
	}
	
	public String getLastVisit()
	{
		return lastVisit;
	}
	
	public void setLastVisit(String lastVisit)
	{
		this.lastVisit = lastVisit;
	}

	public User(int userId, String name, int age, String password, String lastIp, String lastVisit)
	{
		super();
		this.userId = userId;
		this.name = name;
		this.age = age;
		this.password = password;
		this.lastIp = lastIp;
		this.lastVisit = lastVisit;
	}
	
	
	
}
