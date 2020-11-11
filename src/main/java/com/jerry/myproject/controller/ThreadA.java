package com.jerry.myproject.controller;

/**
 * @program: my-project
 * @description:
 * @author: wangyj
 * @create: 2020-11-07 14:22
 **/
public class ThreadA extends Thread {

    private String name;

    public ThreadA(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name + "运行  :  " + i);
            try {
                sleep((int) Math.random() * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();

            }
            super.run();
        }
    }


    public static void main(String[] args) {
        ThreadA mTh1 = new ThreadA("A");
        ThreadA mTh2 = new ThreadA("B");
        mTh1.start();
        mTh2.start();
    }
}
