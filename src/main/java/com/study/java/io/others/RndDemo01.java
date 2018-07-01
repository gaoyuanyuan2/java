package com.study.java.io.others;

import com.study.java.io.util.FileUtil;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * �ļ��ķָ�˼·
 * 1���ָ�Ŀ��� size   n��
 * 2��ÿһ��Ĵ�С blockSize
 *   ���:�ܵ��ļ���С -(n-1)*blockSize
 * 
 * @author Administrator
 *
 */
public class RndDemo01 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		RandomAccessFile rnd =new RandomAccessFile(new File("E:/xp/20130502/test/test.java"),"r");
		rnd.seek(40);
		//���建���С
		byte[] flush =new byte[1024];
		//���ճ���
		int len =0; 		
		
		while(-1!=(len=rnd.read(flush))){
			if(len>=20){
				System.out.println(new String(flush,0,20));
				break;
			}else{
				System.out.println(new String(flush,0,len));
			}
			
		}
		
		
		FileUtil.close(rnd);
		
	}

}
