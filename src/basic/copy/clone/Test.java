package basic.copy.clone;

public class Test {
    public static void main(String[] args) {
        String test1 = "abc";
        String test2 = "abc";
        String test3 = new String("abc");

        System.out.println(test1 == test2);
        System.out.println(test1 == test3);
    }
}
