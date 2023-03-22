package com.jerry.myproject.package1;

/**
 * CopyRight (c)2018-2023 : cargogm.com
 * Project :  my-project
 * Comments : <对此类的描述，可以引用系统设计中的描述>
 * JDK version : JDK1.8
 * Create Date : 2023/02/22 16:47
 *
 * @author : Jerry
 * @version : 1.0
 * @since : 1.0
 */
public class ConcreteHandler2 extends Handler{
    @Override
    public void handleRequest(String request) {
        if(request.equals("two"))  {
            System.out.println("具体处理者2负责处理该请求！");
        }
        else {
            if(getNext()!=null) {
                getNext().handleRequest(request);
            }
            else {
                System.out.println("没有人处理该请求！");
            }
        }
    }
}
