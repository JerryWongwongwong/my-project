package com.jerry.myproject.controller.thread;

import org.springframework.beans.factory.InitializingBean;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Jerry
 * @date 03/07/2020 11:13
 * @desc
 */
public class LockController implements InitializingBean {

    /*--------------悲观锁--------------*/


    // 1、需要保证多个线程使用的是同一个锁
    private ReentrantLock lock = new ReentrantLock();

    public void modifyPublicResources() {
        lock.lock();

        // 操作同步资源

        lock.unlock();
    }


    // 2、synchronized
    public synchronized void testMethod() {
        // 操作同步资源
    }


    /*--------------乐观锁--------------*/

    public void Atomic() {
        // 需要保证多个线程使用的是同一个AtomicInteger
        AtomicInteger atomicInteger = new AtomicInteger();

        atomicInteger.incrementAndGet(); //执行自增1
    }


    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
