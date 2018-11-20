package com.study.java.java8.test;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

/**
 * Created by yan on  20/11/2018.
 */
public class StreamTest2 {

    private Trader raoul = new Trader("Raoul", "Cambridge");
    private Trader mario = new Trader("Mario", "Milan");
    private Trader alan = new Trader("Alan", "Cambridge");
    private Trader brian = new Trader("Brian", "Cambridge");

    private List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
    );

    private List<Trader> traders = Arrays.asList(raoul, mario, alan, brian);

    // 找出2011年的所有交易并按交易额排序（从低到高）
    @Test
    public void test1() {
        List<Transaction> transactionList = transactions.stream().filter((a) -> a.getYear() == 2011)
                .sorted(comparing(Transaction::getValue))
                .collect(toList());
    }

    //交易员都在哪些不同的城市工作过
    @Test
    public void test2() {
        List<String> cities = transactions.stream().map(Transaction::getTrader)
                .map(Trader::getCity)
                .distinct()
                .collect(toList());
        System.out.println(cities);

        //这里还有一个新招：你可以去掉distinct()，改用toSet()，这样就会把流转换为集合。
        Set<String> cities2 =
                transactions.stream()
                        .map(transaction -> transaction.getTrader().getCity())
                        .collect(toSet());
    }
}
