package com.atguigu.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SaleTicket {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
         new Thread(()->{
            for (int i = 1; i <= 40; i++)
            {ticket.sale();}
        },"线程一").start();
        new Thread(()->{
            for (int i = 1; i <= 40; i++)
            {ticket.sale();}
        },"线程二").start();
        new Thread(()->{
            for (int i = 1; i <= 40; i++)
            {ticket.sale();}
        },"线程三").start();
        new Thread(()->{
            for (int i = 1; i <= 40; i++)
            {ticket.sale();}
        },"线程四").start();
        new Thread(()->{
            for (int i = 1; i <= 40; i++)
            {ticket.sale();}
        },"线程五").start();  new Thread(()->{
            for (int i = 1; i <= 40; i++)
            {ticket.sale();}
        },"线程六").start();


        /*new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 40; i++)
                {ticket.sale();}
            }
        },"线程一").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 40; i++) {
                    ticket.sale();
                }
            }
        },"线程二").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 40; i++) {
                    ticket.sale();
                }
            }
        },"线程三").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 40; i++) {
                    ticket.sale();
                }
            }
        },"线程四").start();*/
    }


}
 class Ticket{
    private Integer number=30;

    Lock lock=new ReentrantLock();



    public void  sale(){
        lock.lock();
        try {
            if(number>0){
                System.out.println(Thread.currentThread().getName()+":卖出一张票  还剩/"+(--number)+"张票");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
  /* 1.  public synchronized void sale(){

        try {
            if(number>0){
                System.out.println(Thread.currentThread().getName()+":卖出一张票  还剩/"+(--number)+"张票");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }*/



}