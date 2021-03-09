package com.jerry.myproject.controller;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
public class DemoController implements InitializingBean {


    static Integer initNum = 100;

    /**
     * demo
     *
     * @return
     */
    @RequestMapping("sayHello")
    public String sayHello() {

        //线程不安全
        List<String> list = new ArrayList<>();
        //线程安全
        List<String> objects = new Vector<>();
        List<String> list1 = Collections.synchronizedList(new ArrayList<>());
        //线程安全效率高 lock锁
        List<String> list2 = new CopyOnWriteArrayList<>();
        return "hello!";
    }

    /**
     * 从请求路径获取参数
     *
     * @param id
     */
    @RequestMapping("/path/{id}")
    public void method(@PathVariable("id") String id) {


    }






    @Override
    public void afterPropertiesSet() throws Exception {
        initNum = 101;
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
    }


}
