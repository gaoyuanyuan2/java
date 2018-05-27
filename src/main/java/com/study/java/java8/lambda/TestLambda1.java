package com.study.java.java8.lambda;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
