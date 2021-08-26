package com.springtestlzc.tx;

import java.util.HashMap;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

public class Work1Atomic {

    //其中"0"为初始版本号
    private static AtomicStampedReference<Integer> atomicStampedRef =
            new AtomicStampedReference<>(100, 0);
    //private static AtomicInteger atomicInteger = new AtomicInteger(100);
    public static void main(String[] args){


        Thread main = new Thread(() -> {
            int stamp = atomicStampedRef.getStamp(); //获取当前标识别，版本号
            int Money = atomicStampedRef.getReference();
            System.out.println("操作线程" + Thread.currentThread()+ "stamp="+stamp + ",初始值 a = " + atomicStampedRef.getReference());
            if (Money > 60) {
                Money = Money - 60;
                atomicStampedRef.compareAndSet(atomicStampedRef.getReference(),Money,stamp,stamp +1);
            } else {
                System.out.println("余额不足！"+ Money);
            }
            try {
                Thread.sleep(1000); //等待1秒 ，以便让干扰线程执行
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean isCASSuccess = atomicStampedRef.compareAndSet(Money,stamp,stamp,stamp +1);  //此时expectedReference未发生改变，但是stamp已经被修改了,所以CAS失败
            System.out.println("操作线程" + Thread.currentThread() + "stamp="+stamp + ",CAS操作结果: " + isCASSuccess);
        },"主操作线程");

        Thread other = new Thread(() -> {
            //取版本号
            int stamp = atomicStampedRef.getStamp();
            int money = atomicStampedRef.getReference();
            //多传俩参数，进行版本号叠加
            atomicStampedRef.compareAndSet(money,money+60,stamp,stamp+1);
            System.out.println("操作线程" + Thread.currentThread() + "stamp="+atomicStampedRef.getStamp() +",【increment】 ,值 = "+ atomicStampedRef.getReference());

        },"干扰线程");

        main.start();
        main.start();
        other.start();
    }

}
