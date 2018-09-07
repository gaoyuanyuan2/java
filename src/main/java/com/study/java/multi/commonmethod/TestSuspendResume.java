package com.study.java.multi.commonmethod;

/**
 * Created by yan on  07/09/2018.
 */
public class TestSuspendResume extends  Thread {

    @Override
    public  void run(){
        for (int i = 0; i < 1000000; i++) {
            System.out.println(i);
        }
    }
    //独占，不同步
    public static void main(String[] args) throws InterruptedException {
        TestSuspendResume thread = new TestSuspendResume();
        thread.start();
        Thread.sleep(2000);
        thread.suspend();
        Thread.sleep(2000);
        thread.resume();
    }
}
