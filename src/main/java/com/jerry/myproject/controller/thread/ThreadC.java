package com.jerry.myproject.controller.thread;

/**
 * @author jerry
 */
public class ThreadC implements Runnable {


    @Override
    public void run() {

        System.out.println("当前线程" + Thread.currentThread().getName());
    }


    public static void main(String[] args) {

        ThreadC c = new ThreadC();

        Thread thread = new Thread(c);
        thread.start();



    }

}


