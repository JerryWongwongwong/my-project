package com.jerry.myproject.server.impl;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * CopyRight (c)2018-2022 : cargogm.com
 * Project :  my-project
 * Comments : <对此类的描述，可以引用系统设计中的描述>
 * JDK version : JDK1.8
 * Create Date : 2022/12/05 16:26
 *
 * @author : Jerry
 * @version : 1.0
 * @since : 1.0
 */
@Service
public class CacheService {


    @Cacheable(value = "tokenCache", key = "methodName")
    public int getNum() {

        System.out.println("===进入getNum");
        Random rd = new Random();
        int i = rd.nextInt();
        System.out.println("随机数：" + i);
        return i;

    }
}
