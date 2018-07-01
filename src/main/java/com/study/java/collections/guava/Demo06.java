package com.study.java.collections.guava;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import java.util.*;

/**
 * �����鿴 ��ʦ  ���ڵ�ÿ�ſγ�
 * Multimap :key-value  key�����ظ�
 * 
 * 
 * @author Administrator
 *
 */
public class Demo06 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Map<String,String> cours =new HashMap<String,String>();
		//�����������
		cours.put("�ĸ￪��", "��үү");
		cours.put("��������", "����ϯ");
		cours.put("��ѧ��չ��", "����ϯ");
		cours.put("��г���", "����ϯ");
		cours.put("���ٰ˳�", "����ϯ");
		cours.put("....", "ϰ��ϯ");
		
		//Multimap
		Multimap<String,String> teachers =ArrayListMultimap.create();
		
		//������
		Iterator<Map.Entry<String,String>> it =cours.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<String,String> entry =it.next();
			String key =entry.getKey(); //�γ�
			String value =entry.getValue(); //��ʦ
			
			//��ʦ -->�γ�
			teachers.put(value, key);
		}
		
		
		//�鿴Multimap
		Set<String> keyset =teachers.keySet();
		for(String key:keyset){
			Collection<String> col =teachers.get(key);
			System.out.println(key+"-->"+col);
		}
		
		
		
	}

}
