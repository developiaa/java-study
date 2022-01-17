import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializeTest {
    public static void main(String[] args) {
        Member member = new Member("name", "email", 12);
        byte[] serializedMember;

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
                oos.writeObject(member);
                // serializedMember -> 직렬화된 member 객체
                serializedMember = baos.toByteArray();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// Member 클래스를 직렬화
class Member implements Serializable {
    private static final long serialVersionUID = 1L;
    private transient String name;
    private String email;
    private int age;

    public Member(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
