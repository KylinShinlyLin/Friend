package com.zsl.dao;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.runtime.RuntimeSchema;

import com.zsl.dto.MySession;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;



/**
 * 这个类是用来保存和读取用户session到redis里面的方法
 * Created by 蛮夷麟爷 on 2017-09-19.
 */

public class RedisSessionDao {

    //使用Jedis池的方式连接
    private JedisPool jedisPool;
    //序列化操作，protostuff,字节码
    private RuntimeSchema<MySession> schema = RuntimeSchema.createFrom(MySession.class);
    //构造函数
    public RedisSessionDao(String ip,int port){
        //构造的方式初始化这个Dao使用Bean构造注入
        jedisPool = new JedisPool(ip,port);
    }

    //保存session到redis里面
    public MySession getMySessionByID(String ID){
        try{
            //开启连接
            Jedis jedis = jedisPool.getResource();
            try {
                //redis里面的key（这里的key其实可以使用MD5加密，但是意义不大)
                String key = "Session"+ID;
                //redis获取数据
                byte[] bytes = jedis.get(key.getBytes());
                if(bytes != null){
                    //创建一个空对象
                    MySession mySession = schema.newMessage();
                    //数据内容填充到空对象里面
                    ProtostuffIOUtil.mergeFrom(bytes, mySession, schema);
                    //返回对象
                    return mySession;
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


    //将session保存到redis里面
    public String putMySession(MySession mySession){

        System.out.println("进入PUTsession");

        try{
            Jedis jedis = jedisPool.getResource();
            try{
                //将用户名作为key(这里的key其实可以使用MD5加密，但是意义不大)
                String key = "Session"+mySession.getId();
                //三个参数，第一个序列化的对象，第二个schema，第三个缓存器大小
                byte[] bytes = ProtostuffIOUtil.toByteArray(mySession,schema,
                        LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
                int timeout = 60*60;//缓存时间一个小时
                //这里使用的是redis的缓存超时方式（保存到redis）
                String result = jedis.setex(key.getBytes(), timeout, bytes);

                return result;

            }finally {
                jedis.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Session保存");
        return null;
    }
}
