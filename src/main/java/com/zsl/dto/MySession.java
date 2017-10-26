package com.zsl.dto;

import java.io.Serializable;

import com.zsl.util.CreateTokenUitl;

/**
 * 由于占时没有找到序列化HttpSession的方法，所以只好自己模仿Session写了一个Session（如果谁知道怎么序列化HttpSession请告诉我）
 * Created by 蛮夷麟爷 on 2017-09-19.
 */
public class MySession implements Serializable {

    private String id;      //唯一标识ID（使用MD5自动生成）
    private String Recode; //注册验证码
    private String code;   //验证码

    public MySession(){
        //默认创建唯一ID
        this.id= CreateTokenUitl.getKeyId();
    }

    public String getId() {
        return id;
    }

    public String getRecode() {
        return Recode;
    }

    public void setRecode(String recode) {
        Recode = recode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
