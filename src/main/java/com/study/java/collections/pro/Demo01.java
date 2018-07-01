package com.study.java.collections.pro;

import java.util.Properties;

/**
 * Properties ��Դ�����ļ��Ķ�д
 * 1��key ��value ֻ��Ϊ�ַ���
 * 2���洢���ȡ
 * setProperty(String key, String value) 
 * getProperty(String key, String defaultValue)  
 * @author Administrator
 *
 */
public class Demo01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//��������
		Properties pro =new Properties();
		//�洢
		pro.setProperty("driver", "oracle.jdbc.driver.OracleDriver");
		//pro.setProperty("url", "jdbc:oracle:thin:@localhost:1521:orcl");
		pro.setProperty("user", "scott");
		pro.setProperty("pwd", "tiger");
		
		//��ȡ
		String url =pro.getProperty("url","test");
		System.out.println(url);
	}

}
