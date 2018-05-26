package com.study.java.gof23.singleton;

//静态内部内
public class Singleton03 {
	private  static class InnerSingleton{
		private   static final  Singleton03  s = new Singleton03();
	}
	private Singleton03(){}
	public  static Singleton03 getInstance(){
		return InnerSingleton.s;
	}
}
