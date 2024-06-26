package study.developia.java.모던자바인액션.ch15.flow;

import java.util.*;
import java.util.concurrent.*;
import java.util.function.Consumer;

public class SimpleCell implements Flow.Publisher<Integer>, Flow.Subscriber<Integer> {
    private int value = 0;
    private String name;
    private List<Flow.Subscriber<? super Integer>> subscribers = new ArrayList<>();

    public static void main(String[] args) {
        SimpleCell c3 = new SimpleCell("C3");
        SimpleCell c2 = new SimpleCell("C2");
        SimpleCell c1 = new SimpleCell("C1");

        c1.subscribe(c3);

        c1.onNext(10); // C1의 값을 10으로 갱신
        c2.onNext(20); // C2의 값을 20으로 갱신
    }

    public SimpleCell(String name) {
        this.name = name;
    }

    @Override
    public void subscribe(Flow.Subscriber<? super Integer> subscriber) {
        subscribers.add(subscriber);
    }

    public void subscribe(Consumer<? super Integer> onNext) {
        subscribers.add(new Flow.Subscriber<Integer>() {

            @Override
            public void onComplete() {}

            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
            }

            @Override
            public void onNext(Integer val) {
                onNext.accept(val);
            }

            @Override
            public void onSubscribe(Flow.Subscription s) {}

        });
    }

    private void notifyAllSubscribers() {
        subscribers.forEach(subscriber -> subscriber.onNext(value));
    }

    @Override
    public void onNext(Integer newValue) {
        value = newValue;
        System.out.println(name + ":" + value);
        notifyAllSubscribers();
    }

    @Override
    public void onComplete() {}

    @Override
    public void onError(Throwable t) {
        t.printStackTrace();
    }

    @Override
    public void onSubscribe(Flow.Subscription s) {}
}
