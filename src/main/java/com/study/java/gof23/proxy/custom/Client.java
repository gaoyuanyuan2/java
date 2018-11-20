package com.study.java.gof23.proxy.custom;

import com.study.java.gof23.proxy.myDynamicProxy.RealStar;
import com.study.java.gof23.proxy.myDynamicProxy.Star;
import com.study.java.gof23.proxy.myDynamicProxy.StarHandler;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Proxy;

public class Client {
	public static void main(String[] args) throws IOException {
		RealStar realStar = new RealStar();
		MyStarHandler handler = new MyStarHandler(realStar);
		Star proxy = (Star)MyProxy.newProxyInstance(new MyClassLoader(),  new Class[]{Star.class} ,
				handler);
		proxy.sing();
		//原理:

		// 1.拿到被代理对象的引用，然后获取它的接口

		// 2. JDK代理重新生成一个类,同时实现我们给的代理对象所实现的接口

		// 3.把被代理对象的引用也拿到了

		// 4.重新动态生成一个class字节码

		// 5.然后编译
	}
}
