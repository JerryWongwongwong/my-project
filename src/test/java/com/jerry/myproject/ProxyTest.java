package com.jerry.myproject;

import com.jerry.myproject.server.IUserDao;
import com.jerry.myproject.server.impl.UserDaoImpl;
import com.jerry.myproject.server.impl.UserDaoProxy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Jerry
 * @Description
 * @createTime 2021年03月04日 17:07:00
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProxyTest {

//    @Autowired
//    private UserDaoProxy userDaoProxy;

    public static void main(String[] args) {
        //目标对象
        UserDaoImpl target = new UserDaoImpl();
        //代理对象,把目标对象传给代理对象,建立代理关系
//        UserDaoProxy proxy = new UserDaoProxy(target);
//        proxy.save();//执行的是代理的方法

    }

}
