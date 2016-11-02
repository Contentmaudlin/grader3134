/* Trung Vu
 * UNI: ttv2107
 * COMS W3134
 * Instructor: Professor Blaer
 * Homework 2
 * October 7th, 2016
 */

/* This program tests the TwoStackQueue class
 */

public class Program2 {
    public static final void main(String[] args) {
        TwoStackQueue<Integer> queue = new TwoStackQueue<>();
        
        /* This program should output:
         * 5 
         * 0 
         * 1
         * 2
         * 3
         * 4
         * 5
         * 6
         * 7
         * 8 
         * 9
         * 10
         * 11
         */

        queue.enqueue(0);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        System.out.println(queue.size());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.enqueue(5);
        queue.enqueue(6);
        
        int i = 6;
        while (!queue.isEmpty()) {
            queue.enqueue(++i);
            System.out.println(queue.dequeue());
            System.out.println(queue.dequeue());
        }

        queue.dequeue();
    }
}
