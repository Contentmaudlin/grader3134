package drs2176_HW2;
import drs2176_HW2.MyQueue.TwoStackQueue;
/*********************************************
 * author: Dan Sendik
 * Uni: drs2176
 * class: Data Strucures
 * HW submission: 2
 ********************************************/
public class Program2 {
	public static final void main(String[] args) {


		TwoStackQueue<String> q = new TwoStackQueue<String>();
		System.out.println(q.size());

		q.enqueue("Rick");
		System.out.println(q.dequeue());
		System.out.println(q.size());
		q.enqueue("Michonne");
		q.enqueue("Coral");
		System.out.println(q.dequeue());
		q.enqueue("Daryl");
		q.enqueue("Merle");
		q.enqueue("Lori");
		q.enqueue("Shane");
		q.enqueue("Hershel");
		q.enqueue("Maggie");
		q.enqueue("The Governor");
		q.enqueue("Carol");
		q.enqueue("Negan");
		q.enqueue("Glenn");
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		if (q.isEmpty()) {
			System.out.println("Queue is empty.");
		}
		else {
			System.out.println("Queue is not empty.");
		}
		System.out.println(q.dequeue());
		if (q.isEmpty()) {
			System.out.println("Queue is empty.");
		}
		else {
			System.out.println("Queue is not empty.");
		}
		
		
		while(!q.isEmpty())
		    System.out.println(q.dequeue());

	    }
}