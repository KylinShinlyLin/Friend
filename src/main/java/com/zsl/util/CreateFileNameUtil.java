package com.zsl.util;

import org.springframework.util.DigestUtils;

import java.util.Calendar;
import java.util.Random;

/**
 * 上传文件名统一加密处理（随机数+盐+时间戳+用户名）
 * Created by 蛮夷麟爷 on 2017-06-30.
 */
public class CreateFileNameUtil {


    public static String CreatefileName(String username){

        //加盐加密
        String salt = "123zsl321";
        Random random = new Random();
        int code = random.nextInt(10000);
        //获取时间戳
        Long a = Calendar.getInstance().getTimeInMillis();
        String timestr = a.toString();
        //生成的原生Token未MD5加密
        String TokenSource = username+"/"+salt+"/"+timestr+Integer.toString(code);
        //MD5加密后的文件名
        String filename = DigestUtils.md5DigestAsHex(TokenSource.getBytes());

        return filename+".jpg";
    }

}
