package com.study.java.gof23.proxy.myDynamicProxy;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Proxy;

public class Client {
	public static void main(String[] args) throws IOException {
		RealStar realStar = new RealStar();
		StarHandler handler = new StarHandler(realStar);
		Star proxy = (Star)Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),  new Class[]{Star.class} , handler);
		proxy.sing();

		//获取字节码内容
		byte[] data = ProxyGenerator.generateProxyClass("$Proxy0",new Class[]{Star.class});
		FileOutputStream os = new FileOutputStream("D:/$Proxy0.class");
		os.write(data);
		os.close();
	}
}
