/* Tianwu Wang
 * tw2576
 * Program2.java
 * Tester of TwoStackQueue
 * should output:
 * 0 a 1 b 2 c d e 0 
 */

public class Program2 {
	public static final void main(String[] args) {
		TwoStackQueue<String> q = new TwoStackQueue<String>();
		System.out.println(q.size());              //initial size 0
		q.enqueue("a"); 	                      
		q.enqueue("b"); 
		System.out.println(q.dequeue());           // dequeue a
		System.out.println(q.size()); 
		q.enqueue("c"); 
		q.enqueue("d"); 
		System.out.println(q.dequeue());            // dequeue b
		System.out.println(q.size()); 
		q.enqueue("e");
		while(q.isEmpty() == false){                //dequeue all elements
			System.out.println(q.dequeue());
		}
		System.out.println(q.size()); 				//size is 0 again
	}
}