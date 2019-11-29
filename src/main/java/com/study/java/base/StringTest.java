package com.study.java.base;

public class StringTest {
    public static void main(String[] args) {

        // 使用 String 的 intern() 方法在运行过程中将字符串添加到 String Pool 中。
        String s1 = new String("aaa");
        String s2 = new String("aaa");
        System.out.println(s1 == s2);           // false
        String s3 = s1.intern();
        String s4 = s2.intern();
        System.out.println(s3 == s4);    // true
    }
}
