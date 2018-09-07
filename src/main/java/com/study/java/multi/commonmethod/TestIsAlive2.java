package com.study.java.multi.commonmethod;

/**
 * Created by yan on  07/09/2018.
 */
public class TestIsAlive2 extends Thread {

    public TestIsAlive2() {
        System.out.println("INIT" + Thread.currentThread().getName() + "=" + Thread.currentThread().isAlive());
        System.out.println("INIT" + this.getName() + "=" + this.isAlive());
    }

    @Override
    public void run() {
        System.out.println("RUN" + Thread.currentThread().getName() + "=" + Thread.currentThread().isAlive());
        System.out.println("RUN" + this.getName() + "=" + this.isAlive());
    }

    public static void main(String[] args)   {
        TestIsAlive2 thread = new TestIsAlive2();
        System.out.println("main start=" + thread.isAlive());
        thread.start();
        System.out.println("main end =" + thread.isAlive());
    }
}
