package com.study.java.collections.collection;

import com.study.java.collection.SxtEntry;

import java.util.LinkedList;

/**
 * 自定义Map的升级版：
 * 1. 提高查询的效率
 *
 *
 */
public class SxtMap002 {

	LinkedList[]  arr  = new LinkedList[9]; //Map的底层结构就是：数组+链表!
	int size;
	
	public void put(Object key,Object value){
		com.study.java.collection.SxtEntry e = new com.study.java.collection.SxtEntry(key,value);

		int a = key.hashCode()%arr.length;
		if(arr[a]==null){
			LinkedList list = new LinkedList();
			arr[a] = list;
			list.add(e);
		}else{
			LinkedList list = arr[a];
			for(int i=0;i<list.size();i++){
				com.study.java.collection.SxtEntry e2 = (com.study.java.collection.SxtEntry) list.get(i);
				if(e2.key.equals(key)){
					e2.value = value;  //键值重复直接覆盖！
					return;
				}
			}

			arr[a].add(e);
		}
		//a:1000-->1   b:10000-->13
	}

	public Object get(Object key){
		int a = key.hashCode()%arr.length;
		if(arr[a]!=null){
			LinkedList list = arr[a];
			for(int i=0;i<list.size();i++){
				com.study.java.collection.SxtEntry e = (com.study.java.collection.SxtEntry) list.get(i);
				if(e.key.equals(key)){
					return e.value;
				}
			}
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		com.study.java.collection.SxtMap002 m = new com.study.java.collection.SxtMap002();
		m.put("高琪", new com.study.java.collection.Wife("杨幂"));
		m.put("高琪", new com.study.java.collection.Wife("李四"));
		com.study.java.collection.Wife w = (com.study.java.collection.Wife) m.get("高琪");
		System.out.println(w.name); 
	}

}

class Wife {
	String name;
	public Wife(String name){
		this.name  = name;
	}
}
