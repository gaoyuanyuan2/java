package com.study.java.collections.pro;

import java.io.IOException;
import java.util.Properties;

/**
 * ʹ�������·����ȡ�����ļ�
 *  bin  
 * @author Administrator
 *
 */
public class Demo04 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Properties pro =new Properties();
		//�����·���� / bin 
		//pro.load(Demo04.class.getResourceAsStream("/com/bjsxt/others/pro/db.properties"));
		//"" bin 
		pro.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("com/bjsxt/others/pro/db.properties"));
		System.out.println(pro.getProperty("user", "bjsxt"));
	}

}
