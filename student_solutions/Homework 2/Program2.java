//*****************************************************************************
//
// Name - Ishaan Kishore Agrawal
// UNI - ia2341
// Date - 8th October, 2016
//
// Problem2 Class
//
// This class contains the constructor for the queue object which consists of 2 
// stacks
//
//*****************************************************************************

// begin class
public class Program2 {
	
	// begin main method
	public static void main(String[] args) {
		
		// create a new queue of Integers
		TwoStackQueue<Integer> queue = new TwoStackQueue<Integer>();
		
		// intialize an array as list
		int[] list = new int[] {-100, -10, 0, 10, 100};
		
		// Print out all the elements in order of enqueue
		System.out.println("The elements that enter the queue first are in the "
				+ "following order:");
		
		for (int i = 0; i < list.length; i ++) {
			System.out.println(list[i]);
			queue.enqueue(list[i]);
		}
		
		// print out all the elements in order of dequeue
		System.out.println();
		System.out.println("The elements that are dequeued from the queue first"
				+ " are in the following order:");
		
		while (!queue.isEmpty()) {
			System.out.println(queue.dequeue());
		}
		
		System.out.println();
		System.out.println("Now we will add some elements and dequeue them "
				+ "intermittently");
		
		/* The output must be:
		 * 2
		 * 100
		 * 2
		 * false
		 * 1000
		 * 1
		 * 10
		 */
		queue.enqueue(100);
		queue.enqueue(1000);
		System.out.println(queue.size());
		System.out.println(queue.dequeue());
		queue.enqueue(1);
		System.out.println(queue.size());
		System.out.println(queue.isEmpty());
		queue.enqueue(10);
		
		while (!queue.isEmpty()) {
			System.out.println(queue.dequeue());
		}
	}
	// end main method

}
// end class
