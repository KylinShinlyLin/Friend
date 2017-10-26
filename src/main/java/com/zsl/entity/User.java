package com.zsl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.criteria.CriteriaBuilder;

/**
 * Created by 蛮夷麟爷 on 2017-06-24.
 */
@Entity
public class User {
    /*
     * 自动增长主键id
     */
    private Integer id;

    /*
     * 用户名
     */
    private String username;

    /*
     *昵称
     */
    private String name;


    /*
     * 密码
     */
    private String password;


    /*
     * 账号状态
     */
    private Integer access;


    /*
    * 是否初始化
    */
    private Integer  initialize;

    /*
     * 邮箱
     */
    private String email;


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

    @Column(length = 100,nullable=false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(nullable=true,columnDefinition="INT default 0")
    public Integer getAccess() {
        return access;
    }

    public void setAccess(Integer access) {
        this.access = access;
    }

    @Column(length = 125,nullable=true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(nullable=true,columnDefinition="INT default 1")
    public Integer getInitialize() {
        return initialize;
    }

    public void setInitialize(Integer initialize) {
        this.initialize = initialize;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", access=" + access +
                ", initialize=" + initialize +
                ", email='" + email + '\'' +
                '}';
    }
}
