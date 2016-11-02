
public class Program2 {
	/** If implemented correctly, this code should output: 
	 *  0
	 *  Peter
	 *  2
	 *  Paul
	 *  Mary
	 *  Simon
	 *  Alvin
	 *  Theodore
	 */
	public static final void main(String[] args) {
		TwoStackQueue<Character> q = new TwoStackQueue<Character>();
		System.out.println("test case 1:");
		System.out.println("the original size is: " +q.size());
		
		System.out.println("enqueue a b c d e");
		q.enqueue('a');
		q.enqueue('b');
		q.enqueue('c');
		q.enqueue('d');
		q.enqueue('e');
		System.out.println("the new size is: " + q.size());
		System.out.println("dequeue 4 times");
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		
		System.out.println("the new size: " + q.size());
		System.out.println("enqueue a b");
		q.enqueue('a');
		q.enqueue('b');
		System.out.println("dequeue all ");

		while(!q.isEmpty())
			System.out.println(q.dequeue());
	}
}
