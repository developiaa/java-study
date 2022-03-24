package modernjavainaction.apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BehaviorParameterization {
    public static void main(String[] args) {
        List<Apple> list = Arrays.asList(
                new Apple(80, Color.GREEN),
                new Apple(155, Color.GREEN),
                new Apple(120, Color.RED));

        List<Apple> filter1 = filter(list, new AppleColorPredicate());
        System.out.println("filter1 = " + filter1);
        List<Apple> filter2 = filter(list, new AppleWeightPredicate());
        System.out.println("filter2 = " + filter2);
    }

    public static List<Apple> filter(List<Apple> list, ApplePredicate predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : list) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }


}
