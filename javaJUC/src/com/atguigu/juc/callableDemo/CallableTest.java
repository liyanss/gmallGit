package com.atguigu.juc.callableDemo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {
    public static void main(String[] args) {
        FutureTask<Integer> in = new FutureTask<>(
                () -> {
                    Thread.sleep(12222);
                    return 10000 * 23;
                }
        );

        new Thread(in,"张三").start();
        new Thread(in,"张三").start();
        try {
            System.out.println(in.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("____________________");
    }

}
class myThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        return 10000*23;
    }
}