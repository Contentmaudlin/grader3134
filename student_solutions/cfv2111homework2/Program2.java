/* Chiara Vallini 
 * cfv2111
 * Program2.java 
 * This class tested my TwoStackQueue class for the implementation of a queue of integers using 
 * two stacks 
 */
public class Program2 {
	// Main method 
	public static final void main(String[] args) {

		/** This code should output: 
		 * The size of the queue is now 0!
		 * 1
		 * The size of the queue is now 2!
		 * 8
		 * 3
		 * 4
		 * 7
		 * 9
	     */
		// create the queue 
		TwoStackQueue<Integer> q = new TwoStackQueue<Integer>();
		// get the size of the queue 
		System.out.println("The size of the queue is now " + q.size() + "!" );
		// enqueue
		q.enqueue(1);
		q.enqueue(8);
		q.enqueue(3);
		// return the dequeue
		System.out.println(q.dequeue());
		// get the size 
		System.out.println("The size of the queue is now " + q.size() + "!" );
		// enqueue
		q.enqueue(4);
		q.enqueue(7);
		// return the dequeue
		System.out.println(q.dequeue());
		q.enqueue(9);
		// return the dequeue until the end of the queue 
		while(!q.isEmpty())
		    System.out.println(q.dequeue());


	    }
}
