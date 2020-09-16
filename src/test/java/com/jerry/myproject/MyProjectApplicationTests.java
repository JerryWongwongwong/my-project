package com.jerry.myproject;

import com.jerry.myproject.server.UserService;
import com.jerry.myproject.server.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.Async;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;

/**
 * springboot单元测试类
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class MyProjectApplicationTests {


    @Autowired
    private UserServiceImpl userService;


    @Test
    void contextLoads() throws IOException, ExecutionException, InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<Integer> future = executor.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {

                System.out.println("===task start===");
                Thread.sleep(5000);
                System.out.println("===task finish===");
                return 3;
            }
        });

        Integer result=future.get();
        System.out.println("result:" + result);
        System.out.println("main函数执行结束");

        System.in.read();


    }


    @Test
    void testAsync() throws InterruptedException {
        System.out.println("begin");

        asyncMethod();
        System.out.println("end");
    }

    @Async
    public String asyncMethod() throws InterruptedException {

        Thread.sleep(5000);
        System.out.println("----");
        return "CBD";
    }


    @Test
    public void test3() throws Exception {
        System.out.println("main函数开始执行");
        userService.longtime();
        System.out.println("main函数执行结束");
    }



}
