package com.zsl.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by 蛮夷麟爷 on 2017-06-29.
 */
//用于获取时间的工具类
public class GetDateAndTimeUtil {

    //这个获取时间没有时分秒
    public static String getDateNoTime(){
        String d=new SimpleDateFormat("yyyy-MM-dd")
                .format(Calendar.getInstance().getTime());

        return d;
    }

    //这个获取完整的时间
    public static String getDate(){
        String d=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                .format(Calendar.getInstance().getTime());

        return d;
    }

}
