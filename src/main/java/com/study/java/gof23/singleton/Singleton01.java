package com.study.java.gof23.singleton;

//懒汉
public class Singleton01 {
	private static Singleton01 s = new Singleton01();
	private Singleton01(){}
	public static Singleton01 getInstance(){
		return s;
	}
}
