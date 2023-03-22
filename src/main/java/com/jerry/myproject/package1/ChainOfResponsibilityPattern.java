package com.jerry.myproject.package1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * CopyRight (c)2018-2023 : cargogm.com
 * Project :  my-project
 * Comments : <对此类的描述，可以引用系统设计中的描述>
 * JDK version : JDK1.8
 * Create Date : 2023/02/22 16:44
 *
 * @author : Jerry
 * @version : 1.0
 * @since : 1.0
 */
public class ChainOfResponsibilityPattern {


    public static void main(String[] args) {
        //组装责任链
        Handler handler1 = new ConcreteHandler1();
        Handler handler2 = new ConcreteHandler2();
        Handler handler3 = new ConcreteHandler3();

        handler1.setNext(handler2);
        handler2.setNext(handler3);

        //提交请求
        handler1.handleRequest("4");
//        InvocationHandler handler = new InvocationHandler(handler3);
//        Object o = (Handler)Proxy.newProxyInstance(ConcreteHandler3.class.getClassLoader(),ConcreteHandler3.class.getInterfaces(), handler);
    }



}
