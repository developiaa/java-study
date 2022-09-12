package basic.compare;

public class Student implements Comparable<Student> {
    String name;
    Integer age;
    Integer number;

    public Student(String name, Integer age, Integer number) {
        this.name = name;
        this.age = age;
        this.number = number;
    }

    @Override
    public int compareTo(Student student) {
        // Comparable은 자기자신과 매개변수를 비교한다.
        // 기본적으로 정렬은 오름차순
        // 리턴값이 음수일 경우 선행값이 작은 값이므로 정렬하지 않는다.
        // 리턴값을 양수일 경우 선행값이 큰 값이므로 오름차순으로 정렬한다.
        return this.age - student.age;
    }

}
