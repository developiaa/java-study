package basic.dequeue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * deque1 = [c]
 * deque2 = [d]
 *
 * deque1 = [a, c]
 * deque2 = [b, d]
 *
 * element = a
 * peek = b
 * first = a
 * peekFirst = b
 *
 * last = c
 * peekLast = d
 *
 * deque1 = [a, c]
 * deque2 = [b, d]
 * deque1 = [c]
 * deque2 = [d]
 */
public class DequeueTest {
    public static void main(String[] args) {
        Deque<String> deque1 = new ArrayDeque<>();
        Deque<String> deque2 = new ArrayDeque<>();

        deque1.add("c");
        System.out.println("deque1 = " + deque1);
        deque2.offer("d");
        System.out.println("deque2 = " + deque2);
        System.out.println();

        deque1.addFirst("a");
        System.out.println("deque1 = " + deque1);
        deque2.offerFirst("b");
        System.out.println("deque2 = " + deque2);
        System.out.println();

        String element = deque1.element();
        System.out.println("element = " + element);
        String peek = deque2.peek();
        System.out.println("peek = " + peek);
        String first = deque1.getFirst();
        System.out.println("first = " + first);
        String peekFirst = deque2.peekFirst();
        System.out.println("peekFirst = " + peekFirst);
        System.out.println();

        String last = deque1.getLast();
        System.out.println("last = " + last);
        String peekLast = deque2.peekLast();
        System.out.println("peekLast = " + peekLast);
        System.out.println();

        System.out.println("deque1 = " + deque1);
        System.out.println("deque2 = " + deque2);

        deque1.removeFirst();
        System.out.println("deque1 = " + deque1);
        deque2.pollFirst();
        System.out.println("deque2 = " + deque2);
    }
}
