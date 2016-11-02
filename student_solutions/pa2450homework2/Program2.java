/*
 * Name: Pranav Arora
 * UNI: pa2450
 * Description: Tester class for TwoStackQueue
 * 
 */

public class Program2 {

	public static void main(String[] args) {
		
		TwoStackQueue<Integer> myQueue = new TwoStackQueue<>();
		
		for (int i = 1; i <= 10; i++){
			myQueue.enqueue(i);
		}
		
		myQueue.dequeue(); // removing 1
		myQueue.dequeue(); // removing 2
		
		while (!myQueue.isEmpty()){
			System.out.print(myQueue.dequeue() + " ");
		}
		
		System.out.print(myQueue.dequeue() + " ");
		
	}

}
