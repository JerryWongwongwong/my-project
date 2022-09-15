package com.jerry.myproject.util;

import org.assertj.core.util.Lists;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * CopyRight (c)2018-2022 : cargogm.com
 * Project :  my-project
 * Comments : <对此类的描述，可以引用系统设计中的描述>
 * JDK version : JDK1.8
 * Create Date : 2022/09/09 10:31
 *
 * @author : Jerry
 * @version : 1.0
 * @since : 1.0
 */
public class EmailSend {

    public static void main(String[] args) throws Exception {

        // =============================================
        // 1. 连接上发送邮件的服务器
        // 创建属性文件对象
        Properties pro = new Properties();
        // 需要指定邮件的服务器地址，复制一下。推荐去复制，自己写容易写错了。
        //以qq邮箱为例子
        // 邮件服务器主机
        pro.setProperty("mail.host","smtp.exmail.qq.com");
        // 邮件传输协议
        pro.setProperty("mail.transport.protocol","smtp");
        // 设置邮件发送需要认证
        pro.put("mail.smtp.auth","true");
        // 连接邮件的服务器，会话
        Session session = Session.getDefaultInstance(pro);
        // 获取到传输对象
        Transport transport = session.getTransport();
        // 是固定，必须传入授权码
        //在这里两个参数，第一个参数是你的邮箱，第二个参数是授权码
        transport.connect("wangyj@olymtech.com","3asbJbboAgPKj5N8");

        // =============================================
        // 2. 构建出一封邮件（设置收件人、设置主题和设置正文）
        // 有邮件的类
        MimeMessage message = new MimeMessage(session);
        // 设置发件人
        //这里的参数是发件人邮箱
        message.setFrom(new InternetAddress("wangyj@olymtech.com"));

        // 设置收件人
        // Message.RecipientType.TO 表示收件人
        // Message.RecipientType.CC 表示抄送给XXX
        // Message.RecipientType.BCC 表示暗送
        message.setRecipient(Message.RecipientType.TO,new InternetAddress("wangyj@olymtech.com"));
//        message.setRecipient(Message.RecipientType.CC,new InternetAddress("chenrj@olymtech.com"));
//        message.setRecipient(Message.RecipientType.CC,new InternetAddress("jinjw@olymtech.com"));
        message.setRecipient(Message.RecipientType.CC,new InternetAddress("zhuyk@olymtech.com","chenrj@olymtech.com","jinjw@olymtech.com"));

        List<InternetAddress> userList = Lists.newArrayList(new InternetAddress("jinjw@olymtech.com"),new InternetAddress("chenrj@olymtech.com"));
        Object[] objects = userList.toArray();
//        message.setRecipient(Message.RecipientType.CC,new InternetAddress[]);



//        System.out.println(a);

        // message.setRecipient(Message.RecipientType.CC,new InternetAddress(""));

        // 设置主题
        message.setSubject("测试邮件");
        // 设置正文
        message.setContent("点击链接：v我50，把你肚子搞大，疯狂星期四🍗   http://m.kfc.com.cn/","text/html;charset=UTF-8");

        // =============================================
        // 3. 发送邮件
        transport.sendMessage(message,message.getAllRecipients());
        System.out.println("发送成功");
        // 关闭连接
        transport.close();
    }

}
