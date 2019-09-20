package com.study.java.multi.pool.pool2;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class MyRejected implements RejectedExecutionHandler {

	@Override
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
		System.out.println("my");
		
		System.out.println(r.toString());
		System.out.println(executor.getQueue().size());
		
	}

}
