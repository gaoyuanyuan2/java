package com.study.java.collections.pro;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * ʹ��Properties��ȡ�����ļ�
 * ��Դ�����ļ�:
 * ʹ����������·����ȡ
 * load(InputStream inStream) 
   load(Reader reader) 
   loadFromXML(InputStream in) 
 * @author Administrator
 *
 */
public class Demo03 {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties pro=new Properties();
		//��ȡ ����·��
		//pro.load(new FileReader("e:/others/db.properties"));
		//��ȡ ���·��
		pro.load(new FileReader("src/com/bjsxt/others/pro/db.properties"));
		System.out.println(pro.getProperty("user", "bjsxt"));
	}

}
