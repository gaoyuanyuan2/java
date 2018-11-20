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
 * 以质数为例，要是想创建一个包含所有质数的集合，那这个程序算起
 * 来就没完没了了，因为总有新的质数要算，然后把它加到集合里面。当然这个集合是永远也创建
 * 不完的，消费者这辈子都见不着了。
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

        //请注意，和迭代器类似，流只能遍历一次。遍历完之后，我们就说这个流已经被消费掉了。
        List<String> title = Arrays.asList("Java8", "In", "Action");
        Stream<String> s = title.stream();
        s.forEach(System.out::println);
//        s.forEach(System.out::println);  java.lang.IllegalStateException:流已被操作或关闭
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

    //流水线中最后一个操作count返回一个long，这是一个非Stream的值。因此它是一个终端操作。所有前面的操作，
    // filter、 distinct、 limit，都是连接起来的，并返回一个Stream，因此它们是中间操作。
    @Test
    public void test3() {
        long count = menu.stream()
                .filter(d -> d.getCalories() > 300)
                .distinct()
                .limit(3)
                .count();
        System.out.println(count);
    }


    //跳过元素
    @Test
    public void test4() {
        List<Dish> dishes = menu.stream()
                .filter(d -> d.getCalories() > 300)
                .skip(2)
                .collect(toList());
    }

    //映射 转换

    // flatmap方法让你把一个流中的每个值都换成另一个流，然后把所有的流连接起来成为一个流。

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
     * 短路求值
     *
     *对于流而言，某些操作（例如allMatch、anyMatch、noneMatch、findFirst和findAny）
     *不用处理整个流就能得到结果。只要找到一个元素，就可以有结果了。同样， limit也是一个
     *短路操作：它只需要创建一个给定大小的流，而用不着处理流中所有的元素。在碰到无限大小
     *的流的时候，这种操作就有用了：它们可以把无限流变成有限流
     */
    @Test
    public void test6(){
        //检查谓词是否至少匹配一个元素
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
     为什么会同时有findFirst和findAny呢？答案是并行。找到第一个元素
     在并行上限制更多。如果你不关心返回的元素是哪个，请使用findAny，因为它在使用并行流
     时限制较少。
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
     * 内部实现得以选择并行执行reduce操作
     *
     * 将输入分块，分块求和，最后再合并起来
     *
     * 传递给reduce的Lambda不能更改状态
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
