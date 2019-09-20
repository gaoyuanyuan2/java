package com.study.java.multi.lock.lock1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/*
* 1、非静态方法的锁默认为this，静态方法的锁对应的Class实例。
* 2、某一个时刻内，只能有一个线程持有锁，无论几个方法。
*
*
* */

public class UseCondition {

	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	
	public void method1(){
		try {
			lock.lock();
			System.out.println("Thread:" + Thread.currentThread().getName() + "sleep..");
			Thread.sleep(3000);
			System.out.println("Thread:" + Thread.currentThread().getName() + "await..");
			condition.await();	// Object wait
			System.out.println("Thread:" + Thread.currentThread().getName() +"go on ...");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	public void method2(){
		try {
			lock.lock();
			System.out.println("Thread:" + Thread.currentThread().getName() + "into..");
			Thread.sleep(3000);
			System.out.println("Thread:" + Thread.currentThread().getName() + "signal..");
			condition.signal();		//Object notify
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		final UseCondition uc = new UseCondition();
		Thread t1 = new Thread(()->uc.method1(), "t1");
		Thread t2 = new Thread(()->uc.method2(), "t2");
		t1.start();
		Thread.sleep(5);
		t2.start();
	}
	
	
	
}
