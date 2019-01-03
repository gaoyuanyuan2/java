package com.study.java.collections.collection;

import java.util.IdentityHashMap;

/**
 * Created by yan on  03/01/2019.
 */
public class IdentityHashMapExample {
    //这个类不是通用的Map实现！虽然这个类实现了Map接口，但它故意违反了Map的一般契约
    public static void main(final String[] args) {
        final IdentityHashMap<String, String> identityHashMap = new IdentityHashMap<>();
        identityHashMap.put("a", "Java");
        identityHashMap.put(new String("a"), "J2EE");
        identityHashMap.put("b", "J2SE");
        identityHashMap.put(new String("b"), "Spring");
        identityHashMap.put("c", "Hibernate");
        for (final String str : identityHashMap.keySet()) {
            System.out.println("Key : " + str + " and Value : " + identityHashMap.get(str));
        }
        System.out.println("Size of map is : " + identityHashMap.size());
        System.out.println("Here 'a' and new String('a') are considered as separate keys");
    }
}
