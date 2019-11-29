package com.study.java.multi.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizedTest {
    public static void main(String[] args) {
        //作用于整个类，也就是说两个线程调用同一个类的不同对象上的这种同步语句，也会进行同步。
        SynchronizedExample e1 = new SynchronizedExample();
        SynchronizedExample e2 = new SynchronizedExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> e1.func2());
        executorService.execute(() -> e2.func2());
    }
}

class SynchronizedExample{
    public void func2() {
        synchronized (SynchronizedExample.class) {
            for (int i = 0; i < 10; i++) {
                System.out.print(i + " ");
            }
        }
    }
}
