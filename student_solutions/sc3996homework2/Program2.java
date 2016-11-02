/**
 * Created by ShuqiChen on 16/10/2.
 */
public class Program2 {

    /** If implemented correctly, this code should output:
     * 0
     * 1
     * 3
     * 2
     * 3
     * 4
     * 5
     * 6
     * 7
     */
    public static final void main(String[] args) {

        TwoStackQueue<Integer> q1 = new TwoStackQueue<>();
        System.out.println(q1.size()); //return 0

        q1.enqueue(1);
        q1.enqueue(2);
        q1.enqueue(3);
        q1.enqueue(4);
        System.out.println(q1.dequeue()); //return 1
        System.out.println(q1.size()); //return 3
        q1.enqueue(5);
        q1.enqueue(6);
        System.out.println(q1.dequeue()); //return 2
        q1.enqueue(7);

        while (!q1.isEmpty()) {
            System.out.println(q1.dequeue()); //return 34567
        }
    }
}
