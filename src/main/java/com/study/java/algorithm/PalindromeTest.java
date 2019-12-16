package com.study.java.algorithm;

//回文数

public class PalindromeTest {

    //将数字后半部分转置，若与前面一般相同，则是回文数。转置方法：将上一次得到的结果乘10，加上x%10，同时x/10，直到x小于reverseNum，则已经转置了一半了。

    public static boolean isPalindrome(long x) {
        //负数和以0结尾且非0的数显然不是回文数
        if(x<0||(x%10==0&&x!=0)) {
            return false;
        }
        long reverseNum=0;
        while(x>reverseNum) {
            reverseNum = reverseNum*10+x%10;
            x = x/10;
        }
        //如果x是奇数，直接x/10去掉中间那个数
        return x==reverseNum||x==reverseNum/10;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(12345654321l));
    }

}
