package com.study.java.multi.volatiles;

public class RunThread extends Thread{

	private volatile boolean isRunning = true;
	private void setRunning(boolean isRunning){
		this.isRunning = isRunning;
	}
	
	public void run(){
		System.out.println("into..");
		int i = 0;
		while(isRunning == true){
			//..
			System.out.println("1");
		}
		System.out.println("stop");
	}
	
	public static void main(String[] args) throws InterruptedException {
		RunThread rt = new RunThread();
		rt.start();
		Thread.sleep(1000);
		rt.setRunning(false);
		System.out.println("isRunning set false");
		Thread.sleep(100000);
	}
	
	
}
