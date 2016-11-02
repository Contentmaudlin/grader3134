/*
 * UNI:wl2536
 * Author: Wenbo Li
 * Program: Test File
 */
import org.junit.Test;

public class Program2{

public void test() {
        TwoStackQueue queue = new TwoStackQueue();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(3);
        queue.add(4);
        System.out.println("peek:" + queue.peek());
        while (true) { 
            try {
                System.out.println(queue.poll());
            } catch (Exception e) {
                break;
            }
        }
        TwoStackQueue queue1 = new TwoStackQueue();
        queue1.peek(); // java.lang.RuntimeException: Your queue is empty.
    }
}