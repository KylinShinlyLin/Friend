这是一个JAVA_WEB的交友系统（IDEA开发）
====
这个目前只是一个功能实现的集合
目前来说架构没有完全成型，只是一个demo的集合体
----
1、实现了拦截器拦截放行请求的demo <br/>
2、实现了模仿Redis的HttpSession的并实现序列化的demo（验证码的session共享） <br/>
3、实现了WebSocket的demo（地图定位请求为：/get/Map） <br/>
4、目前能比较合理的支持负载均衡 <br/>
5、架构为（SSH）使用的是Hibernate的jpa（后来有想过要修改为Mybatis） <br/>
6、引入了google的验证码 <br/>
8、加入了对rabbitmq的Produce和Consumer的支持（spring的支持）后续考虑换成rocketmq <br/>
9、手动写了java邮件认证的demo，并通过rabbitmq进行邮箱认证 <br/>
10、本平台框架使用了cookie作为Token载体 <br/>
	使用的是令牌下发的方式登录认证（默认登录时间为1小时可以在redis修改）<br/>
	一次登录就无需再次登录 <br/>


