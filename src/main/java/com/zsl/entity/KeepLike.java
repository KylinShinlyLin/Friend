package com.zsl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by 蛮夷麟爷 on 2017-06-29.
 */
//这个是个人喜好实体类
@Entity
public class KeepLike {


    //主键id用于索引
    private Integer id;

    //对应的用户名
    private String username;

    //下面是几个喜好的属性
    private int Design;

    private int Code;

    private int Develop;

    private int Muics;

    private int Sport;

    private int  Writting;


    @GeneratedValue
    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public int getDesign() {
        return Design;
    }

    public void setDesign(int design) {
        Design = design;
    }


    public int getCode() {
        return Code;
    }

    public void setCode(int code) {
        Code = code;
    }


    public int getDevelop() {
        return Develop;
    }

    public void setDevelop(int develop) {
        Develop = develop;
    }


    public int getMuics() {
        return Muics;
    }

    public void setMuics(int muics) {
        Muics = muics;
    }


    public int getSport() {
        return Sport;
    }

    public void setSport(int sport) {
        Sport = sport;
    }


    public int getWritting() {
        return Writting;
    }

    public void setWritting(int writting) {
        Writting = writting;
    }
}
