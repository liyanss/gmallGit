package com.atguigu.juc.exercise.JUCTool;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {


    public static void main(String[] args) {

        CyclicBarrier cb = new CyclicBarrier(7,()->{
            System.out.println(Thread.currentThread().getName()+"召唤神龙");
        });

        for(int i=0;i<7;i++){
            new Thread(()->{
                try {
                    System.out.println(Thread.currentThread().getName()+"收集龙珠");
                    cb.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },"线程"+i).start();
        }

    }
}
