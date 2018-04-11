package io.github.sruby.spring.mvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import io.github.sruby.spring.dao.LoginService;
import io.github.sruby.spring.dao.po.User;



@RestController
public class LoginController
{
    @Autowired
    private LoginService loginService;
    
    @RequestMapping(value="/index.html")
    public String loginPage()
    {
        return "login";
    }
    
    @RequestMapping(value = "loginCheck.html")
    public ModelAndView loginCheck(HttpServletRequest request,LoginCommand loginCommand)
    {
        String userName = loginCommand.getUserName();
        String password = loginCommand.getPassword();
        boolean hasMatchUser = loginService.hasMatchUser(userName, password);
        
        if(!hasMatchUser)
        {
            return new ModelAndView("login", "error", "用户名或密码错误。");
        }
        
        User user = loginService.findUserByUserName(userName);
        String lastIp = request.getLocalAddr();
        int userId = user.getUserId();
        
        loginService.loginSuccess(lastIp, userId);
        return new ModelAndView("main");
    }
}
