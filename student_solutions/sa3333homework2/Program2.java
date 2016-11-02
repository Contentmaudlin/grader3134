/************************************
/ Problem2.java
/ By Sungmin An (UNI: sa3333)
/ Tester class for TwoStackQueue.java
************************************/

public class Program2{

	public static void main(String[] args){

		TwoStackQueue<Character> queue = new TwoStackQueue<>();

		/* Tests whether dequeing an empty queue returns null. */
		System.out.println(queue.dequeue()); 

		queue.enqueue('C');
		queue.enqueue('O');

		/* Expected result is 2 */ 
		System.out.println(queue.size());

		queue.enqueue('M');
		queue.enqueue('E');

		/* Expected result is 4 */
		System.out.println(queue.size());

		/* Expected result is C */
		System.out.println(queue.dequeue());
		/* Expected result is O */ 
		System.out.println(queue.dequeue());

		/* Expected result is 2 */
		System.out.println(queue.size());


		/* Tests isEmpty(). */
		if (queue.isEmpty()){
			System.out.println("Your queue is empty brah");
		}
		else{
			System.out.println("Your queue is not empty brah");
			System.out.println("Brah, you still got " + queue.size()
				+ " elements in yo queue, brah.");
		}
	}
}