package com.zsl.controller;

import com.zsl.dto.FriendMessageResult;

import com.zsl.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;

/**
 * Created by 蛮夷麟爷 on 2017-07-17.
 */
//朋友圈内容分页控制器
@Controller
public class MessagePageController {

    @Autowired
    PageService pageService;

    @RequestMapping(value = "/GetFriendMessage", method = RequestMethod.POST)
    @ResponseBody
    public List<FriendMessageResult> GetFriendMessage(Integer page,Integer size,@CookieValue(value="CengshilinPlatformUserName",required=true) String username){
        System.out.println("***********************进入控制器参数是*******************");
        System.out.println(page);
        System.out.println(size);
        //调用业务层
        List<FriendMessageResult> resultList = pageService.SoleReturnToList(page,size);



        return resultList;
    }

}
