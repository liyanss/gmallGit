package com.atguigu.juc;

public class WaitNotifyDamo {
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

class Demo{
    Integer number=0;
    synchronized void add() throws InterruptedException {
        while(number!=0){
            wait();
        }
        System.out.println("当前线程："+Thread.currentThread().getName()+"number为"+(++number));

        notifyAll();
    }
    synchronized void  sub() throws InterruptedException {
        while(number==0){
            wait();
        }
        System.out.println("当前线程："+Thread.currentThread().getName()+"number为"+(--number));

        notifyAll();
    }


}
