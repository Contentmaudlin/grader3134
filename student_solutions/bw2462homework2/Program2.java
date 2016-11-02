/* Boya Wang
 * bw2462
 * Program2.java
 */

/** If implemented correctly, this code should output: 
     *  0
     *  1
     *  3
     *  2
     *  False
     *  7
     *  11
     *  19
     *  55
     */
public class Program2 {
	public static final void main(String[] args) {


		TwoStackQueue<Integer> tester = new TwoStackQueue<Integer>();
		System.out.println(tester.size());

		tester.enqueue(1);
		tester.enqueue(3);
		tester.enqueue(7);
		tester.enqueue(11);
		System.out.println(tester.dequeue());
		System.out.println(tester.dequeue());
        System.out.println(tester.size());
		System.out.println(tester.isEmpty());
		tester.enqueue(19);
		System.out.println(tester.dequeue());
		System.out.println(tester.dequeue());
		System.out.println(tester.dequeue());
		tester.enqueue(55);

		while(!tester.isEmpty())
		    System.out.println(tester.dequeue());


	    
	    
	}

}