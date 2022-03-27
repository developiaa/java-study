package modernjavainaction.stream;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

// page 165 ~ 166
public class MappingTest1 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> collect = list.stream()
                .map(i -> i * i)
                .collect(toList());

        System.out.println("collect = " + collect);

    }
}
