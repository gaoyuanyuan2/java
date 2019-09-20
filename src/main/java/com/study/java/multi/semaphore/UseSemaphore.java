package com.study.java.multi.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

//信号灯，5个支付柜台，6个人就有一个人要等待
public class UseSemaphore {  
  
    public static void main(String[] args) {
        // 线程池  
        ExecutorService exec = Executors.newCachedThreadPool();
        // 只能5个线程同时访问  
        final Semaphore semp = new Semaphore(5);
//                final Semaphore semp2 = new Semaphore(5,true); //是否公平
        // 模拟20个客户端访问  
        for (int index = 0; index < 20; index++) {  
            final int NO = index;  
            Runnable run = new Runnable() {
                public void run() {  
                    try {  
                        // 获取许可  
                        semp.acquire();  
                        System.out.println("Accessing: " + NO);
                        System.out.println("Thread " + Thread.currentThread().getName() +
                                " into " + (5-semp.availablePermits()) + "");
                        //模拟实际业务逻辑
                        Thread.sleep((long) (Math.random() * 10000));
                        // 访问完后，释放  
                        semp.release();  
                    } catch (InterruptedException e) {
                    }  
                }  
            };  
            exec.execute(run);  
        } 
        
        try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        
        //System.out.println(semp.getQueueLength());
        
        
        
        // 退出线程池  
        exec.shutdown();  
    }  
  
}  