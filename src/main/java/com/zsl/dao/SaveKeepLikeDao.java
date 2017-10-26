package com.zsl.dao;

import com.zsl.entity.KeepLike;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

/**
 * Created by 蛮夷麟爷 on 2017-06-30.
 */
//这个是用来保存喜好的Dao
public class SaveKeepLikeDao {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    public void SaveKeepLike(KeepLike keepLike){
        EntityManager em =  entityManagerFactory.createEntityManager();
        try{
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.persist(keepLike);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            em.close();
        }

    }

}
