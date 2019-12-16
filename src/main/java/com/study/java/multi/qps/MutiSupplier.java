package com.study.java.multi.qps;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class MutiSupplier {

//    private final ThreadPoolExecutor threadExecutor = new ThreadPoolExecutor(15, 500, 60L, TimeUnit.MILLISECONDS, new
//            ArrayBlockingQueue<Runnable>(1));

        private final  ThreadPoolExecutor threadExecutor =  new ThreadPoolExecutor(5, 20,
                                   0L,TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(2000),
            new ThreadFactoryBuilder().setNameFormat("用车请求Link线程池").setDaemon(true).build(), new ThreadPoolExecutor
 .AbortPolicy());
    private CountDownLatch latch = new CountDownLatch(5);

    private static final int SUPPLIER_COUNT = 5;

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    private AtomicInteger atomicIntegerStart = new AtomicInteger(0);

    public void test() throws InterruptedException {
        long start = System.currentTimeMillis();
        for (int j = 0; j < SUPPLIER_COUNT; j++) {
            threadExecutor.submit(new RunTest());
        }
        latch.await(10, TimeUnit.SECONDS);
        long end = System.currentTimeMillis();
        System.err.println(" cost:" + (end - start));
    }

    public class RunTest implements Runnable {

        @Override
        public void run() {
            try {
                long sleepTime = (long) (Math.random() * 10000);
                System.out.println("sleep start:" + atomicIntegerStart.addAndGet(1) + "-" + sleepTime);
                TimeUnit.MILLISECONDS.sleep(sleepTime);
                System.out.println("sleep end:" + atomicInteger.addAndGet(1) + "-" + sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                latch.countDown();
            }
        }
    }


}
