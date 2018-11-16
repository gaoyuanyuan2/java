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
 * ����ʽ�ӿڣ� Predicate<T>�� Consumer<T>��Function<T,R>
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

    //Lambda����û����
    //�Ƶز���Ҳ�����������������ã�ʵ�������;�̬���������ֲ�����������ʽ����Ϊfinal��
    //����ʵ����final��

    /**
     * ��һ��ʵ�������;ֲ����������ʵ����һ
     * ���ؼ���ͬ��ʵ���������洢�ڶ��У����ֲ������򱣴���ջ�ϡ����Lambda����ֱ�ӷ��ʾ�
     * ������������Lambda����һ���߳���ʹ�õģ���ʹ��Lambda���̣߳����ܻ��ڷ���ñ�������
     * �̽���������ջ�֮��ȥ���ʸñ�������ˣ� Java�ڷ������ɾֲ�����ʱ��ʵ�������ڷ�����
     * �ĸ����������Ƿ���ԭʼ����������ֲ�����������ֵһ���Ǿ�û��ʲô�����ˡ�����˾�����
     * ������ơ�
     * �ڶ�����һ���Ʋ�������ʹ�øı��ⲿ�����ĵ�������ʽ���ģʽ�����ǻ����Ժ�ĸ�����
     * ���ͣ�����ģʽ���谭�����������Ĳ��д���
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

        //�������ú�java.util.Comparator.comparing
        //�������ÿ��Ա��������������ض�������Lambda��һ�ֿ��д��
        inventory.sort(comparing(Apple::getWeight));

        //�ݼ�����
        inventory.sort(comparing(Apple::getWeight).reversed());
        //�Ƚ�����
        inventory.sort(comparing(Apple::getWeight).reversed().thenComparing(Apple::getCountry));



        Predicate<Apple> redApple = Apple::isRed;

        //ν�ʽӿڰ������������� negate(��)�� and��or
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
        //�������������������ʹ�ù��캯�������ˣ�
        TriFunction<Integer, Integer, Integer, Apple> colorFactory = Apple::new;
        System.out.println(colorFactory);
    }

    //��������
    @Test
    public void test4(){
        //�����ּ�1���ٸ������2    :4
        Function<Integer, Integer> f = x -> x + 1;
        Function<Integer, Integer> g = x -> x * 2;
        Function<Integer, Integer> h = f.andThen(g);
        int result1 = h.apply(1);
        System.out.println(result1);

        //�����ֳ�2���ٸ������1   :3
        Function<Integer, Integer> h2 = f.compose(g);
        int result2 = h2.apply(1);
        System.out.println(result2);

        //andThen��ת����ˮ��
        //�ȼ���̧ͷ��Ȼ�����ƴд��飬������һ�����
        Function<String, String> addHeader = Letter::addHeader;
        Function<String, String> transformationPipeline
                = addHeader.andThen(Letter::checkSpelling)
                .andThen(Letter::addFooter);
        System.out.println(transformationPipeline.apply("Hi"));


        //�ڶ�����ˮ�߿���ֻ��̧ͷ����������ƴд���
        Function<String, String> addHeader2 = Letter::addHeader;
        Function<String, String> transformationPipeline2
                = addHeader2.andThen(Letter::addFooter);
        System.out.println(transformationPipeline2.apply("Hello"));
    }


}