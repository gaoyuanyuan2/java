package com.study.java.collections.guava;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * ����ʽ��� :����
 * 1��Predicate 
 * 2��Function
 * 
 * ����:Collections2.filter() ������
 * Collections2.transfer() ת��
 * Functions.compose()���ʽ�������
 * @author Administrator
 *
 */
public class Demo02 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//���ʽ�������
		//ȷ�������е��ַ������Ȳ�����5���������н�ȡ����ȫ����д
		List<String> list =Lists.newArrayList("bjsxt","good","happiness");
		//ȷ�������е��ַ������Ȳ�����5���������н�ȡ
		Function<String,String> f1 =new Function<String,String>(){

			@Override
			public String apply(String input) {
				return input.length()>5?input.substring(0,5):input;
			}
			
		};
		//ת�ɴ�д
		Function<String,String> f2 =new Function<String,String>(){

			@Override
			public String apply(String input) {
				return input.toUpperCase();
			}
			
		};
		
		//String =f2(f1(String))
		Function<String,String> f =Functions.compose(f1, f2);
		Collection<String> resultCol =Collections2.transform(list, f);
		
		for(String temp:resultCol){
			System.out.println(temp);
		}
		
		
	}
	/**
	 * ת��
	 */
	public static void test2(){
		//����ת��
		Set<Long> timeSet =Sets.newHashSet();
		timeSet.add(10000000L);
		timeSet.add(99999999999999999L);
		timeSet.add(2000000000L);
		
		Collection<String> timeStrCol =Collections2.transform(timeSet, new Function<Long,String>(){

			@Override
			public String apply(Long input) {
				return new SimpleDateFormat("yyyy-MM-dd").format(input);
			}});
	
		for(String temp:timeStrCol){
			System.out.println(temp);
		}

	}
	/**
	 * ������
	 */
	public static void test1(){
		//����List ��̬��ʼ��
		List<String> list =Lists.newArrayList("moom","son","dad","bjsxt","refer");
		//�ҳ����� palindrome  backwords  mirror words
		//�����ڲ������: �����ڲ��࣬ͬʱ���������
		Collection<String> palindromeList =Collections2.filter(list, new Predicate<String>(){
	
			@Override
			public boolean apply(String input) {
				//ҵ���߼�
				return new StringBuilder(input).reverse().toString().equals(input);
			}
			
		});
		
		for(String temp:palindromeList){
			System.out.println(temp);
		}
	}
	
}
