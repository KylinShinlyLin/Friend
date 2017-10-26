package com.zsl.controller;


import com.google.code.kaptcha.Producer;
import com.zsl.dao.RedisSessionDao;
import com.zsl.dto.MySession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.awt.image.BufferedImage;

/**
 *
 * Created by 蛮夷麟爷 on 2017-06-26.
 */
//验证码控制器
@Controller
public class CodeController {

    @Autowired
    private Producer captchaProducer;
    @Autowired
    private RedisSessionDao redisSessionDao;


    //登陆验证码
    @RequestMapping("/getCodeImage")
    public ModelAndView GetImage(HttpServletRequest request, HttpServletResponse response,@CookieValue(value="CengshilinPlatformSessionID",required=true) String sessionID) throws Exception{
        response.setDateHeader("Expires", 0);
        // Set standard HTTP/1.1 no-cache headers.
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        // Set IE extended HTTP/1.1 no-cache headers (use addHeader).
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        // Set standard HTTP/1.0 no-cache header.
        response.setHeader("Pragma", "no-cache");
        // return a jpeg
        response.setContentType("image/jpeg");
        // create the text for the image
        String capText = captchaProducer.createText();
        System.out.println("code1 "+capText);
        // store the text in the session  (保存到session)
        MySession mySession = redisSessionDao.getMySessionByID(sessionID);
        if(mySession!=null){
            mySession.setCode(capText);
        }
        //写回到redis里面
        redisSessionDao.putMySession(mySession);
        // create the image with the text （画出图像）
        BufferedImage bi = captchaProducer.createImage(capText);
        ServletOutputStream out = response.getOutputStream();
        // write the data out （使用流的方式输出会页面）
        ImageIO.write(bi, "jpg", out);
        //清理流以及关闭流
        try {
            out.flush();
        } finally {
            out.close();
        }
        return null;
    }


    //注册验证码
    @RequestMapping("/getCodeImageRe")
    public ModelAndView GetImageRe(HttpServletRequest request, HttpServletResponse response,@CookieValue(value="CengshilinPlatformSessionID",required=true) String sessionID) throws Exception{
        response.setDateHeader("Expires", 0);
        // Set standard HTTP/1.1 no-cache headers.
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        // Set IE extended HTTP/1.1 no-cache headers (use addHeader).
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        // Set standard HTTP/1.0 no-cache header.
        response.setHeader("Pragma", "no-cache");
        // return a jpeg
        response.setContentType("image/jpeg");
        // create the text for the image
        String capText = captchaProducer.createText();
        System.out.println("code2 "+capText);

        // store the text in the session  (保存到session)
        //从redis里面取出session再保存回去
        MySession mySession = redisSessionDao.getMySessionByID(sessionID);
        //避免NullPoint异常
        if(mySession!=null){
            mySession.setRecode(capText);
        }
        //写回到redis里面
        redisSessionDao.putMySession(mySession);

        // create the image with the text （画出图像）
        BufferedImage bi = captchaProducer.createImage(capText);
        ServletOutputStream out = response.getOutputStream();
        // write the data out （使用流的方式输出会页面）
        ImageIO.write(bi, "jpg", out);
        //清理流以及关闭流
        try {
            out.flush();
        } finally {
            out.close();
        }
        return null;
    }


}
