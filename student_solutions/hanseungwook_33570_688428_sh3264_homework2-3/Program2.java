/* Author: Seungwook Han
 * UNI: sh3264
 * Data Structures
 * Program2 - This class is used as a tester to check 
 * whether the TwoStackQueue is working properly
 */

/* If working properly, this should print
 * null
 * 10
 * false
 * 2
 * 4
 * 6
 * 8
 * 10
 * 12
 * 14
 * 16
 * 18
 * 1000
 */

public class Program2 {

	public static void main(String[] args) {
		
		// Creates a TwoStackQueue object
		TwoStackQueue<Integer> q = new TwoStackQueue<Integer>();

		// Checks if it returns null when it is dequeued with nothing inside
		System.out.println(q.dequeue());
		
		// Enqueues and fills in the queue with even numbers 0,2,4,...18
		for (int i = 0; i < 20; i = i + 2) {
			q.enqueue(i);
		}
		
		// Trying out the other methods in the TwoStackQueue class
		System.out.println(q.size());
		System.out.println(q.isEmpty());
		q.dequeue();
		System.out.println(q.dequeue());
		q.enqueue(1000);
		
		// Dequeues and prints everything left
		while(!q.isEmpty()) {
			System.out.println(q.dequeue());
		}
	
	}

}
