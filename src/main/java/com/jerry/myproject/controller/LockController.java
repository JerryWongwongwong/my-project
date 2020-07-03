package com.jerry.myproject.controller;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Jerry
 * @date 03/07/2020 11:13
 * @desc
 */
public class LockController {

    /**
     * 悲观锁
     */
    // 需要保证多个线程使用的是同一个锁
    private ReentrantLock lock = new ReentrantLock();
    public void modifyPublicResources() {
        lock.lock();

        // 操作同步资源


        lock.unlock();
    }

    // synchronized
    public synchronized void testMethod() {
        // 操作同步资源
    }
}
