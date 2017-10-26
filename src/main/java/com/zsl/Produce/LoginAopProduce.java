package com.zsl.Produce;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by 蛮夷麟爷 on 2017-08-24.
 */
public class LoginAopProduce {
    @Autowired
    private AmqpTemplate amqpTemplate;
    //生产者发送消息
    public void EmailsendMessage(byte[] bytes){
        amqpTemplate.convertAndSend("test",bytes);
    }

}
