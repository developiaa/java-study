package study.developia.java.generic;

public class CustomGeneric<E>{
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

    static <E> E genericMethod(E o) {	// okay
        return o;
    }

}
