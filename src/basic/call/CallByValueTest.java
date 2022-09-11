package basic.call;

public class CallByValueTest {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;

        System.out.println("a = " + a);
        System.out.println("b = " + b);
        call(a, b);
        System.out.println("after call");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }

    public static void call(int a, int b) {
        a = 10;
        b = 20;

        System.out.println("a = " + a);
        System.out.println("b = " + b);

    }
}
