package com.jerry.myproject.server;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Jerry
 * @Description
 * @createTime 2021年03月05日 15:04:00
 */
public class LockFairTest implements Runnable {

    ReentrantLock reentrantLock = new ReentrantLock(true);


    public static void main(String[] args) {
        LockFairTest lft = new LockFairTest();
        Thread th1 = new Thread(lft);
        Thread th2 = new Thread(lft);
        th1.start();
        th2.start();
    }


    @Override
    public void run() {

        while (true) {

            reentrantLock.lock();

            try {
                System.out.println(Thread.currentThread().getName() + "获得锁");

            } finally {
                reentrantLock.unlock();
            }
        }


    }
}
