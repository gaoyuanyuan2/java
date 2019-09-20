package com.study.java.multi.countdownlatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
/**
 * wait notfiy 方法，wait释放锁，notfiy不释放锁
 *
 * countDownLatch和锁无关，信号灯等待执行，zookeeper连接 回调通知执行
 * @author alienware
 *
 */
public class ListAdd2 {
	private volatile static List list = new ArrayList();	
	
	public void add(){
		list.add("bjsxt");
	}
	public int size(){
		return list.size();
	}
	
	public static void main(String[] args) {
		
		final ListAdd2 list2 = new ListAdd2();
		
		// 1 实例化出来一个 lock
		// 当使用wait 和 notify 的时候 ， 一定要配合着synchronized关键字去使用
		//final Object lock = new Object();
		
		final CountDownLatch countDownLatch = new CountDownLatch(1);
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					//synchronized (lock) {
						for(int i = 0; i <10; i++){
							list2.add();
							System.out.println("Thread:" + Thread.currentThread().getName() + "add..");
							Thread.sleep(500);
							if(list2.size() == 5){
								System.out.println("notify..");
								countDownLatch.countDown();
								//lock.notify();
							}
						}						
					//}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}, "t1");
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				//synchronized (lock) {
					if(list2.size() != 5){
						try {
							//System.out.println("t2进入...");
							//lock.wait();
							countDownLatch.await();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					System.out.println("Thread:" + Thread.currentThread().getName() + "stop..");
					throw new RuntimeException();
				//}
			}
		}, "t2");	
		
		t2.start();
		t1.start();
		
	}
	
}
