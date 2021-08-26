package com.springtestlzc.tx;

import sun.applet.AppletClassLoader;
import sun.misc.Unsafe;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Exchanger;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class VolatileReOrderTest {

    //private volatile static int a=0, b = 0;
    //private volatile static int x=0, y = 0;
    private static int a=0, b = 0;
    private static int x=0, y = 0;
    static Object object = new Object();
    public static void main(String[] args) throws InterruptedException {

        Semaphore semaphore = new Semaphore(2);
        semaphore.acquire();
        semaphore.release();
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
        Executors.newFixedThreadPool(10);
        //Exchanger

        int i = 0;
        for(;;) {
            i++;
            a=0; b = 0;
            x=0; y = 0;
            Thread t1 = new Thread(new Runnable() {
                public void run() {
                    shortWait(10000);
                    a = 1;//是读是写？store，volatile写
                    //storeload屏障，不允许volatile写与第二步的volatile读发生重排

                    x = b;//是读是写？先读后写
                    //先读volatile
                    //
                    //再写普通变量
                }
            });
            Thread t2 = new Thread(new Runnable() {
                public void run() {
                    b = 1;
                    y = a;
                }
            });

            t1.start();
            t2.start();
            t1.join();
            t2.join();
            String result = "第" + i + "次执行(" + x + "," + y +")";
            if (x == 0 && y == 0) {
                System.out.println(result);
                break;
            } else {
                System.out.println(result);
            }
        }
    }
    public static void  shortWait(long interval) {
        long start = System.nanoTime();
        long end;
        do {
            end = System.nanoTime();
        } while (start + interval >= end);
    }
}
