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
		//ԭ��:

		// 1.�õ��������������ã�Ȼ���ȡ���Ľӿ�

		// 2. JDK������������һ����,ͬʱʵ�����Ǹ��Ĵ��������ʵ�ֵĽӿ�

		// 3.�ѱ�������������Ҳ�õ���

		// 4.���¶�̬����һ��class�ֽ���

		// 5.Ȼ�����
	}
}
