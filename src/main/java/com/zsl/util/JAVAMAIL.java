package com.zsl.util;

import com.sun.mail.util.MailSSLSocketFactory;
import com.zsl.dto.VailEmailPackage;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by 蛮夷麟爷 on 2017-08-02.
 */

public class JAVAMAIL {


    //用来发送验证邮件的邮件信息
    public static boolean sendVailEmail(VailEmailPackage emailPackage){
        Properties prop = new Properties();
        //开启调试模式，以便在控制台查看
        prop.setProperty("mail.debug", "true");
        //设置邮件服务器住主机名
        prop.setProperty("mail.host", "smtp.qq.com");
        //发送服务器需要身份验证
        prop.setProperty("mail.smtp.auth", "true");
        //发送邮件协议名称
        prop.setProperty("mail.transport.protocol", "smtp");

        try {
            //开启SSL加密,否则会失效
            MailSSLSocketFactory sf = new MailSSLSocketFactory();
            sf.setTrustAllHosts(true);
            prop.put("mail.smtp.ssl.enable", "true");
            prop.put("mail.smtp.ssl.socketFactory", sf);
            //创建session
            Session session = Session.getInstance(prop);
            //通过Session得到transport
            Transport ts = session.getTransport();
            //连接邮件服务器：邮箱类型，账号，授权码代替密码（更加安全）
            ts.connect("smtp.qq.com", "2397225430", "szcwfqzajgmbecae");
            //创建邮件
            Message message = new MimeMessage(session);
            //指明发件人
            message.setFrom(new InternetAddress("2397225430@qq.com"));
            //指明收件人
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(emailPackage.getEmail()));
            //邮件标题
            message.setSubject("南蛮麟爷JavaMail邮件测试");
            //邮件文本内容
            //获取本机外网IP，如果获取失败不发送邮件
            //String ip = Get_IP_Host.INTERNET_IP;

          // if(ip!=null) {
                message.setText("点击访问该网址完成邮箱验证：http://119.29.209.127:86/Friend/ToVailEmail/" + emailPackage.getUsername() + "/" + emailPackage.getVailToken());
          //  }

            //发送邮件
            ts.sendMessage(message, message.getAllRecipients());
            ts.close();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
