package com.study.java.oop;

public class other {
    public static void main(String[] args) {
        String a = new String("a");//两个对象，a指向常量池"a"

        //底层是char[]数组，方法链
        StringBuilder sb = new StringBuilder();   //字符数组长度初始为16
        StringBuilder sb1 = new StringBuilder(32);   //字符数组长度初始为32
        StringBuilder sb2 = new StringBuilder("abcd");   //字符数组长度初始为32, value[]={'a','b','c','d',\u0000,\u0000...}
        sb2.append("efg");
        sb2.append(true).append(321).append("随便");   //通过return this实现方法链.
    }
}
