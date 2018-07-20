package com.study.java.io.charIO;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * Created by yan on  20/07/2018.
 */
public class StringTest {
    //���ַ����ж�д�ַ�����
    public static void main(String[] args){

        String src = "���Դ���";

        char[] buffer = new char[32];
        int hasRead = 0;

        try(
                StringReader sr = new StringReader(src);

        ){
            //����ѭ����ȡ�ķ�ʽ����ȡ�ַ���
            while((hasRead  = sr.read(buffer))> 0 ){
                //
                System.out.println(new String(buffer,0,hasRead));
            }
        }catch(IOException ioe){

            ioe.printStackTrace();
        }

        try(
                //
                StringWriter sw = new StringWriter();
        ){
            //���÷���ִ�����
            sw.write("��һ��������������\n");
            sw.write("��һ��������������\n");
            sw.write("��һ��������������\n");
            sw.write("��һ��������������\n");
            sw.write("��һ��������������\n");

            System.out.println(sw.toString());

        }catch(IOException ioe){

            ioe.printStackTrace();

        }
    }
}
