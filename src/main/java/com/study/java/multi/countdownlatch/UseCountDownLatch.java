package com.study.java.multi.countdownlatch;

import java.util.concurrent.CountDownLatch;
/**
 * 信号灯等待执行，倒计时。实现类似计数器的功能
 *
 * 用来控制多个线程互相等待，只有当多个线程都到达时，这些线程才会继续执行。

 和 CountdownLatch 相似，都是通过维护计数器来实现的。线程执行 await() 方法之后计数器会减 1，并进行等待，直到计数器为 0，所有调用 await() 方法而在等待的线程才能继续执行。

 CyclicBarrier 和 CountdownLatch 的一个区别是，CyclicBarrier 的计数器通过调用 reset() 方法可以循环使用，所以它才叫做循环屏障。

 CyclicBarrier 有两个构造函数，其中 parties 指示计数器的初始值，barrierAction 在所有线程都到达屏障的时候会执行一次。
 */
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
