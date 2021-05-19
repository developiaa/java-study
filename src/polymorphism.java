public class polymorphism {
    public static void main(String[] args) {
        Parent p = new Child();
        Child c = new Child();

        // (자식클래스에서 메소드가 오버라이딩 되어 있다는 가정하에)
        // 멤버 변수, static 메소드는 현재 참조 변수의 타입(Parent)을 따른다.
        System.out.println("p.x = " + p.x);
        System.out.println("p.k = " + p.k);

        // 조상타입(Parent)의 참조 변수가 인스턴스 메서드를 호출시에는 실제 인스턴스(Child)를 따른다.
        p.method();
        System.out.println();


        System.out.println("c.x = " + c.x);
        System.out.println("p.k = " + c.k);
        c.method();
    }
}


class Parent {
    static int k = 400;
    int x = 100;

    void method() {
        System.out.println("Parent Method");
    }
}

class Child extends Parent {
    static int k = 500;
    int x = 200;

    void method() {
        System.out.println("Child Method");
    }
}

//p.x = 100
//p.k = 400
//Child Method
//
//c.x = 200
//p.k = 500
//Child Method
