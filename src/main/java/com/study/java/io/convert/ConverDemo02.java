package com.study.java.io.convert;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 转换流: 字节转为字符
 * 1、输出流 OutputStreamWriter 编码
 * 2、输入流 InputStreamReader  解码
 * 
 * 确保源不能为乱码
 * @author Administrator
 *
 */
public class ConverDemo02 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		//指定解码字符集
		BufferedReader br =new BufferedReader(
				new InputStreamReader(//字节到字符的桥梁
						new BufferedInputStream(
							new FileInputStream( 
									new File("E:/xp/test/Demo03.java"))),"UTF-8")
				);
		//写出文件 编码
		BufferedWriter bw =new BufferedWriter(
				new OutputStreamWriter(//字符到字节的桥梁
					new BufferedOutputStream(	
					new FileOutputStream(new File("E:/xp/test/encode.java")))));
				
		String info =null;
		while(null!=(info=br.readLine())){
			//System.out.println(info);
			bw.write(info);
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
