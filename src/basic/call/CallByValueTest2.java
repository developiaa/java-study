package basic.call;

public class CallByValueTest2 {
    public static void main(String[] args) {
        Student student = new Student("developia","남자");
        System.out.println("student = "+ student);
        call(student);
        System.out.println("student = " + student);

    }

    public static void call(Student student) {
        student.setName("developiaa");
        student.setGender("여자");
        System.out.println("call : " + student);
    }
}

class Student{
    private String name;
    private String gender;

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Student(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}


