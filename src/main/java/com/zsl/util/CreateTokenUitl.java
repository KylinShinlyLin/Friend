package com.zsl.util;

import com.zsl.dto.VailEmailPackage;
import com.zsl.entity.User;
import org.springframework.util.DigestUtils;

import java.util.Calendar;
import java.util.Random;

/**
 * Created by 蛮夷麟爷 on 2017-06-26.
 */
//用于创建令牌的工具类
public class CreateTokenUitl {

    private static Random random = new Random();

    public static String createToken(User user){
        //加盐加密
        String salt = "15920805337";
        //生成随机数
        Random random = new Random();
        int code = random.nextInt(10000);
        //生成的原生Token未MD5加密
        String TokenSource = user.getUsername()+"/"+salt+Integer.toString(code);
        //MD5加密后的Token
        String TokenMD5 = DigestUtils.md5DigestAsHex(TokenSource.getBytes());
        return TokenMD5;
    }

    /**
     * 封装的id生成，使用随机数加时间戳使用MD5加密生成主键
     */
    public static String getKeyId() {
        //加盐加密
        String salt = "1233211234567";
        //获取时间戳
        Long a = Calendar.getInstance().getTimeInMillis();
        String timestr = a.toString();
        //随机数
        int code = random.nextInt(10000);
        //生成的原生Token未MD5加密
        String tempid = timestr+"/"+salt+Integer.toString(code);
        //MD5加密后的id
        String id = DigestUtils.md5DigestAsHex(tempid.getBytes());
        return id;
    }


    public static String createVailToken(VailEmailPackage emailPackage){
        //加盐加密
        String salt = "15920805337";
        //生成随机数
        Random random = new Random();
        int code = random.nextInt(10000);
        //生成的原生Token未MD5加密
        String TokenSource = emailPackage.getUsername()+"/"+salt+Integer.toString(code);
        //MD5加密后的Token
        String TokenMD5 = DigestUtils.md5DigestAsHex(TokenSource.getBytes());

        emailPackage.setVailToken(TokenMD5);

        return TokenMD5;
    }


}
