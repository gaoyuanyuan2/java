package com.study.java.collections.collection;

import com.study.java.collection.Wife;

/**
 *�Զ���ʵ��Map�Ĺ��ܣ�
 *�ݲ������� 
 *Map:��ż�ֵ�ԣ����ݼ������Ҷ�Ӧ��ֵ����.�������ظ���
 *
 */
public class SxtMap001 {
	
	com.study.java.collection.SxtEntry[]  arr  = new com.study.java.collection.SxtEntry[990];
	int size;
	
	public void put(Object key,Object value){
		com.study.java.collection.SxtEntry e = new com.study.java.collection.SxtEntry(key,value);
		//�����ֵ�ظ��Ĵ���
		for(int i=0;i<size;i++){
			if(arr[i].key.equals(key)){
				arr[i].value=value;
				return ;
			}
		}
		
		arr[size++] = e;
	}
	
	public Object get(Object key){
		for(int i=0;i<size;i++){
			if(arr[i].key.equals(key)){
				return arr[i].value;
			}
		}
		return null;
	}
	
	public boolean containsKey(Object key){
		for(int i=0;i<size;i++){
			if(arr[i].key.equals(key)){
				return true;
			}
		}
		return false;
	}
	
	public boolean containsValue(Object value){
		for(int i=0;i<size;i++){
			if(arr[i].value.equals(value)){
				return true;
			}
		}
		return false;
	}
	
	
	
	public static void main(String[] args) {
		com.study.java.collection.SxtMap001 m = new com.study.java.collection.SxtMap001();
		m.put("����", new Wife("����"));
		m.put("����", new Wife("����"));
		Wife w = (Wife) m.get("����");
		System.out.println(w.name); 
	}

}

class  SxtEntry {
	Object key;
	Object value;
	
	public SxtEntry(Object key, Object value) {
		super();
		this.key = key;
		this.value = value;
	}	
}