package com.study.java.interfaces;

import java.util.concurrent.*;

/**
 * Created by yan on  02/09/2019.
 */
public class Interfaces {

    public static void main(String[] args) throws ExecutionException, InterruptedException {


        //工厂接口
        ThreadFactory factory = e -> new Thread(e);
        Thread thread = factory.newThread(() -> System.out.println("Hello World"));
        thread.start();

        //执行接口
        ExecutorService executorService = Executors.newSingleThreadExecutor(factory);
        executorService.execute(()-> System.out.println("executorService.execute"));

        Future<String> future = executorService.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Success";
        });
        System.out.println(future.get());

        executorService.shutdown();

        //回调接口
        CallbackExecutor callbackExecutor = new CallbackExecutor();
        System.out.println(0);
        callbackExecutor.execute(() -> System.out.println(111));
        callbackExecutor.execute(() -> System.out.println(222));
        TimeUnit.SECONDS.sleep(2);
        callbackExecutor.run();


    }

}
