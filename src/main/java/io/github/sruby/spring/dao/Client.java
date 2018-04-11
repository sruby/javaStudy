package io.github.sruby.spring.dao;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试类
 * @author sruby
 *
 */
public class Client
{
    UserDao userDao;
    
    @Before
    public void setUp()
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("io/github/sruby/spring/dao/smart-context.xml");
        userDao = (UserDao) context.getBean("userDao");
    }
    
    @Test
    public void testGetMatchCount()
    {
        int matchCount = userDao.getMatchCount("1", "1");
        System.out.println("matchCount"+matchCount);
    }
}

