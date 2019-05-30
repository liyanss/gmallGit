package com.atguigu.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class lockDemo {
    public static void main(String[] args) {
        Demo demo = new Demo();
        new Thread(()->{
            try {
                int er=0;
                while (er<30){
                    demo.add();
                    er++;
                }
                demo.add();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"线程一").start();
        new Thread(()->{
            try {
                int er=0;
                while (er<30) {
                    demo.add();
                    er++;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"线程二").start();
        new Thread(()->{
            try {
                int er=0;
                while (er<30) {
                    demo.sub();
                    er++;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"线程三").start();
        new Thread(()->{
            try {
                int er=0;
                while (er<30) {
                    demo.sub();
                    er++;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"线程四").start();
    }

}

class Demo1{
    Lock lock = new ReentrantLock();
    Condition cd1 = lock.newCondition();
    Condition cd2= lock.newCondition();
    Integer number=0;
     void add() throws InterruptedException {
         lock.lock();
        while(number!=0){
            cd1.await();
        }
        System.out.println("当前线程："+Thread.currentThread().getName()+"number为"+(++number));

        cd2.signal();
    }
     void  sub() throws InterruptedException {
         lock.lock();
         while(number==0){
             cd2.await();
         }
         System.out.println("当前线程："+Thread.currentThread().getName()+"number为"+(--number));

         cd1.signal();
    }


}