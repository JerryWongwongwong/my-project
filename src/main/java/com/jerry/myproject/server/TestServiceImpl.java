package com.jerry.myproject.server;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * CopyRight (c)2018-2022 : cargogm.com
 * Project :  my-project
 * Comments : <对此类的描述，可以引用系统设计中的描述>
 * JDK version : JDK1.8
 * Create Date : 2022/12/06 09:39
 *
 * @author : Jerry
 * @version : 1.0
 * @since : 1.0
 */
@Component
public class TestServiceImpl{


    @PostConstruct
    public void testGuGu() throws Exception {
        System.out.println("===咕咕咕咕===");
    }


//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        System.out.println("咕咕咕咕");
//    }
}
