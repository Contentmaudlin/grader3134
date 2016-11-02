//Tester class for TwoStackQueue.java 
//made by Or Aboodi, oda2102, for problem 2 hw 2 data structures fall 2016


public class Problem2 {

    public static void main(String[] args) {

	TwoStackQueue<Character> testing = new TwoStackQueue<Character>();

	System.out.println(testing.isEmpty());
	
	testing.enqueue('a');
	testing.enqueue('l');
	testing.enqueue('b');
	testing.enqueue('u');
	testing.enqueue('s');
	
	System.out.println();
	
	System.out.print(testing.dequeue());
	System.out.print(testing.dequeue());
	System.out.print(testing.dequeue());
	System.out.print(testing.dequeue());
	System.out.print(testing.dequeue());

	System.out.println();
	System.out.println(testing.dequeue());
	
	testing.enqueue('a');
	testing.enqueue('l');
	testing.enqueue('b');
	testing.enqueue('u');
	testing.enqueue('s');
	System.out.println(testing.size());
	
/*This code should print: 
 true
 
 albus
 null
 5
 */
    }
}