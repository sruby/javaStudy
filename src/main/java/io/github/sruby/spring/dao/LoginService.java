package io.github.sruby.spring.dao;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.sruby.spring.dao.po.LoginLog;
import io.github.sruby.spring.dao.po.User;

@Service("loginService")
public class LoginService
{
    @Autowired
    private LoginLogDao loginLogDao;
    
    @Autowired
    private UserDao userDao;
    
    /**
     * 用户密码是否匹配
     * @param name
     * @param password
     * @return
     */
    public boolean hasMatchUser(String name, String password)
    {
        int matchCount = userDao.getMatchCount(name, password);
        return matchCount > 0;
    }
    
    public User findUserByUserName(String userName) {
        return userDao.findUserByUserName(userName);
    }
    
    @Transactional
    public void loginSuccess(String lastId,int userId)
    {
        userDao.updateUserLastIpByUserid(lastId, userId);
        
        LoginLog loginLog = new LoginLog();
        loginLog.setIp(lastId);
        loginLog.setLoginDate(new Date());
        loginLog.setUserId(userId);
        
        /**
         * 出现运行时异常时会进行回滚
         */
//        
//        if(true)
//        {
//            throw new RuntimeException();
//        }
        
        loginLogDao.addLoginLog(loginLog);
        
    }
}
