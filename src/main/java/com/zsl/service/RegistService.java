package com.zsl.service;

import com.zsl.dao.CreateUserDao;
import com.zsl.entity.User;
import com.zsl.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;

/**
 * Created by 蛮夷麟爷 on 2017-06-28.
 */
@Service
public class RegistService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CreateUserDao createUserDao;




    public boolean CheckUserNameIsExist(User user){

        try {
            if (userRepository.getUserByUserName(user.getUsername()) != null) {
                return true;
            }
            return false;
        }catch (Exception e){

            return false;
        }
    }


    //创建账号

    public boolean CreateUser(User user){
        System.out.println("进入到创建账号服务层");
        //新创建的账号需要初始化用户信息，并且获得访问权限为普通
        user.setAccess(0);
        user.setInitialize(0);
        createUserDao.InsertUser(user);
        System.out.println("业务层结束");
        if(CheckUserNameIsExist(user)){
            System.out.println("账号创建成功!");
            return true;
        }
        System.out.println("账号创建失败！");
        return false;
    }







}

