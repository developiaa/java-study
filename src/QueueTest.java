import java.util.LinkedList;
import java.util.Queue;

//queue 큐는 first in first out의 특징을 가진다.
public class QueueTest {

    public static void main(String[] args) {
        Queue<Integer> queueInteger = new LinkedList<>();
        Queue<String> queueString = new LinkedList<>();

        //값 추가
        queueInteger.add(1);
        queueInteger.add(2);

        //값 추가
        queueInteger.offer(3);
        queueInteger.offer(4);

        //add와 offer의 차이는 add는 큐가 꽉차는 상황에서는 illegalStateException을 발생시킨다.
        //offer는 false 반환

        //값 삭제
        //remove()의 경우 값이 없을 경우 예외를 발생시킨다.
        //poll()의 경우 값이 없을 경우 null
        queueInteger.remove();
        queueInteger.poll();

        //삭제 없이 첫 요소를 읽어 온다.
        queueInteger.peek();
    }
}
