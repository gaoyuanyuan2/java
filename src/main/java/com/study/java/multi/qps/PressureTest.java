package com.study.java.multi.qps;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

public class PressureTest {
    private CountDownLatch latch = new CountDownLatch(10000);

    private CountDownLatch latchOver = new CountDownLatch(10000);

    private static final int QPS = 10000;

    @Test
    public void test() throws InterruptedException {
        long start = System.currentTimeMillis();
        for (int i = 0; i < QPS; i++) {
            System.out.println(i);
            new Thread(()->{
                latch.countDown();
                try {
                    latch.await();
                    System.out.println("start---------------");
                    new MutiSupplier().test();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    latchOver.countDown();
                }
            }).start();
        }
        latchOver.await();
        long end = System.currentTimeMillis();
        System.out.println("end---------------cost:"+(end - start));
    }



}
