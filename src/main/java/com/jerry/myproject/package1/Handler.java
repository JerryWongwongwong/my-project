package com.jerry.myproject.package1;

/**
 * CopyRight (c)2018-2023 : cargogm.com
 * Project :  my-project
 * Comments : <对此类的描述，可以引用系统设计中的描述>
 * JDK version : JDK1.8
 * Create Date : 2023/02/22 16:45
 *
 * @author : Jerry
 * @version : 1.0
 * @since : 1.0
 */
public abstract class Handler {

    private Handler next;


    // 用来设置下一个处理者
    public void setNext(Handler next) {
        this.next=next;
    }
    public Handler getNext() {
        return next;
    }
    //处理请求的方法
    public abstract void handleRequest(String request);
}
