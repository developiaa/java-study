package basic.call;

public class CallByValue {
    public static void main(String[] args) {
        method();
    }

    public static void method() {
        int a = 1;
        int b = 2;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println();
        call(a, b);
        System.out.println("After call");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println();
    }

    public static void call(int a, int b) {
        a = 10;
        b = 20;
        System.out.println("In call()");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println();
    }
}
