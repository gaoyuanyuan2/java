package com.study.java.gof23.singleton;

public class Client {
	public static void main(String[] args) {
		System.out.println(Singleton01.getInstance()==Singleton01.getInstance());
		System.out.println(Singleton04.INSTANCE==Singleton04.INSTANCE);
	}
}
