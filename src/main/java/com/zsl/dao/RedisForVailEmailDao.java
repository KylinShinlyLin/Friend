package com.zsl.dao;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import com.zsl.dto.VailEmailPackage;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by 蛮夷麟爷 on 2017-08-02.
 */
//这个是用于读取redis里面保存邮件验证的缓存
public class RedisForVailEmailDao {

    //使用Jedis池的方式连接
    private JedisPool jedisPool;
    //序列化操作，protostuff,字节码
    private RuntimeSchema<VailEmailPackage> schema = RuntimeSchema.createFrom(VailEmailPackage.class);
    //构造函数
    public RedisForVailEmailDao(String ip,int port){
        //构造的方式初始化这个Dao使用Bean构造注入
        jedisPool = new JedisPool(ip,port);
    }


    //反序列化，将对象从redis里面取出
    public VailEmailPackage GetVailEmailPackage(String username){
        try{
            //开启连接
            Jedis jedis = jedisPool.getResource();
            try {
                //redis里面的key
                String key = "VailEmail"+username;
                //redis获取数据
                byte[] bytes = jedis.get(key.getBytes());
                if(bytes != null){
                    //创建一个空对象
                    VailEmailPackage emailPackage = schema.newMessage();
                    //数据内容填充到空对象里面
                    ProtostuffIOUtil.mergeFrom(bytes, emailPackage, schema);
                    //返回对象
                    return emailPackage;
                }
            }finally {
                jedis.close();
            }
        }catch (Exception e){
            //发送错误！
            e.printStackTrace();
        }
        return null;
    }


    //序列化操作，将对象序列胡保存到redis里面
    public String PutVailEmailPackage(VailEmailPackage emailPackage){
        try{
            Jedis jedis = jedisPool.getResource();
            try{
                //将用户名作为key
                String key = "VailEmail"+emailPackage.getUsername();
                //三个参数，第一个序列化的对象，第二个schema，第三个缓存器大小
                byte[] bytes = ProtostuffIOUtil.toByteArray(emailPackage,schema,
                        LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
                int timeout = 60*30;//缓存时间一个小时
                //这里使用的是redis的缓存超时方式（保存到redis）
                String result = jedis.setex(key.getBytes(), timeout, bytes);
                return result;
            }finally {
                jedis.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }



}
