package com.study.java.io.charIO;

import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.IOException;

/**
 * Created by yan on  20/07/2018.
 * 从字符数组中读写数据
 */
public class CharArray {
    public static void testReader() throws IOException {
        String str = "Hello world!";

        // 构建字符输入流
        CharArrayReader reader = new CharArrayReader(str.toCharArray());

        // 从字符输入流读取字符
        char[] chars = new char[1024];
        int len = reader.read(chars);
        System.out.println(new String(chars, 0, len));
    }

    public static void testWriter() throws IOException {

        CharArrayWriter writer = new CharArrayWriter(1024 * 1024);
        // 将字符串写入到CharArrayWriter
        String msg = "hello world！！！22121";
        writer.write(msg.toCharArray());

        System.out.println(writer.toString());

        writer.close();
    }

    public static void main(String[] args) throws IOException {
        testReader();
        testWriter();
    }
}
