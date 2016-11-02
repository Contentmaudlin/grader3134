public class Program2 {
	
	public static void main(String[] args)  {
		boolean empty;
		Integer out = 0;
		TwoStackQueue<Integer> queue = new TwoStackQueue<Integer>();

		//Testing isEmpty
		empty = queue.isEmpty();
		System.out.println("isEmpty should now return true. isEmpty returns: " + empty);
		System.out.println();

		//Testing Enqueue + Dequeue
		System.out.println("Testing Enqueue by adding elements 2,5,4,7 in that order:");
		queue.enqueue(2);
		queue.enqueue(5);
		queue.enqueue(4);
		queue.enqueue(7);
		out = queue.dequeue();
		System.out.println("Dequeue should return 2. Dequeue now returns: " + out);
		System.out.println();

		//Testing size;
		out = queue.size();
		System.out.println("Size should now return 3. Size returns: " + out);
		System.out.println();

		//Testing Enquque + Dequque
		System.out.println("Adding elements 1,3 in that order:");
		queue.enqueue(1);
		queue.enqueue(3);
		out = queue.dequeue();
		System.out.println("Dequeue should return 5. Dequeue now returns: " + out);
		System.out.println();

		//Testing size
		out = queue.size();
		System.out.println("Size should now return 4. Size returns: " + out);
		System.out.println();

		//Testing isEmpty
		empty = queue.isEmpty();
		System.out.println("isEmpty should now return false. isEmpty returns: " + empty);
	}
}