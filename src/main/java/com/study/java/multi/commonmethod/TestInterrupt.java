package com.study.java.multi.commonmethod;

/**
 * Created by yan on  07/09/2018.
 */
public class TestInterrupt extends Thread{

    @Override
    public  void run(){
        for (int i = 0; i < 1000000; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        //当前线程是否停止 两个false
        TestInterrupt thread = new TestInterrupt();
        thread.start();
        thread.interrupt();
        System.out.println(thread.interrupted());
        System.out.println(thread.interrupted());
    }

}
