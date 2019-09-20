package com.study.java.multi.pool.pool1;

import java.net.HttpURLConnection;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class MyRejected implements RejectedExecutionHandler {

	
	public MyRejected(){
	}
	
	@Override
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
		System.out.println("My..");
		System.out.println("refuse:" + r.toString());
		

	}

}
