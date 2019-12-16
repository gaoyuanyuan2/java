package com.study.java.oom;

import java.util.ArrayList;
import java.util.List;

/**
 在 Java 堆中只要不断的创建对象，并且 GC-Roots 到对象之间存在引用链，这样 JVM 就不会回收对象。

 只要将-Xms(最小堆),-Xmx(最大堆) 设置为一样禁止自动扩展堆内存。

 当使用一个 while(true) 循环来不断创建对象就会发生 OutOfMemory，还可以使用 -XX:+HeapDumpOnOutOfMemoryError 当发生 OOM 时会自动 dump 堆栈到文件中。


 * **/
public class OutOfMemoryErrorTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(10) ;
        while (true){
            list.add("1") ;
        }
    }
}

//java.lang.OutOfMemoryError: Java heap space表示堆内存溢出。
