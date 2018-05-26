package com.study.java.gof23.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class Singleton06 implements Serializable {
	private  static Singleton06 s ;
	private Singleton06(){
		//防止反射破解
		if(s != null){
			throw new RuntimeException();
		}
	}
	public static synchronized  Singleton06 getInstance(){
		if( s== null){
			s = new Singleton06();
		}
		return s;
	}
	
	//反序列化时，如果定义了readResolve()则直接返回此方法指定的对象。而不需要单独再创建新对象！
	private Object readResolve() throws ObjectStreamException {
		return s;
	}
}
