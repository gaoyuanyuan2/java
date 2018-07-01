package com.study.java.collections.guava;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ֻ������
 * @author Administrator
 *
 */
public class Demo01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> list =new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		//��ԭ�е�list���а�װ�������ԭ��List��һ����ͼ�����գ�������ȫ
		List<String> readList =Collections.unmodifiableList(list);
		//java.lang.UnsupportedOperationException
		//readList.add("d");
		list.add("d"); //�ı�ԭ��List ��ͼҲһ��ı�
		
		//�Ա� �鿴 ��ʼ��List guava��ֻ������ ��ȫ�ɿ���������Լ�
		List<String> immutableList =ImmutableList.of("a", "b", "c"); 
		immutableList.add("d");//java.lang.UnsupportedOperationException
		
	}

}
