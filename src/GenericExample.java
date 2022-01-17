// 제네릭 사용하지 않을 때는 모든 클래스의 조상인 Object 타입으로 사용할 수 있지만
// 형변환 이슈가 있기 때문에 불편하다.
//class GenericExample {
//    private Object object;
//
//    public void setT(Object object) {
//        this.object = object;
//    }
//
//    public Object get() {
//        return object;
//    }
//}

class GenericExample<T> {
    private T t;

    public void setT(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }
}

interface IGenericExample<T> {
    T example();
}

class GenericExample2 implements IGenericExample<String> {
    @Override
    public String example() {
        return null;
    }
}

// 사용예시
// GenericExample<String> s = new GenericExample<>();
