/* this is my tester class, using Integers */
public class Program2 {

	public static void main(String[] args) {

		TwoStackQueue myQueue = new TwoStackQueue<Integer>();

		// adding values to queue
		myQueue.enqueue(5);
		myQueue.enqueue(7);
		myQueue.enqueue(10);
		myQueue.enqueue(234);
		myQueue.enqueue(34);
		myQueue.enqueue(4);
		myQueue.enqueue(634);

		// dequeueing and printing... should be ordered 5 7 10 234
		System.out.println(myQueue.dequeue());
		System.out.println(myQueue.dequeue());
		System.out.println(myQueue.dequeue());
		System.out.println(myQueue.dequeue());
		System.out.println(myQueue.size()); // should be 3, three elments left
	}

}