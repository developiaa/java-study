package study.developia.java.모던자바인액션.ch05;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.developia.java.모던자바인액션.ch05.test.Trader;
import study.developia.java.모던자바인액션.ch05.test.Transaction;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

public class Practice {
    Trader raoul = new Trader("Raoul", "Cambridge");
    Trader mario = new Trader("Mario", "Milan");
    Trader alan = new Trader("Alan", "Cambridge");
    Trader brian = new Trader("Brian", "Cambridge");

    List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
    );

    @DisplayName("2011년에 일어난 모든 트랜잭션을 찾아 값을 오름차순으로 정리하시오")
    @Test
    void test1() {
        List<Transaction> list = transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparingInt(Transaction::getValue))
                .toList();
        System.out.println(list);
        assertThat(list.size()).isEqualTo(2);
    }

    @DisplayName("거래자가 근무하는 모든 도시를 중복 없이 나열하시오")
    @Test
    void test2() {
        List<String> list = transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .toList();

        System.out.println(list);
        assertThat(list.size()).isEqualTo(2);
        assertThat(list).isEqualTo(List.of("Cambridge", "Milan"));
    }

    @DisplayName("케임브리지에서 근무하는 모든 거래자를 찾아서 이름순으로 정렬하시오")
    @Test
    void test3() {
        List<Trader> list = transactions.stream()
                .map(Transaction::getTrader)
                .filter(t -> t.getCity().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .toList();

        System.out.println(list);
        assertThat(list.size()).isEqualTo(3);
    }

    @DisplayName("모든 거래자의 이름을 알파벳순으로 정렬해서 반환하시오")
    @Test
    void test4() {
        String traderStr = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("", (n1, n2) -> n1 + n2);

        System.out.println(traderStr); // AlanBrianMarioRaoul
    }

    @DisplayName("밀라노에 거래자가 있는가?")
    @Test
    void test5() {
        boolean hasMilan = transactions.stream()
                .anyMatch(t -> t.getTrader().getCity().equals("Milan"));

        assertThat(hasMilan).isTrue();
    }

    @DisplayName("케임브리지에 거주하는 거래자의 모든 트랜잭션값을 출력하시오")
    @Test
    void test6() {
        transactions.stream()
                .filter(t -> "Cambridge".equals(t.getTrader().getCity()))
                .map(Transaction::getValue)
                .forEach(System.out::println);
    }

    @DisplayName("전체 트랜잭션 중 최대값은 얼마인가?")
    @Test
    void test7() {
        Integer reduce = transactions.stream()
                .map(Transaction::getValue)
                .reduce(0, Integer::max);

        assertThat(reduce).isEqualTo(1000);
    }

    @DisplayName("전체 트랜잭션 중 최솟값은 얼마인가?")
    @Test
    void test8() {
        Optional<Integer> min = transactions.stream()
                .map(Transaction::getValue)
                .min(Comparator.comparingInt(Integer::intValue));

        assertThat(min).isEqualTo(Optional.of(300));
    }


}
