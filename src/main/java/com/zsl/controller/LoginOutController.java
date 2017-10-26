package com.zsl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by 蛮夷麟爷 on 2017-06-28.
 */
//这个是账号登出控制器
@Controller
public class LoginOutController {

    @RequestMapping("/LoginOut")
    public ModelAndView LoginOut(ModelAndView model, HttpServletRequest request, HttpServletResponse response) {
        System.out.println("进入登出控制器");
        Cookie[] cookies = request.getCookies();
        if (null == cookies) {
            System.out.println("没有cookie");
        } else {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("CengshilinPlatformToken")) {
                    cookie.setValue(null);
                    cookie.setMaxAge(0);// 立即销毁cookie
                    response.addCookie(cookie);
                    model.setViewName("index");
                    return model;
                }
            }
        }
        model.setViewName("index");
        return model;
    }
}
