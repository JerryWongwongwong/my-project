package com.jerry.myproject.controller.thread;


/**
 * @author jerry
 */
public class ReentrantTest implements Runnable {

    @Override
    public void run() {
        get();
    }


    public synchronized void set() {
        System.out.println("线程：" + Thread.currentThread().getName());
    }

    public synchronized void get() {
        System.out.println("线程：" + Thread.currentThread().getName());
        set();
    }


    /**
     * 可重入锁
     *
     * 广义上的可重入锁指的是可重复可递归调用的锁，在外层使用锁之后，
     * 在内层仍然可以使用，并且不发生死锁（前提得是同一个对象或者class），
     * 这样的锁就叫做可重入锁。ReentrantLock和synchronized都是可重入锁
     * @param args
     */
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            new Thread(new ReentrantTest()).start();
        }


    }


}
