package com.zsl.service;

import com.zsl.dao.RediesForLoginDao;
import com.zsl.entity.User;
import com.zsl.entity.UserLoginState;
import com.zsl.repository.UserRepository;
import com.zsl.util.CreateTokenUitl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.soap.Addressing;

/**
 * Created by 蛮夷麟爷 on 2017-06-26.
 */
//这个是用来做登录业务的业务层
@Service
public class LoginCheckService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RediesForLoginDao rediesForLoginDao;

    //登陆验证
    public boolean LoginCheck(HttpServletRequest request, User user){
        //根据用户名查找
        User check = userRepository.findByUsername(user.getUsername());
        if(check==null){
            System.out.println("用户名不存在");
            return false;
        }
        //如果用户名密码正确
        if(user.getUsername().equals(check.getUsername()) && user.getPassword().equals(check.getPassword())){
            System.out.println("用户名密码正确");
            return true;
        }
        return false;
    }

    //这个是登陆成功后把登陆Token保存到Redis的方法，返回值是Token
    public String SaveLoginStateToRedis(User user){
        //创建Token
        String Token = CreateTokenUitl.createToken(user);
        //创建一个登陆状态DTO
        UserLoginState userLoginState = new UserLoginState();
        //把Token和User封装进去
        userLoginState.setUser(user);
        userLoginState.setToken(Token);
        //保存到Redis
        rediesForLoginDao.putUserLoginState(userLoginState);
        return Token;
    }

}
