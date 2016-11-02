/* Christophe Rimann
 * cjr2185
 * Program2.java
 * A class to test TwoStackQueue.java by enqueueing and dequeueing 
 * the TwoStackQueue.
 */
public class Program2 {
	public static void main(String[] args){
		TwoStackQueue<String> q = new TwoStackQueue<String>();
		System.out.println(q.size());
		//Enqueue some stuff first
		q.enqueue("Hi");
		q.enqueue("TEST");
		q.enqueue("next");
		q.enqueue("word");
		q.enqueue("here");
		
		//Test a dequeue
		System.out.println(q.dequeue());
		
		//Then enqueue
		q.enqueue("Second test");
		
		//Commence dequeueing:
		System.out.println(q.dequeue());
		System.out.println(q.size());
		System.out.println(q.dequeue());
		System.out.println(q.size());
		while(!q.isEmpty()){
			System.out.println(q.dequeue());
		}
		System.out.println(q.size());
	}
}
