package basic.call;

public class CallByValue2 {
    public static void main(String[] args) {
        Member memberA = new Member("memberA", 10);
        System.out.println("memberA = " + memberA);
        System.out.println();
        call(memberA);
        System.out.println("After call");
        System.out.println("memberA = " + memberA);
        System.out.println();

    }


    public static void call(Member member) {
        // 자바는 call by value방식을 취하며, 값을 넘겨 받은 메소드에서 값을 복사하여
        // 새로운 지역 변수에 할당
        // 참조 타입의 경우에는 힙 메모리에 생성된 객체의 주소값을 복사해서 넘긴다.
        // 포인트는 주소값을 그냥 보내는 것이 아닌 주소값을 가리키는 참조값을 "복사"하여 전달 하기 때문에 call by value

        member.name = "changeMemberA";
        member.age = 20;
        System.out.println("In call()");
        System.out.println("memberA = " + member);
        System.out.println();
    }

    public static void call2(Member member) {
        member = new Member("changeMemberA", 20);
        System.out.println("In call()");
        System.out.println("memberA = " + member);
        System.out.println();
    }

}

class Member {
    String name;
    int age;

    public Member(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
