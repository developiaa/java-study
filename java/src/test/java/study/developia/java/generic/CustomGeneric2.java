package study.developia.java.generic;

public class CustomGeneric2<E extends Comparable<? super E>> {
//public class CustomGeneric2<E extends Comparable<E>> { // 타입 업캐스팅에 의해서 에러 가능성 있음,
    E element;

    E getElement() {
        return element;
    }

    void setElement(E element) {
        this.element = element;
    }

    <T> T getGeneric(T t) {
        return t;
    }

//    static E genericMethod(E o) {	// error
//        return o;
//    }

    static <E> E genericMethod(E o) {    // okay
        return o;
    }

}
