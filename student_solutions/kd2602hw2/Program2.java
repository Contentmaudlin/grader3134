/**
 * Created by kd2602 on 10/8/16.
 */
public class Program2 {

    /** If implemented correctly, this code should output:
     * *  null
     * *  0
     * *  2
     * *  4
     * *  6
     * *  8
     * *  20
     * *  30
     * *  40
     * *  50
     * *  null
     * *  1
     * *  2
     * *  3
     * *  4
     * */

    public static final void main(String[] args) {

        TwoStackQueue<Integer> q = new TwoStackQueue<Integer>();

        System.out.println(q.dequeue()); // Testing dequeue from newly empty stack
        q.enqueue(0);
        q.enqueue(2);
        q.enqueue(4);
        q.enqueue(6);
        q.enqueue(8);
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue()); //Testing dequeue from now empty stack
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        while(!q.isEmpty())
            System.out.println(q.dequeue());

    }
}
