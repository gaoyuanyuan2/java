package com.study.java.gof23.proxy.myDynamicProxy;

import java.lang.reflect.Proxy;

public class Client {
	public static void main(String[] args) {
		RealStar realStar = new RealStar();
		StarHandler handler = new StarHandler(realStar);
		Star proxy = (Star)Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),  new Class[]{Star.class} , handler);
		proxy.sing();
	}
}
