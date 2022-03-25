package modernjavainaction.lambda;

public class LambdaTest {
    public static void main(String[] args) {
        IntPredicate evenNumber = (int i) -> i % 2 == 0 ;
        boolean test = evenNumber.test(1000);
        System.out.println("test = " + test);


        Sum kk = (int a, int b) -> a + b;
        int s1 = 100;
        int s2 = 200;
        int sum1 = kk.add(s1, s2);
        System.out.println("sum1 = " + sum1);
    }
}
