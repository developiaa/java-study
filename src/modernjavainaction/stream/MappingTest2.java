package modernjavainaction.stream;

import java.util.Arrays;
import java.util.List;


// page 165 ~ 166
public class MappingTest2 {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(3,4);

        List<int[]> collect = list1.stream()
                .flatMap(i ->
                        list2.stream()
                                .map(j -> new int[]{i, j}))
                .toList();

        for (int[] ints : collect) {
            System.out.println("ints = " + Arrays.toString(ints));
        }
    }
}
