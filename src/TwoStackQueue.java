import java.util.Stack;

public class TwoStackQueue {
    public static void main(String[] args) {
        QueueStack<Integer> i = new QueueStack<>();

        i.add(1);
        i.add(2);
        i.add(3);

        System.out.println(i.poll());
        System.out.println(i.poll());
        System.out.println(i.poll());

    }


}

class QueueStack<T> {
    //스택1은 더하기만 하는 용도
    Stack<T> stack1 = new Stack<>();
    Stack<T> stack2 = new Stack<>();

    private void move() {
        //스택2의 공간이 있을 때만 넣는다.
        if (stack2.size() == 0) {
            //스택1이 빌 때까지 넣는다.
            while (stack1.size() != 0) {
                stack2.add(stack1.pop());
            }
        }
    }

    public void add(T t) {
        stack1.add(t);
    }

    public T peek() {
        move();
        return stack2.peek();
    }

    public T poll() {
        move();
        return stack2.pop();
    }

    public int size() {
        return stack1.size() + stack2.size();
    }
}
