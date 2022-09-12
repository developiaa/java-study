package basic.compare;

import java.util.Comparator;

public class Compare {
    public static void main(String[] args) {
        Student student = new Student("a",20,2);
        Student student2 = new Student("b",22,1);

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

    }
}
