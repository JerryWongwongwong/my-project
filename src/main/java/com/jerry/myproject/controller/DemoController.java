package com.jerry.myproject.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.ReentrantLock;

@RestController
public class DemoController {




    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = simpleDateFormat.parse("2019-09-09 12:00:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long time1 = date.getTime();
        System.out.println(time1);

        System.out.println(time1);

    }


    /**
     * demo
     *
     * @return
     */
    @RequestMapping("sayHello")
    public String sayHello() {

        return "hello!";
    }
//
//    @RequestMapping("cacheDemo")
//    public String cacheDemo() {
//
//        loadingCache.get();
//
//
//
//    }

}
