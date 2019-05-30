package com.atguigu.juc.exercise.JUCTool;

import java.util.concurrent.Semaphore;

/**
 * permits:被所有线程抢占的公共资源的个数    多个线程强到资源会一起执行一起释放
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore se = new Semaphore(3);//设置3个资源
        for(int i=1;i<=6;i++){
            new Thread(()->{
                try {
                    se.acquire();//获得资源
                    System.out.println(Thread.currentThread().getName()+"：开始执行！");

                   Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName()+"：结束执行@@");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    se.release();//释放资源
                }

            },"线程："+i).start();
        }
    }
}
