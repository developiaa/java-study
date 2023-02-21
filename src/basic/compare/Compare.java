package basic.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Compare {
    public static void main(String[] args) {
        Student student = new Student("a",20,5);
        Student student2 = new Student("b",22,2);
        Student student3 = new Student("c",27,4);

        System.out.println(student.compareTo(student2)); // -2


        // Comparable 익명객체로 선언한 경우
        // 자신의 객체와 어떤 객체를 비교하려고 할 때 동일 타입은 비교가 불가능하다.
        Comparable<Student> com = new Comparable<>() {
            final int age = 23;

            @Override
            public int compareTo(Student o) {
                return age - o.age;
            }
        };

        // Comparator 익명객체로 선언한 경우
        Comparator<Student> com1 = (o1, o2) -> o1.number - o2.number;

        System.out.println("익명 클래스 사용");
        System.out.println(com1.compare(student, student2)); // 1


        List<Student> list = new ArrayList<>();
        list.add(student);
        list.add(student2);
        list.add(student3);
        System.out.println("before = " + list);
        // 나이 내림차순
        Collections.sort(list, (s1, s2) -> s2.getAge() - s1.getAge());
        System.out.println("나이 내림차순 = " + list);

        // number 내림차순
        Collections.sort(list, (s1, s2) -> s2.getNumber() - s1.getNumber());
        System.out.println("number 내림차순 = " + list);
    }
}
