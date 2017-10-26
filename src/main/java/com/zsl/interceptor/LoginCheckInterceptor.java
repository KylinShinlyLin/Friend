package com.zsl.interceptor;

import com.zsl.dao.RediesForLoginDao;

import com.zsl.dao.RedisSessionDao;
import com.zsl.dto.MySession;
import com.zsl.entity.UserLoginState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * Created by 蛮夷麟爷 on 2017-06-25.
 */
//检查是否登陆的拦截器，如果没有登陆跳转到登陆页面
public class LoginCheckInterceptor  implements HandlerInterceptor{
    //重写三个方法

    @Autowired
    private RediesForLoginDao rediesForLoginDao;
    @Autowired
    private RedisSessionDao redisSessionDao;

    @Override
    public boolean preHandle(HttpServletRequest Request, HttpServletResponse Response, Object o) throws Exception {

        Response.setContentType("text/html;charset=UTF-8");
        //用来保存cookie里面的用户名
        String UserName = null;
        //用来保存cookie里面的Token
        String Token = null;
        //用来保存当前sessionID的
        String sessionID = null;


        //去除项目的名字，只保留请求

        String URI = Request.getRequestURI().substring(Request.getContextPath().length());


        //如果请求是登陆请求则放行通过
        if(URI.equals("/login")|| URI.equals("/Tologin") || URI.equals("/Regist") || URI.equals("/getCodeImage") || URI.equals("/getCodeImageRe") || URI.equals("/webSocketServer")){

            return true;
        }

        Cookie[] cookies = Request.getCookies();


        //如果cookies为null不存在
        if(cookies==null){
            Response.sendRedirect("login");
            //Request.getRequestDispatcher("/login").forward(Request, Response);
            return false;
        }

        //foreach遍历获取cookie
        for(Cookie cookie : cookies){
            //获取Token
            if(cookie.getName().equals("CengshilinPlatformToken")){
                Token = cookie.getValue();
            }
            //获取用户名
            if(cookie.getName().equals("CengshilinPlatformUserName")){
                UserName = cookie.getValue();
            }
            //获取sessionID
            if(cookie.getName().equals("CengshilinPlatformSessionID")){
                sessionID = cookie.getValue();
            }

        }

        //如果sessionID为空，则保存当前session到redis(或者有seeionID但是redis里面没有的情况)
        if(sessionID == null || redisSessionDao.getMySessionByID(sessionID)==null ){
            MySession mySession = new MySession();
            String ID = mySession.getId();
            redisSessionDao.putMySession(mySession);
            //创建cookie
            Cookie cookieSession = new Cookie("CengshilinPlatformSessionID",ID);
            //设置时长(一小时)
            cookieSession.setMaxAge(60*60);
            //将cookie保存到客户机
            Response.addCookie(cookieSession);
        }

        if(UserName==null || Token==null){
            //用户名或者Token或者为空返回登陆页
            //Request.getRequestDispatcher("/login").forward(Request, Response);
            Response.sendRedirect("login");
            return false;
        }


        //通过用户名获取redis里面的令牌
        UserLoginState userLoginState =  rediesForLoginDao.getUserLoginState(UserName);
        //判断redis里面有没有这个对象
        if(userLoginState != null){
            //redis里面存在
            if(userLoginState.getUser().getUsername().equals(UserName)){
                //如果在别处登陆则Token将会不正确
                if(!userLoginState.getToken().equals(Token)){
                    System.out.println("Token错误");
                    ModelAndView modelAndView = new ModelAndView();
                    
                    //Request.getRequestDispatcher("/login").forward(Request, Response);
                    Response.sendRedirect("login");
                    return false;
                }
                //userLoginState.getToken().equals(Token) &&
                //Token正确，放行
                return true;
            }else{
                //用户名错误
                System.out.println("cookie失效或者其它错误");
                //Request.getRequestDispatcher("/login").forward(Request, Response);
                Response.sendRedirect("login");
                return false;
            }
        }else{
            //redis里面不存在
            //Request.getRequestDispatcher("/login").forward(Request, Response);
            System.out.println("redis do not has this logined");
            Response.sendRedirect("login");
            return false;
        }
}

    @Override
    public void postHandle(HttpServletRequest Request, HttpServletResponse Response, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("拦截器通过");
    }

    @Override
    public void afterCompletion(HttpServletRequest Request, HttpServletResponse Response, Object o, Exception e) throws Exception {

    }
}
