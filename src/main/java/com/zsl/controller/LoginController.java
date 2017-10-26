package com.zsl.controller;



import com.zsl.dao.RedisSessionDao;
import com.zsl.entity.User;

import com.zsl.service.LoginCheckService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * Created by 蛮夷麟爷 on 2017-06-26.
 */
//登陆业务控制器
@Controller
public class LoginController {

    @Autowired
    private LoginCheckService loginCheckService;
    @Autowired
    private RedisSessionDao redisSessionDao;

    //点击登陆后用来处理的登陆业务的控制器
    @RequestMapping(value = "/Tologin",method = RequestMethod.POST)
    public ModelAndView Tologin(ModelAndView model, HttpServletRequest request, HttpServletResponse response, User user, String code, @CookieValue(value="CengshilinPlatformSessionID",required=true) String sessionID ){
        //如果验证码不正确
        if(!redisSessionDao.getMySessionByID(sessionID).getCode().equals(code)){
            //验证码错误
            model.setViewName("index");
            model.addObject("error","验证码错误！");
            return model;
        }

        //如果用户名密码正确
        if(loginCheckService.LoginCheck(request,user)){
            //获取返回值Token
            String Token =  loginCheckService.SaveLoginStateToRedis(user);
            //创建cookie
            Cookie cookieUserName = new Cookie("CengshilinPlatformUserName",user.getUsername());
            Cookie cookieToken = new Cookie("CengshilinPlatformToken",Token);
            //设置时长
            cookieUserName.setMaxAge(60*60);
            cookieToken.setMaxAge(60*60);
            //将cookie保存到客户机
            response.addCookie(cookieUserName);
            response.addCookie(cookieToken);
            System.out.println("登陆成功！");
            //重定向到主页
            return new ModelAndView("redirect:/ToWorld");
        }else{
            //密码错误
            model.setViewName("index");
            model.addObject("error","用户名或者密码错误！");
            return model;
        }
    }

    //如果拦截器发现用户没有登录将会返回到登陆页面
    @RequestMapping("/login")
    public ModelAndView index(ModelAndView model){

        System.out.println("****************I'm into login controller *******************");

        model.setViewName("index");
        return model;
    }









}
