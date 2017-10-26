package com.zsl.controller;

import com.zsl.entity.FriendMessage;
import com.zsl.repository.FriendMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by 蛮夷麟爷 on 2017-07-31.
 */

//这个控制器是用来写入朋友圈的留言，使用jpa保存到mysql
@Controller
public class FriendMessageController {

    @Autowired
    FriendMessageRepository friendMessageRepository;

    @RequestMapping(value = "/PublishMessage",method = RequestMethod.POST)
    public ModelAndView PublishFriendMessage(FriendMessage friendMessage,ModelAndView model,
                                             @CookieValue(value="CengshilinPlatformUserName",required=true) String username){


        System.out.println("进入控制器！！！");
        System.out.println("用户名="+username+"   留言内容="+friendMessage.getWord());

        //保存message
        friendMessageRepository.saveMessage(username,friendMessage.getWord());
        model.setViewName("Friend");
        return model;


    }

}
