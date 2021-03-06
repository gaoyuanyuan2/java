package com.study.java.multi.cyclicbarrier;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
//都执行完了一起出发，可以模拟高并发
public class UseCyclicBarrier {

	static class Runner implements Runnable {
	    private CyclicBarrier barrier;
	    private String name;
	    
	    public Runner(CyclicBarrier barrier, String name) {
	        this.barrier = barrier;  
	        this.name = name;  
	    }  
	    @Override
	    public void run() {  
	        try {  
	            Thread.sleep(1000 * (new Random()).nextInt(5));
	            System.out.println(name + "OK."+System.currentTimeMillis());
	            barrier.await();  
	        } catch (InterruptedException e) {
	            e.printStackTrace();  
	        } catch (BrokenBarrierException e) {
	            e.printStackTrace();  
	        }  
	        System.out.println(name + " Go!!"+System.currentTimeMillis());
	    }  
	} 
	
    public static void main(String[] args) throws IOException, InterruptedException {
        CyclicBarrier barrier = new CyclicBarrier(3);  // 3
        ExecutorService executor = Executors.newFixedThreadPool(3);
        
        executor.submit(new Thread(new Runner(barrier, "zhangsan")));
        executor.submit(new Thread(new Runner(barrier, "lisi")));
        executor.submit(new Thread(new Runner(barrier, "wangwu")));
  
        executor.shutdown();
    }  
  
}  