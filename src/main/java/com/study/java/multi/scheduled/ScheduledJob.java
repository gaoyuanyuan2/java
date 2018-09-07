package com.study.java.multi.scheduled;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

class Temp extends Thread {
    public void run() {
        System.out.println("run");
    }
}

public class ScheduledJob {

    public static void main(String args[]) throws Exception {

        Temp command = new Temp();
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        ScheduledFuture<?> scheduleTask = scheduler.scheduleWithFixedDelay(command, 5, 1, TimeUnit.SECONDS);

        scheduler.schedule(() -> System.out.println("延时执行"), 1000 * 60 * 10, TimeUnit.MILLISECONDS);


        //定时器线程池
        Executors.newScheduledThreadPool(3).
                scheduleAtFixedRate(
                        () -> System.out.println("bombing!"),
                        6,
                        2,
                        TimeUnit.SECONDS);
    }

}