///* Nishant Puri
// * np2577
// * HW2
// * Program2.java
// */

public class Program2 {

	/**
	 * If implemented correctly, this code should output:
	 * 	0
	 * true
	 * Error: Can't dequeue because queue is empty
	 * 1
	 * false
	 * Giggs
	 * Scholes
	 * 2
	 * Keane
	 * 1
	 * DeGea
	 * Ronaldo
	 * Berbatov
	 */
	public static final void main(String[] args) {

		TwoStackQueue<String> q = new TwoStackQueue<String>();
		System.out.println(q.size());
		System.out.println(q.isEmpty());
		q.dequeue();
		q.enqueue("Giggs");
		System.out.println(q.size());
		System.out.println(q.isEmpty());
		System.out.println(q.dequeue());
		q.enqueue("Scholes");
		q.enqueue("Keane");
		q.enqueue("DeGea");
		System.out.println(q.dequeue());
		System.out.println(q.size());
		System.out.println(q.dequeue());
		System.out.println(q.size());
		q.enqueue("Ronaldo");
		System.out.println(q.dequeue());
		q.enqueue("Berbatov");

		while (!q.isEmpty())
			System.out.println(q.dequeue());

	}
}
