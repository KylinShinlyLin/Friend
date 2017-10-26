package com.zsl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by 蛮夷麟爷 on 2017-06-24.
 */
//主页控制器
@Controller
public class IndexController {

    //默认进入主页，拦截器会中途拦截检查登陆状态
    @RequestMapping("/")
    public ModelAndView ToHome(ModelAndView model){
        model.setViewName("redirect:/ToWorld");
        return model;
    }


}
