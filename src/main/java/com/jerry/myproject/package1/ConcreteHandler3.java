package com.jerry.myproject.package1;

/**
 * CopyRight (c)2018-2023 : cargogm.com
 * Project :  my-project
 * Comments : <对此类的描述，可以引用系统设计中的描述>
 * JDK version : JDK1.8
 * Create Date : 2023/02/22 16:53
 *
 * @author : Jerry
 * @version : 1.0
 * @since : 1.0
 */
public class ConcreteHandler3 extends Handler {

    @Override
    public void handleRequest(String request) {

        if (request.equals("three")) {
            System.out.println("three over");
        } else if (null != getNext()) {
            getNext().handleRequest(request);
        }
        System.out.println("no one handle");

    }
}
