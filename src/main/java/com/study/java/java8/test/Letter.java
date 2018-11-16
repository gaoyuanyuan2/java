package com.study.java.java8.test;

/**
 * Created by yan on  16/11/2018.
 */
public class Letter {

    public static String addHeader(String text){
        return "From Raoul, Mario and Alan: " + text;
    }
    public static String addFooter(String text){
        return text + " Kind regards";
    }
    public static String checkSpelling(String text){
        return text.replaceAll("labda", "lambda");
    }

}
