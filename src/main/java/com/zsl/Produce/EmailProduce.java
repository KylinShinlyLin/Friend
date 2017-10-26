package com.zsl.Produce;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by 蛮夷麟爷 on 2017-08-02.
 */

public class EmailProduce {

    @Autowired
    private AmqpTemplate amqpTemplate;
    //邮件验证生产者发送消息
    public void EmailsendMessage(byte[] bytes){
        amqpTemplate.convertAndSend("test",bytes);
    }



}
