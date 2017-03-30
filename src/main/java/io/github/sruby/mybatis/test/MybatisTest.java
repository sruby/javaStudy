package io.github.sruby.mybatis.test;

import io.github.sruby.mybatis.model.User;
import io.github.sruby.mybatis.model.UserMapper;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

/**
 * mybatis测试类
 * @author liuwf on Sep 12, 2016 8:56:34 PM
 */
public class MybatisTest
{
	
	private static SqlSessionFactory sqlSessionFactory;
	
	private static Reader reader;
	
	private SqlSession session = sqlSessionFactory.openSession();
	
	UserMapper userOperation = session.getMapper(UserMapper.class);
	static
	{
		try
		{
			reader = Resources.getResourceAsReader("Configuration.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static SqlSessionFactory getSession()
	{
		return sqlSessionFactory;
	}
	
	/**
	 * 基于命名空间查询
	 * @author liuwf on Sep 12, 2016 9:24:59 PM
	 */
	@Test
	public void testQueryByNamacespace()
	{
		//SqlSession 实例来直接执行已映射的SQL语句
		try
		{
			User user = (User) session.selectOne("io.github.sruby.mybatis.model.UserMapper.selectUserByID", 1);
			System.out.println(user.getUserAddress());
			System.out.println(user.getUserName());
		}
		finally
		{
			session.close();
		}
	}
	
	/**
	 * 基于接口查询
	 * @author liuwf on Sep 12, 2016 9:28:33 PM
	 */
	@Test
	public void testQueryByInterface()
	{
		
		try
		{
			
			User user = userOperation.selectUserByID(1);
			System.out.println(user.getUserAddress());
			System.out.println(user.getUserName());
		}
		finally
		{
			session.close();
		}
	}
	
	/**
	 * 查询用户列表
	 * @author liuwf on Sep 12, 2016 9:41:26 PM
	 */
	@Test
	public void testSelectUsers()
	{
		try
		{
			List<User> users = userOperation.selectUsers("%");
			for (User user : users)
			{
				System.out.println(user.getId() + ":" + user.getUserName() + ":" + user.getUserAddress());
			}
		}
		finally
		{
			session.close();
		}
	}
	
	/**
	 * 添加用户
	 * @author liuwf on Sep 12, 2016 9:48:27 PM
	 */
	@Test
	public void testAddUser()
	{
		try
		{
			User user = new User();
			user.setUserAddress("人民广场");
			user.setUserName("飞鸟");
			user.setUserAge("80");
			
			userOperation.addUser(user);
			session.commit();
		}
		finally
		{
			session.close();
		}
	}
	
	/**
	 * 更新用户信息
	 * @author liuwf on Sep 12, 2016 9:48:27 PM
	 */
	@Test
	public void testUpdateUser()
	{
		try
		{
			User user = userOperation.selectUserByID(1);
			user.setUserAddress("原来是魔都的浦东创新园区");
			userOperation.updateUser(user);
			session.commit();
		}
		finally
		{
			session.close();
		}
	}
	
	/**
	 * 删除数据
	 * @author liuwf on Sep 12, 2016 9:48:27 PM
	 */
	@Test
	public void testDeleteUser()
	{
		try
		{
			userOperation.deleteUser(1);
			session.commit();
		}
		finally
		{
			session.close();
		}
	}
}
