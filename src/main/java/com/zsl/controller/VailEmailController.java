package com.zsl.controller;



import com.zsl.dto.VailEmailPackage;
import com.zsl.service.VailEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by 蛮夷麟爷 on 2017-08-02.
 */
@Controller
public class VailEmailController {

    @Autowired
    VailEmailService vailEmailService;

    @RequestMapping(value = "/VailEmail",method = RequestMethod.POST)
    public ModelAndView SendVailEmail(ModelAndView model ,String Vemail, @CookieValue(value="CengshilinPlatformUserName",required=true) String username){

        VailEmailPackage emailPackage = new VailEmailPackage();
        emailPackage.setEmail(Vemail);
        emailPackage.setUsername(username);
        vailEmailService.SendVailEmail(emailPackage);
        model.setViewName("first/EmailSend");
        return model;
    }


    @RequestMapping("/ToVailEmail/{username}/{Token}")
    public ModelAndView ToVailEmail(ModelAndView model, @PathVariable("username") String username,@PathVariable("Token") String Token){

        System.out.println("进入邮件验证控制器");
        if(vailEmailService.VailEmail(username,Token)==true){
            model.setViewName("redirect:/ToWorld");
        }else{
            model.setViewName("first/EmailResult");
            model.addObject("resultTitle","验证失败！");
            model.addObject("result","请关闭浏览器重新发送验证邮件！");
        }
        return model;
    }



}
