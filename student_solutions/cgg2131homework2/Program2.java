// Program2.java
// Data Structures - Homework 2
// Connor Goggins

public class Program2 {

    /** If implemented correctly, this code should output:
     *  0
     *  1
     *  a
     *  b
     *  2
     *  c
     *  d
     *  e
     *  f
     */

    public static final void main(String[] args) {
      	TwoStackQueue<String> q = new TwoStackQueue<String>();

        System.out.println(q.size());
      	q.enqueue("a");
        System.out.println(q.size());
      	System.out.println(q.dequeue());
        q.enqueue("b");
        q.enqueue("c");
        System.out.println(q.dequeue());
        q.enqueue("d");
      	System.out.println(q.size());
      	q.enqueue("e");
      	q.enqueue("f");
      	System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
    }
}
