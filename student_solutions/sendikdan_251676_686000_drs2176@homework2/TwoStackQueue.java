package drs2176_HW2;
/*********************************************
 * author: Dan Sendik
 * Uni: drs2176
 * class: Data Strucures
 * HW submission: 2
 ********************************************/
public class TwoStackQueue implements MyQueue<Object> {
	   
	   public TwoStackQueue() {

	   }
	   
	   public static final void main(String[] args) {


				TwoStackQueue<String> q = new TwoStackQueue<String>();
				System.out.println(q.size());

				q.enqueue("Peter");
				q.enqueue("Paul");
				q.enqueue("Mary");
				System.out.println(q.dequeue());
				System.out.println(q.size());
				q.enqueue("Simon");
				q.enqueue("Alvin");
				System.out.println(q.dequeue());
				q.enqueue("Theodore");

				while(!q.isEmpty())
				    System.out.println(q.dequeue());


			    }
}
