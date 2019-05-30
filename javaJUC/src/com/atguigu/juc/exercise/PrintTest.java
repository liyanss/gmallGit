package com.atguigu.juc.exercise;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintTest {
    public static void main(String[] args) {
        resoureClass r1 = new resoureClass();
        new Thread(()->{
            for(int i=0;i<26;i++){
                    r1.println1();
            }

        }).start();
        new Thread(()->{
            //try {
//.sleep(1000);
                for(int i=0;i<26;i++) {
                    r1.println2();
                }
           // } catch (InterruptedException e) {
            //   e.printStackTrace(); }
        }).start();
        new Thread(()->{
            //try {
             //   Thread.sleep(3000);
                for(int i=0;i<26;i++) {
                    r1.printlnAZ();
                }
          //  } catch (InterruptedException e) {
    // } finally {
        //   }
        }).start();

    }

}
class resoureClass{
          int i=1;
          int j=2;
           char c='A';
          Lock lock=new ReentrantLock();
          Condition c1=lock.newCondition();
          Condition c2=lock.newCondition();
          Condition c3=lock.newCondition();

    public void  println1(){
       try {
            lock.lock();
           c2.notify();
            System.out.println(i);
            i=i+2;
          c1.await();

         } catch (InterruptedException e) {
             e.printStackTrace();
           } finally {
            lock.unlock();
          }

    }
    public void println2(){
        try {

            lock.lock();
            c3.signal();
            System.out.println(j);
            j=j+2;
            c2.await();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
    public void printlnAZ(){
        try {

            lock.lock();
            c1.signal();
            System.out.println(c);
            c= (char)(c+1);

            c3.await();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
}