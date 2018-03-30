package io.github.sruby.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import io.github.sruby.spring.dao.po.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

/**
 * 用户数据持久化
 * @author sruby on 2018年3月30日 下午5:58:23
 */
@Repository
public class UserDao
{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private final static String MATCH_COUNT_SQL = "select 1 from t_user t where t.name = ? and t.password = ?";
	private final static String USER_BY_NAME = "select * from t_user t where t.name = ?";
	private final static String UPDATE_USER_LASTIP_BY_NAME = "update t_user t set lastip = ? where t.name = ?";
	
	/**
	 * 用户密码校验
	 * @author sruby on 2018年3月30日 下午5:59:00
	 * @return
	 */
	public int getMatchCount(String name,String password)
	{
		Integer result = jdbcTemplate.queryForObject(MATCH_COUNT_SQL, new Object[]{name,password}, int.class);
		return result;
	}
	
	public User findUserByName(String name)
	{
		return null;
	}
	
	public void updateUserLastIpByName()
	{
		
	}
}
