package com.study.java.sort.col;

import java.util.TreeSet;

/**
 * 实体类实现Comparable 接口的应用
 * @author Administrator
 *
 */
public class TreeSetDemo2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Worker w1 =new Worker("垃圾回收员",12000);
		Worker w2 =new Worker("农民工",8000);
		Worker w3 =new Worker("程序猿",5000);
		
		TreeSet<Worker> employees =new TreeSet<Worker>();
		employees.add(w1);
		employees.add(w2);
		employees.add(w3);
		System.out.println(employees);
		
	}

}
