package com.zsl.dao;

import com.zsl.entity.User;
import com.zsl.entity.UserDetail;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

/**
 * Created by 蛮夷麟爷 on 2017-06-30.
 */
//这个是用来保存用户详细数据的Dao
public class SavaUserDetailDao {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    public void SaveUserDetail(UserDetail userDetail){
        EntityManager em =  entityManagerFactory.createEntityManager();
        try{
            EntityTransaction transaction = em.getTransaction(); //开启事务
            transaction.begin();
            em.persist(userDetail);
            transaction.commit();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            em.close();
        }
    }

}
