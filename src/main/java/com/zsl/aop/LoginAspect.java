package com.zsl.aop;

import com.zsl.entity.User;
import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;
import eu.bitwalker.useragentutils.Version;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 蛮夷麟爷 on 2017-08-20.
 */

@Aspect
@Component
public class LoginAspect {
    //这是一个登陆切面切点的before形式触发方法
    @Before("execution(* com.zsl.service.LoginCheckService.LoginCheck(..)) and args(request,user)")
    public void before(HttpServletRequest request, User user) {
        System.out.println("****************************************************");

        System.out.println("        切面发现有用户登陆！！！"+"登陆的用户是："+user.getUsername()+"  昵称："+user.getName());

        UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
        Browser browser = userAgent.getBrowser();
        int a =userAgent.getId();
        Version version = userAgent.getBrowserVersion();
        OperatingSystem os = userAgent.getOperatingSystem();

        System.out.println("登录的客户机的操作系统是"+os);
        System.out.println("登录客户机的浏览器类型是"+browser);
        System.out.println("不知道这个是什么东西"+a);
        System.out.println("登录浏览器的版本"+version);

        /**
         * 由于我们这里使用了反向代理（负载均衡），所以获取IP是无效的，获取的是Nginx的IP地址
         */


        //UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
        System.out.println("登录的浏览器是："+request.getHeader("User-Agent"));
        System.out.println("当前浏览器的sessionID是："+request.getRequestedSessionId());

        System.out.println("****************************************************");
    }
}
