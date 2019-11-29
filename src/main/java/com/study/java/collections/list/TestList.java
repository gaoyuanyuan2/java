package com.study.java.collections.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class TestList {
    public static void main(String[] args) {
        test();
    }
    public static void test(){
        // 应该注意的是 asList() 的参数为泛型的变长参数，不能使用基本类型数组作为参数，只能使用相应的包装类型数组。
        Integer[] arr = {1, 2, 3};
        List list = Arrays.asList(arr);
        System.out.println(list.toString());
    }
    public static void test2(){

        //可以使用 Collections.synchronizedList(); 得到一个线程安全的 ArrayList。
        List<String> list = new ArrayList<>();
        List<String> synList = Collections.synchronizedList(list);

        //也可以使用 concurrent 并发包下的 CopyOnWriteArrayList 类。
        List<String> list2 = new CopyOnWriteArrayList<>();

        /**
         CopyOnWriteArrayList 在写操作的同时允许读操作，大大提高了读操作的性能，因此很适合读多写少的应用场景。
         但是 CopyOnWriteArrayList 有其缺陷：

        内存占用：在写操作时需要复制一个新的数组，使得内存占用为原来的两倍左右；
        数据不一致：读操作不能读取实时性的数据，因为部分写操作的数据还未同步到读数组中。
        所以 CopyOnWriteArrayList 不适合内存敏感以及对实时性要求很高的场景。
        **/
    }
}
