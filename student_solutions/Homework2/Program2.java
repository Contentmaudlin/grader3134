/* Andrew Lee
 * awl2144
 * Program2.java
 */

public class Program2 {

      /*  Expected output:
        dog
        3
        false
        cat
        fish
        lizard
        pig
        bird
        frog

       */
  public static final void main(String[] args) {

    TwoStackQueue<String> q = new TwoStackQueue<String>();

    q.enqueue("dog");
    q.enqueue("cat");
    q.enqueue("fish");
    System.out.println(q.dequeue());
    q.enqueue("lizard");
    System.out.println(q.size());
    System.out.println(q.isEmpty());
    q.enqueue("pig");
    q.enqueue("bird");
    System.out.println(q.dequeue());
    q.enqueue("frog");

    while(!q.isEmpty()) {
        System.out.println(q.dequeue());
    }
    System.out.println(q.dequeue());
        /*  Testing for ints:

        1
        5
        false
        2

        */

    System.out.println();
    System.out.println("Testing for ints: ");
    System.out.println();

    TwoStackQueue<Integer> q2 = new TwoStackQueue<Integer>();

    q2.enqueue(1);
    q2.enqueue(2);
    q2.enqueue(3);
    System.out.println(q2.dequeue());
    q2.enqueue(4);
    q2.enqueue(5);
    q2.enqueue(6);
    System.out.println(q2.size());

    System.out.println(q2.isEmpty());
    System.out.println(q2.dequeue());



  }


}
