package com.study.java.multi.countdownlatch;

import java.util.concurrent.CountDownLatch;

//信号灯等待执行，倒计时。实现类似计数器的功能。
public class UseCountDownLatch {

	public static void main(String[] args) {
		
		final CountDownLatch countDown = new CountDownLatch(2);
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println("t1  wait..."+System.currentTimeMillis());
					countDown.await();
					System.out.println("t1 go on ..."+System.currentTimeMillis());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		},"t1");

		Thread t11 = new Thread(()->{
			try {
				countDown.await();
				System.out.println("t11 go on..."+System.currentTimeMillis());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		},"t11");

		Thread t12 = new Thread(()->{
			try {

				countDown.await();
				System.out.println("t12 go on..."+System.currentTimeMillis());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}},"t12");
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println("t2 init..."+System.currentTimeMillis());
					Thread.sleep(3000);
					System.out.println("t2 init over ..."+System.currentTimeMillis());
					countDown.countDown();
					System.out.println("t2 countDown..."+System.currentTimeMillis());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println("t3 init..."+System.currentTimeMillis());
					Thread.sleep(4000);
					System.out.println("t3 init over..."+System.currentTimeMillis());
					countDown.countDown();
					System.out.println("t3 countDown.."+System.currentTimeMillis());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});


		t1.start();
		t11.start();
		t12.start();
		t2.start();
		t3.start();
		
		
		
	}
}
