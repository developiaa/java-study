package basic.dequeue;

import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingDeque;

public class DequeTest2 {
    public static void main(String[] args) {
        Deque<String> deque = new LinkedBlockingDeque<>();
        deque.add("a");
        deque.add("b");
        deque.offer("c");
        deque.offer("d");

        System.out.println("deque = " + deque);

        for (String s : deque) {
            System.out.println("s = " + s);
        }
        System.out.println();

        Iterator<String> iterator = deque.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println("next = " + next);
        }
        System.out.println();

        Iterator<String> stringIterator = deque.descendingIterator();
        while (stringIterator.hasNext()) {
            String next = stringIterator.next();
            System.out.println("next = " + next);
        }
    }
}
