package com.study.java.java8.stream.practice;


import com.study.java.java8.lambda.Employee;
import com.study.java.java8.lambda.Status;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class TestStreamAPI {

    /*
          1.	给定一个数字列表，如何返回一个由每个数的平方构成的列表呢？
        ，给定【1，2，3，4，5】， 应该返回【1，4，9，16，25】。
     */
    @Test
    public void test1() {
        Integer[] nums = new Integer[]{1, 2, 3, 4, 5};

        Arrays.stream(nums)
                .map((x) -> x * x)
                .forEach(System.out::println);
    }

    /*
     2.	怎样用 map 和 reduce 方法数一数流中有多少个Employee呢？
     */
    List<Employee> emps = Arrays.asList(
            new Employee(102, "李四", 59, 6666.66, Status.BUSY),
            new Employee(101, "张三", 18, 9999.99, Status.FREE),
            new Employee(103, "王五", 28, 3333.33, Status.VOCATION),
            new Employee(104, "赵六", 8, 7777.77, Status.BUSY),
            new Employee(104, "赵六", 8, 7777.77, Status.FREE),
            new Employee(104, "赵六", 8, 7777.77, Status.FREE),
            new Employee(105, "田七", 38, 5555.55, Status.BUSY)
    );

    @Test
    public void test2() {
        Optional<Integer> count = emps.stream()
                .map((e) -> 1)
                .reduce(Integer::sum);

        System.out.println(count.get());
    }

    @Test
    public void test3() {

        List<String> words = Arrays.asList("Hello", "World");
        List<String[]> res = words.stream()
                .map(word -> word.split(""))
                .distinct()
                .collect(toList());
        List<Stream<String>> res2 = words.stream()
                .map(word -> word.split(""))
                .map(Arrays::stream)
                .distinct()
                .collect(toList());
        // 使用flatMap方法的效果是，各个数组并不是分别映射成一个流，而是映射成流的内容。所有使用map(Arrays::stream)时生成的单个流都被合并起来，即扁平化为一个流
        List<String> uniqueCharacters =
                words.stream()
                        .map(w -> w.split(""))
                        .flatMap(Arrays::stream)
                        .distinct()
                        .collect(Collectors.toList());
        uniqueCharacters.forEach(e -> System.out.println(e));
    }
}
