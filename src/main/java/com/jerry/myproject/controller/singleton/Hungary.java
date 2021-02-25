package com.jerry.myproject.controller.singleton;

/**
 * @author jerry
 */
public class Hungary {

    /**
     * 饿汉式单例
     * 没有使用，在启动的时候也创建了，容易造成内存浪费
     * 不是懒加载
     */
    private Hungary(){}


    public static Hungary hungarySingleton = new Hungary();

    public static Hungary getInstance(){

        return hungarySingleton;
    }


}
