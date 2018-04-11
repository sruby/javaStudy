package io.github.sruby.spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import io.github.sruby.spring.dao.po.LoginLog;

@Repository("loginLogDao")
public class LoginLogDao
{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    //保存登陆日志SQL
    private final static String INSERT_LOGIN_LOG_SQL= "INSERT INTO t_login_log(user_id,ip,login_datetime) VALUES(?,?,?)";
    
    public void addLoginLog(LoginLog loginLog)
    {
        Object[] args = { loginLog.getUserId(), loginLog.getIp(),
                          loginLog.getLoginDate() };
        jdbcTemplate.update(INSERT_LOGIN_LOG_SQL, args);
    }
}
