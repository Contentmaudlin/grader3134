// Written by Jinoh Lee (jl4622), Homework 2, Programming Problem 2
// This is a tester class for the TwoStackQueue class
public class Problem2 {

	public static final void main(String[] args) {

		TwoStackQueue<String> a = new TwoStackQueue<String>();

		a.enqueue("Never");
		a.enqueue("Gonna");
		a.enqueue("Give");
		a.enqueue("You");
		a.enqueue("Up");
		a.enqueue("by");
		a.enqueue("Rick");
		a.enqueue("Astley");

		System.out.println(a.size()); // Should print 8
		System.out.println(a.dequeue()); // Should print "Never"
		System.out.println(a.dequeue()); // Should print "Gonna"
		System.out.println(a.dequeue()); // Should print "Give"
		System.out.println(a.dequeue()); // Should print "You"
		System.out.println(a.dequeue()); // Should print "Up"

		a.dequeue();
		System.out.println(a.size()); // Should print 2
		
		// Following taken from Paul Blaer/Courseworks
		while (!a.isEmpty()) { // Should print "Rick" and "Astley"
			System.out.println(a.dequeue());
		}
	}
}
