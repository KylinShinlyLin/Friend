package com.zsl.ComsumerListener;

import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import com.zsl.dto.VailEmailPackage;
import com.zsl.service.VailEmailService;
import com.zsl.util.JAVAMAIL;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by 蛮夷麟爷 on 2017-08-02.
 */
public class VailEmailComsumer implements MessageListener {

    @Autowired
    VailEmailService vailEmailService;

    //onmessage方法
    @Override
    public void onMessage(Message message) {

        //反序列化操作
        //序列化操作，protostuff,字节码
        RuntimeSchema<VailEmailPackage> schema = RuntimeSchema.createFrom(VailEmailPackage.class);
        VailEmailPackage emailPackage = schema.newMessage();
        //取出序列化数据
        byte[] bytes = message.getBody();
        //数据内容填充到空对象里面
        ProtostuffIOUtil.mergeFrom(bytes, emailPackage, schema);

        System.out.println("读取消息队列的邮箱是："+emailPackage.getEmail()+"   用户名是："+emailPackage.getUsername());
        vailEmailService.KeepVailEmail(emailPackage);

    }
}
