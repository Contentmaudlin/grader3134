/* Sejal Jain
 * sj2735 
 * TwoStackQueueTester.java - tester class for TwoStackQueue */

public class TwoStackQueueTester {

    public static final void main(String[] args) {


	TwoStackQueue<Integer> q = new TwoStackQueue<Integer>();
	System.out.println(q.size());
	System.out.println(q.dequeue());
	q.enqueue(5);
	q.enqueue(9);
	System.out.println(q.dequeue());
	q.enqueue(12);
	q.enqueue(1);
	q.enqueue(8);
	System.out.println(q.size());
	System.out.println(q.dequeue());
	q.enqueue(15);

	while(!q.isEmpty())
	    System.out.println(q.dequeue());


    }

}