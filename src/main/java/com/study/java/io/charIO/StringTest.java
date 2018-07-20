package com.study.java.io.charIO;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * Created by yan on  20/07/2018.
 */
public class StringTest {
    //从字符串中读写字符序列
    public static void main(String[] args){

        String src = "测试代码";

        char[] buffer = new char[32];
        int hasRead = 0;

        try(
                StringReader sr = new StringReader(src);

        ){
            //采用循环读取的方式，读取字符串
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
            //调用方法执行输出
            sw.write("有一个美丽的新世界\n");
            sw.write("有一个美丽的新世界\n");
            sw.write("有一个美丽的新世界\n");
            sw.write("有一个美丽的新世界\n");
            sw.write("有一个美丽的新世界\n");

            System.out.println(sw.toString());

        }catch(IOException ioe){

            ioe.printStackTrace();

        }
    }
}
