package com.study.java.gof23.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

public class Client2 {
	public static void main(String[] args) throws Exception {
		Singleton06 s1 = Singleton06.getInstance();
		Singleton06 s2 = Singleton06.getInstance();
		System.out.println(s1);
		System.out.println(s2);
		
		//反射破解
	/*	Class<Singleton06> clazz = (Class<Singleton06>)Class.forName("singleton.Singleton06");
		Constructor<Singleton06> cons = clazz.getDeclaredConstructor(null);
		//不检查
		cons.setAccessible(true);
		Singleton06 s3=cons.newInstance();
		Singleton06 s4 =cons.newInstance();
		System.out.println(s3==s4);*/
		
		//序列化破解
		FileOutputStream fos = new FileOutputStream("d:/a.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(s1);
		oos.close();
		fos.close();
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d:/a.txt"));
		Singleton06 s3 =  (Singleton06) ois.readObject();
		System.out.println(s3);
	}
}
