package com.study.java.collections.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yan on  03/01/2019.
 */
public class RemoveKeyValuePairHashMap {

    public static void main(String[] args) {
        // create two hashmap
        Map<String, Integer> courseMap = new HashMap<>();
        courseMap.put("Java", 1);
        courseMap.put("C", 2);
        courseMap.put("C++", 3);
        System.out.println("Before removal : using java 8 ");
        printMap(courseMap);
        // using java 8 removeIf method
        courseMap.entrySet().removeIf(e -> e.getKey().equals("Java"));
        System.out.println("After removal : using Java 8");
        printMap(courseMap);
    }

    private static void printMap(Map<String, Integer> courseMap) {
        for (String s : courseMap.keySet()) {
            System.out.println(s);
        }
    }
}
