package io.github.sruby.spring.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import io.github.sruby.spring.dao.LoginService;

public class LoginServiceTest extends LoginService
{
    private LoginService loginService;
    @Before
    public void setUp() throws BeansException {
        ApplicationContext context = new ClassPathXmlApplicationContext("io/github/sruby/spring/dao/smart-context.xml");
        loginService = (LoginService) context.getBean("loginService");
    }
    
    @Test
    public void testLoginSuccess()
    {
        loginService.loginSuccess("127.0.0.1", 1);
    }
    
}
