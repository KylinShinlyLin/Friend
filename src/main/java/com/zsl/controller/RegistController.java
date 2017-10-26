package com.zsl.controller;

import com.zsl.dao.RedisSessionDao;
import com.zsl.entity.User;

import com.zsl.service.RegistService;
import com.zsl.util.UsernameCheckUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by 蛮夷麟爷 on 2017-06-26.
 */
//用户注册控制器
@Controller
public class RegistController {
    @Autowired
    private RegistService registService;
    @Autowired
    private RedisSessionDao redisSessionDao;

    @RequestMapping(value = "/Regist",method = RequestMethod.POST)
    public ModelAndView Regist(User user, String code,ModelAndView model ,String passwordCommit,@CookieValue(value="CengshilinPlatformSessionID",required=true) String sessionID ){

        //获取注册验证码
        String sessionCode = redisSessionDao.getMySessionByID(sessionID).getRecode();
        //验证码错误
        if(!sessionCode.equals(code)){
            model.setViewName("index");
            model.addObject("Rerroe","验证码错误！");
            return model;
        }
        //重复输入验证码错误
        if(!user.getPassword().equals(passwordCommit)){
            model.setViewName("index");
            model.addObject("Rerroe","两次密码不一致！");
            return model;
        }

        //用户名检查是否符合规则
        if(UsernameCheckUtil.UsernameCheck(user.getUsername())){
            //检查账号是否存在
            if(registService.CheckUserNameIsExist(user)){
                model.setViewName("index");
                model.addObject("Rerroe","该用户名已经存在！");
                return model;
            }else{
               if(registService.CreateUser(user)){
                   model.setViewName("index");
                   model.addObject("success","账号创建成功！");
                   return model;
               }else{
                   model.setViewName("index");
                   model.addObject("error","账号创建失败！");
                   return model;
               }
            }

        }else{
            model.setViewName("index");
            model.addObject("Rerroe","用户名只能为英文和数字！");
            return model;
        }

    }

}
