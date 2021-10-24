public class CallByValue {

    public static void main(String[] args) {
        /**
         * primitive 타입은 값 자체를 복사하기 때문에 swap되지 않는다.
         *
         * swap() 메소드를 호출 할 때 사용한 인자와
         * 함수의 매개변수 x, y는 서로 다르다.
         *
         */
        int a = 1;
        int b = 2;
        System.out.println("before");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("======");
        swap(1, 2);
        System.out.println("after");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("======");

        System.out.println();

        /**
         * reference 타입
         *  객체를 메소드로 넘길 때 객체를 참조하는 지역변수의 실제 주소를 넘기는 것이 아니라
         *  그 지역변수가 가리키고 있는 힙 영역의 객체를 가리키는 새로운 지역변수를 생성하여
         *  그것을 통하여 같은 객체를 가리키도록 하는 방식이라는 것이다.
         */
        CallByReference c = new CallByReference(10);
        CallByReference d = new CallByReference(20);
        System.out.println("before");
        System.out.println("c = " + c.value);
        System.out.println("d = " + d.value);
        System.out.println("======");
        swap(c,d);
        System.out.println("after");
        System.out.println("c = " + c.value);
        System.out.println("d = " + d.value);
        System.out.println("======");
    }

    public static void swap(int x, int y) {
        int temp = x;
        x = y;
        y = temp;
    }

    public static void swap(CallByReference test1, CallByReference test2) {
        int temp = test1.value;
        test1.value = test2.value;
        test2.value = temp;
    }

}

class CallByReference {
    public int value;

    public CallByReference(int value) {
        this.value = value;
    }
}
