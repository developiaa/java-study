public class StringTest {
    public static void main(String[] args) {
        // String 클래스의 경우 immutable하기 때문에 값을 추가할 경우 새로운 메모리로 할당
        // 문자열의 추가/수정/삭제와 같은 작업이 빈번할 경우 힙 메모리에 많은 가비지가 발생하여 성능악화
        String s1="aa"; // String s1 = new String("aa");
        System.out.println(System.identityHashCode(s1));
        s1+="bb";
        System.out.println(System.identityHashCode(s1));

        // StringBuilder와 StringBuffer는 mutable(가변성)하다.
        // 그렇기 때문에 동일 객체 내에서 문자열을 변경하는 것이 가능하다. 아이디 값이 같은 것을 확인할 수 있다.
        StringBuilder s2 = new StringBuilder("aa");
        System.out.println(System.identityHashCode(s2));
        s2.append("bb");
        System.out.println(System.identityHashCode(s2));

        StringBuffer s3 = new StringBuffer("aa");
        System.out.println(System.identityHashCode(s3));
        s3.append("bb");
        System.out.println(System.identityHashCode(s3));

        // 그렇다면 StringBuilder와 StringBuffer의 차이점은?
        // StringBuffer는 synchronized 키워드를 지원하여 멀티스레드 환경에서 안전하다(thread-safe)
        // 참고로 String도 불변성을 가지기 때문에 마찬가지로 멀티스레드 환경에서 안정성을 가진다.

        // StringBuilder는 동기화를 지원하지 않아 멀티스레드 환경에서 바람직하지 않으나 동기화를 고려하지 않은
        // 단일 스레드 환경에서의 속도는 StringBuffer보다 뛰어나다.

    }

}
