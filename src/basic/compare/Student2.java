package basic.compare;

import java.util.Comparator;

public class Student2 implements Comparator<Student2> {
    String name;
    Integer age;
    Integer number;


    @Override
    public int compare(Student2 o1, Student2 o2) {
        // Comparator는 자기자신이 아닌 매개변수 2개와 비교한다.
        return o1.age - o2.age;
    }
}
