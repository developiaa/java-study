package study.developia.java.함수형_프로그래밍_with_자바.chapter4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class Immutable {

    @Test
    void testList() {
        List<String> origin = new ArrayList<>();
        origin.add("A");
        origin.add("B");

        List<String> copy = List.copyOf(origin);
        origin.add("C");

        Assertions.assertEquals(origin.size(), 3);
        Assertions.assertEquals(copy.size(), 2);
        Assertions.assertThrows(UnsupportedOperationException.class, () -> copy.add("D"));
    }

    @Test
    void testSet() {
        Set<String> origin = new HashSet<>();
        origin.add("A");
        origin.add("B");

        Set<String> copy = Set.copyOf(origin);
        origin.add("C");

        Assertions.assertEquals(origin.size(), 3);
        Assertions.assertEquals(copy.size(), 2);
        Assertions.assertThrows(UnsupportedOperationException.class, () -> copy.add("D"));
    }

    @Test
    void testMap() {
        Map<String, String> origin = new HashMap<>();
        origin.put("A","A");
        origin.put("B","B");

        Map<String, String> copy = Map.copyOf(origin);
        origin.put("C","C");

        Assertions.assertEquals(origin.size(), 3);
        Assertions.assertEquals(copy.size(), 2);
        Assertions.assertThrows(UnsupportedOperationException.class, () -> copy.put("D","D"));
    }
}
