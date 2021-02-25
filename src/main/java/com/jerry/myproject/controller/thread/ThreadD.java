package com.jerry.myproject.controller.thread;

/**
 * @author jerry
 */
public class ThreadD extends Thread {



    @Override
    public void run(){

        System.out.println("当前线程" + Thread.currentThread().getName());
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("++++++");
    }


    public static void main(String[] args) {
        ThreadD threadD = new ThreadD();

        threadD.start();
        threadD.setName("aa");

        System.out.println(threadD.getName());
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
