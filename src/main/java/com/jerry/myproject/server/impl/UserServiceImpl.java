package com.jerry.myproject.server.impl;

import com.jerry.myproject.server.UserService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author Jerry
 * @date 30/03/2020 00:12
 * @desc
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public Integer countUser() {
        return 1;
    }


    @Async
    public void longtime() {
        System.out.println("我在执行一项耗时任务");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("完成");

    }
}
