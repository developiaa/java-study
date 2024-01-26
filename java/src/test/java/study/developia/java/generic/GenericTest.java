package study.developia.java.generic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GenericTest {

    @Test
    void test(){
        CustomGeneric<String> generic = new CustomGeneric<>();
        String word = "a";
        String a = generic.getGeneric(word);
        String a2 = CustomGeneric.genericMethod(word);
        assertEquals(word, a);
        assertEquals(word, a2);


        CustomGeneric<Integer> generic2 = new CustomGeneric<>();
        int number = 123;
        Integer b = generic2.getGeneric(number);
        assertEquals(number, b);
    }

    @Test
    void test2() {
        CustomGeneric2<Student> customGeneric2 = new CustomGeneric2<>();
    }

    static class Person{

    }

    static class Student extends Person implements Comparable<Person> {
        @Override
        public int compareTo(Person o) {
            return 0;
        }
    }

}
