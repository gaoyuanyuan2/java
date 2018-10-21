package com.study.java.multi.pool.pool3;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by yan on  24/08/2018.
 */
public class PoolTest {
    public static void main(String[] args){
        ThreadPoolExecutor pool = new ThreadPoolExecutor(20, 20, 1000 * 60 * 3, TimeUnit
                .MILLISECONDS, new ArrayBlockingQueue<>(1000), new ThreadPoolExecutor.AbortPolicy());

    }
}
