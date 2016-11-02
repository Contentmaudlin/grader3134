//Name: Yiwei Lian
//UNI: yl3434
//Date: 10/10
//Assignment: HW2

public class Problem2 {
	public static final void main(String[] args) {


		TwoStackQueue<String> q = new TwoStackQueue<String>();
		System.out.println(q.size());

		q.enqueue("Marie");
		q.enqueue("Tom");
		System.out.println(q.dequeue());
		q.enqueue("Mary");
		System.out.println(q.dequeue());
		System.out.println(q.size());
		q.enqueue("Lemon");
		q.enqueue("Apple");
		System.out.println(q.dequeue());
		q.enqueue("Happy");

		while(!q.isEmpty())
		    System.out.println(q.dequeue());


	    }

}
