package com.zsl.entity;

/**
 * Created by 蛮夷麟爷 on 2017-06-25.
 */
/*    这个是其实不是实体类一个是数据封装层  */
//这个类是用来记录登陆状态的，将会序列化后保存到redis里面
public class UserLoginState {
    //用户对象
    private User user;
    //登陆者的IP地址
    private String IP;
    //令牌
    private String Token;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }
}
