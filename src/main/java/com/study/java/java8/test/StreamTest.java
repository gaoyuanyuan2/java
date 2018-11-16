package com.study.java.java8.test;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Created by yan on  16/11/2018.
 *
 * ������Ϊ����Ҫ���봴��һ���������������ļ��ϣ��������������
 * ����û��û���ˣ���Ϊ�����µ�����Ҫ�㣬Ȼ������ӵ��������档��Ȼ�����������ԶҲ����
 * ����ģ��������Ⱳ�Ӷ��������ˡ�
 */
public class StreamTest {

    @Test
    public void test1() {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));

        List<String> threeHighCaloricDishNames =
                menu.stream()
                        .filter(d -> d.getCalories() > 300)
                        .map(Dish::getName)
                        .limit(3)
                        .collect(toList());
        System.out.println(threeHighCaloricDishNames);

        //��ע�⣬�͵��������ƣ���ֻ�ܱ���һ�Ρ�������֮�����Ǿ�˵������Ѿ������ѵ��ˡ�
        List<String> title = Arrays.asList("Java8", "In", "Action");
        Stream<String> s = title.stream();
        s.forEach(System.out::println);
//        s.forEach(System.out::println);  java.lang.IllegalStateException:���ѱ�������ر�
    }
}
