package com.zsl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by 蛮夷麟爷 on 2017-06-29.
 */
//这个是详细信息，用户的详细信息保存到这里
@Entity
public class UserDetail {

    //主键自增id
    private Integer id;
    //对应用户名
    private String username;
    //昵称
    private String name;
    //真实姓名
    private String realname;

    //城市
    private String city;
    //省份地区
    private Integer place;
    //用户头像地址
    private String ImagUrl;


    @GeneratedValue
    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(length = 100,nullable=false,unique=true)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(length = 80)
    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    @Column(length = 60)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getPlace() {
        return place;
    }

    public void setPlace(Integer place) {
        this.place = place;
    }

    public String getImagUrl() {
        return ImagUrl;
    }

    public void setImagUrl(String imagUrl) {
        ImagUrl = imagUrl;
    }
}
