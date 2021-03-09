package com.jerry.myproject.test;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author Jerry
 * @Description
 * @createTime 2021年02月26日 14:26:00
 */
public class Test1 {

    public static void main(String[] args) {
        add();
    }

    public static void add(){
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<>(3);


        System.out.println(arrayBlockingQueue.add("a"));
        System.out.println(arrayBlockingQueue.add("b"));
        System.out.println(arrayBlockingQueue.add("c"));

        //抛出异常
//        System.out.println(arrayBlockingQueue.add("d"));

        //不抛异常，返回false
//        System.out.println(arrayBlockingQueue.offer("d"));

        System.out.println(arrayBlockingQueue.remove());
        System.out.println(arrayBlockingQueue.remove());
        System.out.println(arrayBlockingQueue.remove());

        //抛出异常
        System.out.println(arrayBlockingQueue.remove());

        //不抛异常
        System.out.println(arrayBlockingQueue.poll());

    }
}
