package modernjavainaction.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// page 165 ~ 166
public class MappingTest3 {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(3,4);

        List<int[]> collect = list1.stream()
                .flatMap(i ->
                        list2.stream()
                                .filter(j -> (i + j) % 3 == 0)
                                .map(j -> new int[]{i, j})
                )
                .collect(Collectors.toList());

        for (int[] ints : collect) {
            System.out.println("Arrays.toString(ints) = " + Arrays.toString(ints));

        }
    }
}
