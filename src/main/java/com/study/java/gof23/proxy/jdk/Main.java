package com.study.java.gof23.proxy.jdk;

/**
 * Created by xm on 2018/1/20.
 */
public class Main {

	public static void main(String[] args) throws Throwable {
		Man man = new Xiongmin();
		MyHandler myHandler = new MyHandler(man);
		Man proxyMan = (Man) MyProxy.newProxyInstance(new MyClassLoader("D:/study/idea/java/src/main/java/com" +
				"/study/java/gof23/proxy/jdk","com.study.java.gof23.proxy.jdk"), Man.class, myHandler);
		System.out.println(proxyMan.getClass().getName());
		proxyMan.say();
	}

}
