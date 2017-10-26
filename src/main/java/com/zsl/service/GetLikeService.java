package com.zsl.service;

import com.zsl.entity.KeepLike;
import com.zsl.repository.KeepLikeRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by 蛮夷麟爷 on 2017-07-17.
 */
//这个业务层是用来获取个人喜好的
public class GetLikeService {

    @Autowired
    private KeepLikeRepository keepLikeRepository;


    //获取个人喜好，返回形式数组
    public String GetStringLike(String username){

        KeepLike keepLike =  keepLikeRepository.findByUsername(username);
        StringBuilder likeback = new StringBuilder();

        if(keepLike.getCode()==1){
            likeback.append("代码，");
        }
        if(keepLike.getDesign()==1){
            likeback.append("设计，");
        }
        if(keepLike.getDevelop()==1){
            likeback.append("工程开发，");
        }
        if(keepLike.getMuics()==1){
            likeback.append("音乐，");
        }
        if(keepLike.getSport()==1){
            likeback.append("运动，");
        }
        if (keepLike.getDesign()==1){
            likeback.append("艺术设计");
        }

        return likeback.toString();
    }


}
