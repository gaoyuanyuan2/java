package com.study.java.gof23.singleton;

//饿汉
public class Singleton02 {
	private  static Singleton02 s ;
	private Singleton02(){}
	public synchronized static Singleton02 getInstance(){
		if( s== null){
			s = new Singleton02();
		}
		return s;
	}
}
