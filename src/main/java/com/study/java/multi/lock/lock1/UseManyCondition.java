package com.study.java.multi.lock.lock1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class UseManyCondition {

    private ReentrantLock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();

    public void m1() {
        try {
            lock.lock();
            System.out.println("Thread:" + Thread.currentThread().getName() + " m1 wait..");
            c1.await();
            System.out.println("Thread:" + Thread.currentThread().getName() + " m1 go on..");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void m2() {
        try {
            lock.lock();
            System.out.println("Thread:" + Thread.currentThread().getName() + " m2 wait..");
            c1.await();
            System.out.println("Thread:" + Thread.currentThread().getName() + " m2 go on..");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void m3() {
        try {
            lock.lock();
            System.out.println("Thread:" + Thread.currentThread().getName() + " m3 wait ..");
            c2.await();
            System.out.println("Thread:" + Thread.currentThread().getName() + " m3 go on..");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void m4() {
        try {
            lock.lock();
            System.out.println("Thread:" + Thread.currentThread().getName() + " signalAll..");
            c1.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void m5() {
        try {
            lock.lock();
            System.out.println("Thread:" + Thread.currentThread().getName() + " signalAll..");
            c2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {


        final UseManyCondition umc = new UseManyCondition();
        Thread t1 = new Thread(() -> umc.m1(), "t1");
        Thread t2 = new Thread(() -> umc.m2(), "t2");
        Thread t3 = new Thread(() -> umc.m3(), "t3");
        Thread t4 = new Thread(() -> umc.m4(), "t4");
        Thread t5 = new Thread(() -> umc.m5(), "t5");

        t1.start();    // c1
        t2.start();    // c1
        t3.start();    // c2


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t4.start();    // c1
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t5.start();    // c2

    }


}
