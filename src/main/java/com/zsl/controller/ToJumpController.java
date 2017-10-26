package com.zsl.controller;

import com.zsl.entity.User;
import com.zsl.entity.UserDetail;
import com.zsl.repository.UserDetailRepository;
import com.zsl.repository.UserRepository;
import com.zsl.service.GetLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by 蛮夷麟爷 on 2017-06-28.
 */
//用于各种页面的跳转
@Controller
public class ToJumpController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserDetailRepository userDetailRepository;
    @Autowired
    private GetLikeService getLikeService;

    //通过cookie获取平台token的用户名，检查登陆的用户是不是刚刚注册的，如果是需要他初始化个人信息
    @RequestMapping("/ToWorld")
    public ModelAndView ToWorld(ModelAndView model,@CookieValue(value="CengshilinPlatformUserName",required=false) String username){

        User user = userRepository.findByUsername(username);
        if(user == null){
            /* 出现莫名奇妙的情况，一般是外力或者一些非法尝试入侵导致
             （所以不用理太多直接让这个请求滚去登陆）让客户端刷新cookie让Token缓存改变，教他重新做人*/
            model.setViewName("index");
            return model;
        }
        //用户查询到
        //用户需要初始化
        if (user.getInitialize() == 0) {
            model.setViewName("first/first");
            return model;
        }

        //如果邮箱为空,跳转到邮箱验证界面
        if(user.getEmail() == null){
            model.setViewName("first/email");
            return model;
        }



        UserDetail userDetail = userDetailRepository.findByUsername(username);
        user = userRepository.findByUsername(username);
        System.out.println("图片路径是："+userDetail.getImagUrl());

        if(userDetail !=null && user != null){
            //如果用户自己没有上传图片
            if(userDetail.getImagUrl()==null){
                userDetail.setImagUrl("userimage/default-avatar.png");
            }
            //EL表达式返回
            model.setViewName("main");
            model.addObject("userDetail",userDetail);
            model.addObject("user",user);
            return model;
        }
        model.setViewName("index");
        return model;

    }



    //跳转到朋友圈
    @RequestMapping("/ToFriend")
    public ModelAndView ToFriend(ModelAndView model){

        model.setViewName("Friend");
        return model;
    }


    //跳转到个人信息
    @RequestMapping("/ToMyInfo")
    public ModelAndView ToMyInfo(ModelAndView model,@CookieValue(value="CengshilinPlatformUserName",required=true) String username){

        getLikeService.GetStringLike(username);
        model.addObject("like", getLikeService.GetStringLike(username));
        model.addObject("userdetail",userDetailRepository.findByUsername(username));
        model.addObject("user",userRepository.findByUsername(username));

        model.setViewName("my/myinfo");
        return model;
    }

    //跳转到个人信息修改页
    @RequestMapping("/ToMyInfoChange")
    public ModelAndView ToMyInfoChange(ModelAndView model){

        model.setViewName("my/myinfoChange");

        return model;
    }


    //跳转到约会页面
    @RequestMapping("/ToDate")
    public ModelAndView ToDate(ModelAndView model){
        model.setViewName("date/DateIndex");
        return model;
    }




}
