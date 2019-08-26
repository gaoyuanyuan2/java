package com.study.java.multi.future;

public class Main {
    //场景netty： channel。并行等待结果，处理结果。
	public static void main(String[] args) throws InterruptedException {

		FutureClient fc = new FutureClient();
		Data data = fc.request("request");
		System.out.println("success!");
		System.out.println("do other...");
		
		String result = data.getRequest();
		System.out.println(result);
		
	}
}
