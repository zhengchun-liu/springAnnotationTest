package com.springtestlzc.dtos;

import java.util.concurrent.CountDownLatch;

public class CountCownLatchThread implements Runnable {

    private String threadName;

    private CountDownLatch latch;

    public CountCownLatchThread(String threadName, CountDownLatch latch) {
        this.threadName = threadName;
        this.latch = latch;
    }

    public void run() {
        System.out.println("线程" + threadName + "开始工作");
        try {
            //模拟线程工作
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程" + threadName + "完成工作");
        latch.countDown();
    }

    public static void main(String[] args) throws InterruptedException {
        //直接使用main线程作为主线程
//        CountDownLatch latch = new CountDownLatch(2);
//        System.out.println("主线程需要等待子线程执行完成后再执行");
//        Thread threadA = new Thread(new CountDownLatchThread("A", latch));
//        Thread threadB = new Thread(new CountDownLatchThread("B", latch));
//        threadA.start();
//        threadB.start();
//        latch.await();
//        System.out.println("子线程执行完成了，主线程继续执行");

        //创建主线程X
        Thread threadX = new Thread(new Runnable() {
            CountDownLatch latch = new CountDownLatch(2);

            public void run() {
                System.out.println("主线程需要等待子线程执行完成后再执行");
                Thread threadA = new Thread(new CountCownLatchThread("A", latch));
                Thread threadB = new Thread(new CountCownLatchThread("B", latch));
                threadA.start();
                threadB.start();
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("子线程执行完成了，主线程继续执行");
            }
        });
        //启动主线程X
        threadX.start();
    }


}
