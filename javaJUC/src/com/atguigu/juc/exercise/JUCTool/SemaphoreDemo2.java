package com.atguigu.juc.exercise.JUCTool;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo2 {
    public static void main(String[] args) {
        Semaphore SM = new Semaphore(3);
        for(int i=0;i<6;i++){
            new Thread(()->{
                try {
                    SM.acquire();
                    System.out.println(Thread.currentThread().getName()+"获得资源");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(Thread.currentThread().getName()+"释放资源");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    SM.release();
                }

            },"线程"+i).start();
        }
    }
}
