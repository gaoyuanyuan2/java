package com.study.java.java8.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.Comparator.comparing;

/**
 * Created by yan on  16/11/2018.
 * <p>
 * 函数式接口： Predicate<T>、 Consumer<T>和Function<T,R>
 */
/*@FunctionalInterface
public interface Function<T, R> {
    R apply(T t);
}*/

public class TestFunction {

    private int i = 1;

    public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<>();
        for (T s : list) {
            result.add(f.apply(s));
        }
        return result;
    }

    public static void main(String[] args) {
        // [7, 2, 6]
        List<Integer> l = map(
                Arrays.asList("lambdas", "in", "action"),
                (String s) -> s.length()
        );
        l.stream().forEach(System.out::println);
    }

    //Lambda可以没有限
    //制地捕获（也就是在其主体中引用）实例变量和静态变量。但局部变量必须显式声明为final，
    //或事实上是final。

    /**
     * 第一，实例变量和局部变量背后的实现有一
     * 个关键不同。实例变量都存储在堆中，而局部变量则保存在栈上。如果Lambda可以直接访问局
     * 部变量，而且Lambda是在一个线程中使用的，则使用Lambda的线程，可能会在分配该变量的线
     * 程将这个变量收回之后，去访问该变量。因此， Java在访问自由局部变量时，实际上是在访问它
     * 的副本，而不是访问原始变量。如果局部变量仅仅赋值一次那就没有什么区别了——因此就有了
     * 这个限制。
     * 第二，这一限制不鼓励你使用改变外部变量的典型命令式编程模式（我们会在以后的各章中
     * 解释，这种模式会阻碍很容易做到的并行处理）
     */
    @Test
    public void test() {
        final int portNumber = 1337;
        Runnable r = () -> {
            System.out.println(portNumber);
            System.out.println(i);
        };
        r.run();
//        portNumber = 31337;
    }

    public void test2() {

        List<Apple> inventory = Arrays.asList(new Apple());

        inventory.sort((Apple a1, Apple a2)
                -> a1.getWeight().compareTo(a2.getWeight()));

        //方法引用和java.util.Comparator.comparing
        //方法引用可以被看作仅仅调用特定方法的Lambda的一种快捷写法
        inventory.sort(comparing(Apple::getWeight));

        //递减排序
        inventory.sort(comparing(Apple::getWeight).reversed());
        //比较器链
        inventory.sort(comparing(Apple::getWeight).reversed().thenComparing(Apple::getCountry));



        Predicate<Apple> redApple = Apple::isRed;

        //谓词接口包括三个方法： negate(非)、 and和or
        Predicate<Apple> notRedApple = redApple.negate();

        Predicate<Apple> redAndHeavyAppleOrGreen =
                redApple.and(a -> a.getWeight() > 150)
                        .or(a -> "green".equals(a.getColor()));

        List<String> str = Arrays.asList("a", "b", "A", "B");
        str.sort((s1, s2) -> s1.compareToIgnoreCase(s2));

        str.sort(String::compareToIgnoreCase);

    }

    @Test
    public void test3(){
        //现在你可以像下面这样使用构造函数引用了：
        TriFunction<Integer, Integer, Integer, Apple> colorFactory = Apple::new;
        System.out.println(colorFactory);
    }

    //函数复合
    @Test
    public void test4(){
        //给数字加1，再给结果乘2    :4
        Function<Integer, Integer> f = x -> x + 1;
        Function<Integer, Integer> g = x -> x * 2;
        Function<Integer, Integer> h = f.andThen(g);
        int result1 = h.apply(1);
        System.out.println(result1);

        //给数字乘2，再给结果加1   :3
        Function<Integer, Integer> h2 = f.compose(g);
        int result2 = h2.apply(1);
        System.out.println(result2);

        //andThen的转换流水线
        //先加上抬头，然后进行拼写检查，最后加上一个落款
        Function<String, String> addHeader = Letter::addHeader;
        Function<String, String> transformationPipeline
                = addHeader.andThen(Letter::checkSpelling)
                .andThen(Letter::addFooter);
        System.out.println(transformationPipeline.apply("Hi"));


        //第二个流水线可能只加抬头、落款，而不做拼写检查
        Function<String, String> addHeader2 = Letter::addHeader;
        Function<String, String> transformationPipeline2
                = addHeader2.andThen(Letter::addFooter);
        System.out.println(transformationPipeline2.apply("Hello"));
    }


}