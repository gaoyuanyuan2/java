package com.study.java.io.charIO;

import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.IOException;

/**
 * Created by yan on  20/07/2018.
 * ���ַ������ж�д����
 */
public class CharArray {
    public static void testReader() throws IOException {
        String str = "Hello world!";

        // �����ַ�������
        CharArrayReader reader = new CharArrayReader(str.toCharArray());

        // ���ַ���������ȡ�ַ�
        char[] chars = new char[1024];
        int len = reader.read(chars);
        System.out.println(new String(chars, 0, len));
    }

    public static void testWriter() throws IOException {

        CharArrayWriter writer = new CharArrayWriter(1024 * 1024);
        // ���ַ���д�뵽CharArrayWriter
        String msg = "hello world������22121";
        writer.write(msg.toCharArray());

        System.out.println(writer.toString());

        writer.close();
    }

    public static void main(String[] args) throws IOException {
        testReader();
        testWriter();
    }
}
