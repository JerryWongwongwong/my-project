package com.jerry.myproject.controller.thread;

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
                Thread.sleep( 1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


    public static void main(String[] args) {
        ThreadB a = new ThreadB("A");
        ThreadB a1 = new ThreadB("B");

        Thread thread = new Thread(a);
        Thread thread2 = new Thread(a1);

        thread.start();
        thread2.start();

    }

}
