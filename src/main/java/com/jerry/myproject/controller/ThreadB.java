package com.jerry.myproject.controller;

/**
 * @program: my-project
 * @description:
 * @author: wangyj
 * @create: 2020-11-07 14:45
 **/
public class ThreadB implements Runnable {


    private String name;

    public ThreadB(String name) {
        this.name = name;
    }


    @Override
    public void run() {

        for (int i = 0; i < 5; i++) {
            System.out.println(name + "线程:" + i);
            try {
                Thread.sleep((int) Math.random() * 10);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


    public static void main(String[] args) {
        ThreadB thread1 = new ThreadB("A");
        ThreadB thread2 = new ThreadB("B");

        thread1.run();
        thread2.run();
    }

}
