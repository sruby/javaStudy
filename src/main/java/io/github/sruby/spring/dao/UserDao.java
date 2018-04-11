package io.github.sruby.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import io.github.sruby.spring.dao.po.User;

/**
 * 用户数据持久化
 * @author sruby on 2018年3月30日 下午5:58:23
 */
@Repository("userDao")
public class UserDao
{
    /**
     * Autowired自动注入
     */
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private final static String MATCH_COUNT_SQL = "select count(1) from t_user t where t.user_name = ? and t.password = ?";
	private final static String UPDATE_USER_LASTIP_BY_NAME = "update t_user t set last_ip = ? where t.user_id = ?";
	private final static String GET_USER_BY_USERNAME = "select * from t_user t where t.user_id =?";
	
	/**
	 * 用户密码校验
	 * @author sruby on 2018年3月30日 下午5:59:00
	 * @return
	 */
	public int getMatchCount(String name,String password)
	{
	    /**
	     * queryForObject使用时返回的结果不能为空，否则会报错。
	     */
		Integer result = jdbcTemplate.queryForObject(MATCH_COUNT_SQL, new Object[]{name,password}, int.class);
		return result;
	}
	
	/**
	 * 修改用户登录信息
	 * @param lastId
	 * @param userId
	 */
	public void updateUserLastIpByUserid(String lastId,int userId)
	{
	    jdbcTemplate.update(UPDATE_USER_LASTIP_BY_NAME, new Object[]{lastId,userId });
	}
	
	/**
	 * 根据用户名获取用户信息
	 * @param userName
	 * @return
	 */
	public User findUserByUserName(String userName)
	{
	    final User user = new User();
        jdbcTemplate.query(GET_USER_BY_USERNAME, new Object[] { userName },
                new RowCallbackHandler() {
                    public void processRow(ResultSet rs) throws SQLException {
                        user.setUserId(rs.getInt("user_id"));
                        user.setUserName(userName);
                        user.setCredits(rs.getInt("credits"));
                    }
                });
        return user;
	}
	
}
