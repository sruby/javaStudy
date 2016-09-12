package io.github.sruby.mybatis.test;

import io.github.sruby.mybatis.model.User;
import io.github.sruby.mybatis.model.UserMapper;

import java.io.Reader;

import junit.framework.TestCase;

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
		SqlSession session = sqlSessionFactory.openSession();
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
		SqlSession session = sqlSessionFactory.openSession();
		try
		{
			UserMapper userOperation = session.getMapper(UserMapper.class);
			User user = userOperation.selectUserByID(1);
			System.out.println(user.getUserAddress());
			System.out.println(user.getUserName());
		}
		finally
		{
			session.close();
		}
	}
}
