package com.study.java.java8.test;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Created by yan on  16/11/2018.
 * <p>
 * ������Ϊ����Ҫ���봴��һ���������������ļ��ϣ��������������
 * ����û��û���ˣ���Ϊ�����µ�����Ҫ�㣬Ȼ������ӵ��������档��Ȼ�����������ԶҲ����
 * ����ģ��������Ⱳ�Ӷ��������ˡ�
 */
public class StreamTest {

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

    @Test
    public void test1() {


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

    @Test
    public void test2() {
        List<String> names =
                menu.stream()
                        .filter(d -> {
                            System.out.println("filtering" + d.getName());
                            return d.getCalories() > 300;
                        })
                        .map(d -> {
                            System.out.println("mapping" + d.getName());
                            return d.getName();
                        })
                        .limit(3)
                        .collect(toList());
        System.out.println(names);
    }

    //��ˮ�������һ������count����һ��long������һ����Stream��ֵ���������һ���ն˲���������ǰ��Ĳ�����
    // filter�� distinct�� limit���������������ģ�������һ��Stream������������м������
    @Test
    public void test3() {
        long count = menu.stream()
                .filter(d -> d.getCalories() > 300)
                .distinct()
                .limit(3)
                .count();
        System.out.println(count);
    }


    //����Ԫ��
    @Test
    public void test4() {
        List<Dish> dishes = menu.stream()
                .filter(d -> d.getCalories() > 300)
                .skip(2)
                .collect(toList());
    }

    //ӳ�� ת��

    // flatmap���������һ�����е�ÿ��ֵ��������һ������Ȼ������е�������������Ϊһ������

    @Test
    public void test5() {

        List<String> words = Arrays.asList("Java 8", "Lambdas", "In", "Action");
        List<Integer> wordLengths = words.stream()
                .map(String::length)
                .collect(toList());
        System.out.println(wordLengths);

        List<Integer> dishNameLengths = menu.stream()
                .map(Dish::getName)
                .map(String::length)
                .collect(toList());
        System.out.println(dishNameLengths);

        List<String> names = menu.stream()
                .map(Dish::getName)
                .distinct()
                .collect( Collectors.toList());
        System.out.println(names);

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> squares =
                numbers.stream()
                        .map(n -> n * n)
                        .collect(toList());
        System.out.println(squares);

        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);
        List<int[]> pairs =
                numbers1.stream()
                        .flatMap(i -> numbers2.stream()
                                .map(j -> new int[]{i, j})
                        )
                        .collect(toList());

    }

    /**
     * ��·��ֵ
     *
     *���������ԣ�ĳЩ����������allMatch��anyMatch��noneMatch��findFirst��findAny��
     *���ô������������ܵõ������ֻҪ�ҵ�һ��Ԫ�أ��Ϳ����н���ˡ�ͬ���� limitҲ��һ��
     *��·��������ֻ��Ҫ����һ��������С���������ò��Ŵ����������е�Ԫ�ء����������޴�С
     *������ʱ�����ֲ����������ˣ����ǿ��԰����������������
     */
    @Test
    public void test6(){
        //���ν���Ƿ�����ƥ��һ��Ԫ��
        if(menu.stream().anyMatch(Dish::isVegetarian)){
            System.out.println("The menu is (somewhat) vegetarian friendly!!");
        }

        boolean isHealthy = menu.stream()
                .allMatch(d -> d.getCalories() < 1000);
        System.out.println(isHealthy);

        boolean isHealthy2 = menu.stream()
                .noneMatch(d -> d.getCalories() >= 1000);
        System.out.println(isHealthy2);
    }

    /**
     Ϊʲô��ͬʱ��findFirst��findAny�أ����ǲ��С��ҵ���һ��Ԫ��
     �ڲ��������Ƹ��ࡣ����㲻���ķ��ص�Ԫ�����ĸ�����ʹ��findAny����Ϊ����ʹ�ò�����
     ʱ���ƽ��١�
     */
    @Test
    public void test7(){
        Optional<Dish> dish =
                menu.stream()
                        .filter(Dish::isVegetarian)
                        .findAny();
        System.out.println(dish.get());

        menu.stream()
                .filter(Dish::isVegetarian)
                .findAny()
                .ifPresent(d -> System.out.println(d.getName()));

        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> firstSquareDivisibleByThree =
                someNumbers.stream()
                        .map(x -> x * x)
                        .filter(x -> x % 3 == 0)
                        .findFirst();
        System.out.println(firstSquareDivisibleByThree.get());

    }

    /**
     * �ڲ�ʵ�ֵ���ѡ����ִ��reduce����
     *
     * ������ֿ飬�ֿ���ͣ�����ٺϲ�����
     *
     * ���ݸ�reduce��Lambda���ܸ���״̬
     */

    @Test
    public void test8(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> sum = numbers.stream().reduce((a, b) -> (a + b));
        System.out.println(sum);

        Optional<Integer> max = numbers.stream().reduce(Integer::max);
        System.out.println(max);

        Optional<Integer> min = numbers.stream().reduce(Integer::min);
        System.out.println(min);

        int count = menu.stream()
                .map(d -> 1)
                .reduce(0, (a, b) -> a + b);
        System.out.println(count);

    }
}
