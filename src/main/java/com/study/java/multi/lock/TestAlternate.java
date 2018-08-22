package com.study.java.multi.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestAlternate {
    //线程执行顺序标记,1:表示loopA执行，2：表示loopB执行，3：表示loopC执行
    private volatile int number = 1;
    //获得lock锁
    private Lock lock = new ReentrantLock();
    //创建三个condition对象用来await(阻塞)和signal(唤醒)指定的线程
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    protected void loopA(){
        lock.lock();//上锁
        try {

            /*如果不是第一个标志位，就阻塞，为了解决虚假唤醒问题，使用while关键字
             */
            while(number!=1){
                try {
                    c1.await();//阻塞类似wait()
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+"-A");
            number = 2;//使能第二个方法
            c2.signal();//唤醒第二个线程,类似notify()方法

        } finally {
            lock.unlock();//解锁
        }

    }

    protected void loopB(){
        lock.lock();//上锁
        try {

            //如果不是第一个标志位，就阻塞
            while(number!=2){
                try {
                    c2.await();//阻塞类似wait()
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+"-B");
            number = 3;//使能第3个方法
            c3.signal();//唤醒第三个线程,类似notify()方法

        } finally {
            lock.unlock();//解锁
        }
    }
    protected void loopC(){
        lock.lock();//上锁
        try {

            //如果不是第一个标志位，就阻塞
            while(number!=3){
                try {
                    c3.await();//阻塞类似wait()
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+"-C");
            number = 1;//使能第1个方法
            c1.signal();//唤醒第一个线程,类似notify()方法

        } finally {
            lock.unlock();//解锁
        }
    }

    public static void main(String[] args) {
        TestAlternate testAlternate = new TestAlternate();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <20 ; i++) {
                    testAlternate.loopA();
                }
            }
        },"A").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <20 ; i++) {
                    testAlternate.loopB();
                }
            }
        },"B").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <20 ; i++) {
                    testAlternate.loopC();
                }
            }
        },"C").start();
    }
}
