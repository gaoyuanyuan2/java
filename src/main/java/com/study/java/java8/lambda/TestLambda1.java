package com.study.java.java8.lambda;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
*
*  把方法作为值来传递显然很有用，但要是为类似于isHeavyApple和isGreenApple这种可
*  能只用一两次的短方法写一堆定义有点儿烦人。不过Java 8也解决了这个问题，它引入了一套新
*  记法（匿名函数或Lambda）
*
*   你甚至都不需要为只用一次的方法写定义；代码更干净、更清晰，因为你用不着去找自己到底传递了什么代码。
*
*   箭头——箭头->把参数列表与Lambda主体分隔开
*
* */

public class TestLambda1 {
    List<Employee> emps = Lists.newArrayList(
            new Employee(101, "张三", 18, 9999.99),
            new Employee(102, "李四", 59, 6666.66),
            new Employee(103, "王五", 28, 3333.33),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(105, "田七", 38, 5555.55)
    );

    //优化方式一：策略设计模式
    public List<Employee> filterEmployee(List<Employee> emps, Filters<Employee> mp){
        List<Employee> list = new ArrayList<>();
        for (Employee employee : emps) {
            if(mp.filters(employee)){
                list.add(employee);
            }
        }
        return list;
    }

    //匿名内部类：灵活
    @Test
    public  void  test1(){
        List<Employee> employeeList = filterEmployee(emps, new Filters<Employee>() {
            @Override
            public boolean filters(Employee employee) {
                return employee.getAge()<30;
            }
        });

        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }

    //Lambda 表达式
    @Test
    public void test6(){
        List<Employee> employeeList = filterEmployee(emps, (e) -> e.getAge() <= 35 );
        employeeList.forEach(System.out::println);

        System.out.println("------------------------------------------");

        List<Employee> employeeList2 = filterEmployee(emps, (e) -> e.getSalary() >= 5000);
        employeeList.forEach(System.out::println);
    }

    //Stream API
    @Test
    public void test3(){
        emps.stream()
                .filter((e) -> e.getAge() <= 35)
                .forEach(System.out::println);

        System.out.println("----------------------------------------------");

        emps.stream()
                .map(Employee::getName)
                .limit(3)
                .sorted()
                .forEach(System.out::println);
    }

}
