package com.study.java.java8.test;

/**
 * Created by yan on  16/11/2018.
 */
public interface TriFunction <T, U, V, R>{
    R apply(T t, U u, V v);
}