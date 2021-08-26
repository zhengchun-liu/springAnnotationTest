package com.springtestlzc.tx;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

public class Work1 {
    private ReentrantLock lock = new ReentrantLock(true);
    private volatile int money = 100;

    public void addMoney() {
        lock.lock();
        money = money + 60;
        System.out.println("发生充值操作，当前金额：" + money);
        lock.unlock();
    }
    public void subMoney() {
        lock.lock();
        money = money - 60;
        System.out.println("发生消费操作，当前金额：" + money);
        lock.unlock();
    }
    public void queryMoney() {
        lock.lock();
        System.out.println("发查询费操作，当前金额：" + money);
        lock.unlock();
    }

    public static void main(String[] args) {
        Work1 work1 = new Work1();
        //int monye = 100;
        Thread thread1 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        work1.addMoney();
                    }
                }
        );
        Thread thread2 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        work1.subMoney();
                    }
                }
        );
        Thread thread3 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        work1.queryMoney();
                    }
                }
        );
        thread1.start();
        thread2.start();
        thread3.start();
        new ArrayBlockingQueue(1);
    }
}
