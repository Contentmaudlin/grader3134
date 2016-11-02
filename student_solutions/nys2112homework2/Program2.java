//Natalie Sayegh
//October 10
//Programming 2
//Instantiates a Character TwoStackQueue and tests methods

/* Correct output:
 * null
 * 3
 * x
 * l
 * 2
 * k
 * 1
 * a
 * 0
 */

public class Program2 {
	public static void main(String[] args) {
		TwoStackQueue<Character> t = new TwoStackQueue<>();
		System.out.println(t.dequeue());
		t.enqueue('x');
		t.enqueue('l');
		t.enqueue('k');
		System.out.println(t.size());
		System.out.println(t.dequeue());
		t.enqueue('a');
		while(!(t.isEmpty())) {
			System.out.println(t.dequeue());
			System.out.println(t.size());
		}		
	}
}

