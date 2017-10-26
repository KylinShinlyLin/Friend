package com.zsl.service;

import com.zsl.dto.FriendMessageResult;
import com.zsl.entity.FriendMessage;
import com.zsl.entity.UserDetail;
import com.zsl.repository.FriendMessageRepository;
import com.zsl.repository.UserDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by 蛮夷麟爷 on 2017-07-17.
 */
@Service
public class PageService {

    @Autowired
    private FriendMessageRepository friendMessageRepository;
    @Autowired
    private UserDetailRepository userDetailRepository;

    private static String  USER_IMAGEURL = "userimage/default-avatar.png"; //用户默认头像地址
    private static String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss"; //默认时间格式

    //获取列表
    public Page<FriendMessage> GetPageList(Pageable pageable){
        //返回分页查询
        return friendMessageRepository.findAll(pageable);
    }


    //这个类的方法是用来封装分页查询到的结果
    public List<FriendMessageResult> SoleReturnToList(int page,int size){

        List<FriendMessageResult> FMBack = new ArrayList<FriendMessageResult>();
        //这里的page和size是分页的页数和大小，通过Ajax传递过来
        Pageable pageable = new PageRequest(page,size);
        //分页方式查询
        Page<FriendMessage> friendMessages = GetPageList(pageable);

        //遍历元素
        for(FriendMessage a : friendMessages.getContent()){
            FriendMessageResult friendMessageResult = new FriendMessageResult();
            //查询每个记录的昵称
            UserDetail userDetail = userDetailRepository.findByUsername(a.getUsername());
            //时间格式化
            Calendar c = a.getTime();
            Date tasktime = c.getTime();
            SimpleDateFormat df=new SimpleDateFormat(TIME_FORMAT);
            String time = df.format(tasktime);
            //封装结果到DTO
            friendMessageResult.setFriendMessage(a);
            friendMessageResult.setName(userDetail.getName());
            //如果用户头像为空
            if(userDetail.getImagUrl()==null){
                friendMessageResult.setUserImage(USER_IMAGEURL);
            }else{
                friendMessageResult.setUserImage(userDetail.getImagUrl());
            }
            friendMessageResult.setUsername(a.getUsername());
            friendMessageResult.setTimeStr(time);
            friendMessageResult.setSize(size);
            friendMessageResult.setMaxPage(friendMessages.getTotalPages());
            FMBack.add(friendMessageResult);
        }


        return FMBack;
    }




}
