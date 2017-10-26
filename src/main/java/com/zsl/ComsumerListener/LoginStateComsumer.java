package com.zsl.ComsumerListener;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

/**
 * Created by 蛮夷麟爷 on 2017-08-24.
 */
public class LoginStateComsumer implements MessageListener {

    @Override
    public void onMessage(Message message) {
        /**
         * 在这里写你的核心记录业务，比如通过jdbc保存到mysql等等
         */
    }



}
