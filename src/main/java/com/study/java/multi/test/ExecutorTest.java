package com.study.java.multi.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorTest {
    public static void main(String[] args) {
        test2();
        test3();
    }


    public static void test(){
        /**
         *
         * CachedThreadPool：一个任务创建一个线程；
         * FixedThreadPool：所有任务只能使用固定大小的线程；
         * SingleThreadExecutor：相当于大小为 1 的 FixedThreadPool。
         *
         **/
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            executorService.execute(()->
                    System.out.println("run"+ finalI)
            );
        }
        executorService.shutdown();
    }

    public static void test2(){
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("Thread run");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.shutdownNow();
        System.out.println("Main run");
    }

    public static void test3(){
        /**
         * 如果只想中断 Executor 中的一个线程，可以通过使用 submit() 方法来提交一个线程，它会返回一个 Future<?> 对象，
         * 通过调用该对象的 cancel(true) 方法就可以中断线程。
         **/
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<?> future = executorService.submit(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("Thread run");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        future.cancel(true);
    }

}
