package com.zsl.util;

/**
 *
 * Created by 蛮夷麟爷 on 2017-06-26.
 */
//这个是判读用户名是否符合规范
 /*
 * 要求：
 * 1、用户名不能包含奇怪的字符
 * 2、用户名只能在0-9 A-Z a-z里面取名
 * 3、用户名长度限制
 * 4、如果后期加入短信验证，则用户名为手机号码（Todo）
 * */
public class UsernameCheckUtil {

    //手机号码验证
    public static boolean UsernameCheck(String username){
        int c;
        for(int i=0 ;i<username.length();i++){
           //遍历每个字符的ASCII
            c = Integer.valueOf(username.charAt(i));
            boolean check=false;
            //是否在0-9范围内
            if(c >= 48 && c <= 57){
                //为真不做操作
                check = true;
            }else{
                //是否在A-Z范围内
                if(c >= 65 && c <= 90){
                    //为真不做操作
                    check =  true;
                }else{
                    //是否在a-z范围内
                    if( c >= 97 && c <= 122 ){
                        //为真不做操作
                        check =  true;
                    }else{
                        check =  false;
                    }
                }
            }
            //如果有一个字符不符合则结果不符合
            if(check==false){
                return false;
            }
        }
        return true;
    }
}
