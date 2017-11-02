package com.zsl.service;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import com.zsl.Produce.EmailProduce;
import com.zsl.dao.RedisForVailEmailDao;
import com.zsl.dto.VailEmailPackage;
import com.zsl.repository.UserRepository;
import com.zsl.util.CreateTokenUitl;
import com.zsl.util.JAVAMAIL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 蛮夷麟爷 on 2017-08-02.
 */
@Service
public class VailEmailService {

    @Autowired
    private RedisForVailEmailDao redisForVailEmailDao;
    @Autowired
    private EmailProduce emailProduce;
    @Autowired
    private UserRepository userRepository;

    public boolean SendVailEmail(VailEmailPackage emailPackage){
        try {
            //序列化操作
            RuntimeSchema<VailEmailPackage> schema = RuntimeSchema.createFrom(VailEmailPackage.class);
            byte[] bytes = ProtostuffIOUtil.toByteArray(emailPackage, schema, LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
            //发送消息
            emailProduce.EmailsendMessage(bytes);
            System.out.println("邮件发送到消息队列");
        }catch (Exception e){
            System.out.println("邮件验证消息发送失败！");
            return false;
        }
        return true;
    }

    public boolean KeepVailEmail(VailEmailPackage emailPackage){
        //生成令牌
        String VailToken = CreateTokenUitl.createVailToken(emailPackage);
        //将验证邮箱的对象缓存到redis里面
        redisForVailEmailDao.PutVailEmailPackage(emailPackage);

        //发送邮件
        JAVAMAIL.sendVailEmail(emailPackage);
        System.out.println("邮件发送到目标邮箱");
        return true;
    }


    public boolean VailEmail(String username,String Token){

        VailEmailPackage emailPackage =  redisForVailEmailDao.GetVailEmailPackage(username);
        //令牌验证成功！
        if(emailPackage!=null){
            if(emailPackage.getUsername().equals(username) && emailPackage.getVailToken().equals(Token)){
                //更新操作
                userRepository.updateEmail(emailPackage.getUsername(), emailPackage.getEmail());
                return true;
            }
        }
        return false;
    }







}
