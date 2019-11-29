package com.study.java.base;

import com.google.common.collect.Lists;

import java.util.List;

public class TestT {
    public static void main(String[] args) {
        List<Object> objectList = Lists.newArrayList();
        objectList.add(1);
        objectList.add(new Object());
    }
}
