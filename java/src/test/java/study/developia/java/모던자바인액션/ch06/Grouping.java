package study.developia.java.모던자바인액션.ch06;

import org.junit.jupiter.api.Test;

import java.util.*;

import static java.util.stream.Collectors.*;
import static org.assertj.core.api.Assertions.*;
import static study.developia.java.모던자바인액션.ch06.Dish.dishTags;
import static study.developia.java.모던자바인액션.ch06.Dish.menu;

public class Grouping {
    enum CaloricLevel {DIET, NORMAL, FAT}

    ;

    @Test
    void test1() {
        Map<Dish.Type, List<Dish>> collect = menu.stream().collect(groupingBy(Dish::getType));
        assertThat(collect).hasSize(3);
        assertThat(collect.get(Dish.Type.MEAT).size()).isEqualTo(3);
        assertThat(collect.get(Dish.Type.FISH).size()).isEqualTo(2);
        assertThat(collect.get(Dish.Type.OTHER).size()).isEqualTo(4);
    }

    @Test
    void test2() {
        Map<CaloricLevel, List<Dish>> collect = menu.stream().collect(groupingBy(dish -> {
            if (dish.getCalories() <= 400) {
                return CaloricLevel.DIET;
            } else if (dish.getCalories() <= 700) {
                return CaloricLevel.NORMAL;
            } else {
                return CaloricLevel.FAT;
            }
        }));

        assertThat(collect).hasSize(3);
        assertThat(collect.get(CaloricLevel.DIET).size()).isEqualTo(4);
    }

    @Test
    void test3() {
        Map<Dish.Type, List<Dish>> collect1 = menu.stream().filter(dish -> dish.getCalories() > 500)
                .collect(groupingBy(Dish::getType));
        assertThat(collect1).hasSize(2);
        assertThat(collect1.get(Dish.Type.FISH)).isNull();

        Map<Dish.Type, List<Dish>> collect = menu.stream()
                .collect(groupingBy(Dish::getType, filtering(dish -> dish.getCalories() > 500, toList())));
        assertThat(collect).hasSize(3);
    }

    @Test
    void test4() {
        Map<Dish.Type, List<String>> collect = menu.stream().collect(groupingBy(Dish::getType, mapping(Dish::getName, toList())));
        assertThat(collect).hasSize(3);
        assertThat(collect.get(Dish.Type.MEAT)).hasSize(3);
    }

    @Test
    void test5() {
        Map<Dish.Type, Set<String>> collect = menu.stream()
                .collect(
                        groupingBy(
                                Dish::getType,
                                flatMapping(dish -> dishTags.get(dish.getName()).stream(), toSet()
                                )
                        )
                );

        assertThat(collect.get(Dish.Type.MEAT)).hasSize(5);
        assertThat(collect.get(Dish.Type.MEAT)).isEqualTo(Set.of("salty", "greasy", "roasted", "fried", "crisp"));
    }

    @Test
    void test6() {
        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> collect = menu.stream().collect(
                groupingBy(Dish::getType,
                        groupingBy(dish -> {
                            if (dish.getCalories() <= 400) {
                                return CaloricLevel.DIET;
                            } else if (dish.getCalories() <= 700) {
                                return CaloricLevel.NORMAL;
                            } else {
                                return CaloricLevel.FAT;
                            }
                        }))
        );

        Map<Dish.Type, Map<CaloricLevel, List<String>>> collect2 = menu.stream().collect(
                groupingBy(Dish::getType,
                        groupingBy(dish -> {
                            if (dish.getCalories() <= 400) {
                                return CaloricLevel.DIET;
                            } else if (dish.getCalories() <= 700) {
                                return CaloricLevel.NORMAL;
                            } else {
                                return CaloricLevel.FAT;
                            }
                        }, mapping(Dish::getName, toList())))
        );
        System.out.println(collect);
        System.out.println(collect2);
        assertThat(collect.get(Dish.Type.MEAT).get(CaloricLevel.DIET)).hasSize(1);
        assertThat(collect2.get(Dish.Type.MEAT).get(CaloricLevel.DIET)).isEqualTo(List.of("chicken"));
    }

    @Test
    void test7() {
        Map<Dish.Type, Long> collect = menu.stream().collect(groupingBy(Dish::getType, counting()));

        assertThat(collect.get(Dish.Type.MEAT)).isEqualTo(3);
        assertThat(collect.get(Dish.Type.FISH)).isEqualTo(2);
        assertThat(collect.get(Dish.Type.OTHER)).isEqualTo(4);
    }

    @Test
    void test8() {
        Map<Dish.Type, Optional<Dish>> collect = menu.stream().collect(groupingBy(Dish::getType, maxBy(Comparator.comparingInt(Dish::getCalories))));
        System.out.println(collect);

        Map<Dish.Type, Dish> collect1 = menu.stream().collect(groupingBy(Dish::getType, collectingAndThen(maxBy(Comparator.comparingInt(Dish::getCalories)), Optional::get)));
        System.out.println(collect1);
    }

    @Test
    void test9() {
        Map<Dish.Type, Integer> collect = menu.stream().collect(groupingBy(Dish::getType, summingInt(Dish::getCalories)));
        assertThat(collect.get(Dish.Type.MEAT)).isEqualTo(1900);
        assertThat(collect.get(Dish.Type.OTHER)).isEqualTo(1550);
        assertThat(collect.get(Dish.Type.FISH)).isEqualTo(850);
    }

    @Test
    void test10() {
        Map<Dish.Type, Set<CaloricLevel>> collect = menu.stream().collect(
                groupingBy(Dish::getType,
                        mapping(dish -> {
                            if (dish.getCalories() <= 400) {
                                return CaloricLevel.DIET;
                            } else if (dish.getCalories() <= 700) {
                                return CaloricLevel.NORMAL;
                            } else {
                                return CaloricLevel.FAT;
                            }
                        }, toSet()))
        );

        Map<Dish.Type, Set<CaloricLevel>> collect2 = menu.stream().collect(
                groupingBy(Dish::getType,
                        mapping(dish -> {
                            if (dish.getCalories() <= 400) {
                                return CaloricLevel.DIET;
                            } else if (dish.getCalories() <= 700) {
                                return CaloricLevel.NORMAL;
                            } else {
                                return CaloricLevel.FAT;
                            }
                        }, toCollection(HashSet::new))
                ));

        System.out.println(collect);
        assertThat(collect).isEqualTo(collect2);
    }

}
