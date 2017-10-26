package com.zsl.dao;

import com.zsl.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.transaction.Transactional;

/**
 * Created by 蛮夷麟爷 on 2017-06-28.
 */


public class CreateUserDao {

    @Autowired
    private EntityManagerFactory entityManagerFactory;


    public void InsertUser(User user){

        EntityManager em =  entityManagerFactory.createEntityManager();
        try{
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.persist(user);
            transaction.commit();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            em.close();
        }
    }

}
