package com.study.java.algorithm.recursion;

public class CalNFact {
	public int f(int n){
		if(n == 1){
			return n;
		}else{
			return n*f(n-1);
		}
	}
	
	public static void main(String [] args){
		CalNFact calNFact = new CalNFact();
		int n = calNFact.f(15);
		System.out.println(15+"的阶乘为："+n);
	}
}
