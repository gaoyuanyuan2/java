package com.study.java.multi.commonmethod;

/**
 * Created by yan on  07/09/2018.
 */
public class TestIsAlive extends Thread{
    @Override
    public void run() {
        System.out.println("run="+this.isAlive());
    }
    public static void main(String[] args) throws InterruptedException {
        TestIsAlive thread = new TestIsAlive();
        System.out.println("main start="+thread.isAlive());
        thread.start();
        Thread.sleep(1000);
        System.out.println("main end ="+thread.isAlive());
    }
}
