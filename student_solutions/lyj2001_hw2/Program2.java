/******************************************************************************
 * By: Lydia Jiang
 * Class: Program2
 * Tester with main method for TwoStackQueue
 ******************************************************************************/

public class Program2 {


    /** If implemented correctly, this code should output: 
     *  0
     *  Error: nothing to dequeue!
     *  Mary
     *  2
     *  had
     *  a
     *  little
     *  lamb
     *  blah
     *  blah blah
     *  blah blah blah
     *  0
     */
    public static final void main(String[] args) {


	TwoStackQueue<String> q = new TwoStackQueue<String>();
	
	
	q.dequeue();
	System.out.println(q.size());
	q.enqueue("Mary");
	q.enqueue("had");
	q.enqueue("a");
	System.out.println(q.dequeue());
	q.enqueue("little");
	q.enqueue("lamb");
	System.out.println(q.dequeue());
	q.enqueue("blah");
	q.enqueue("blah blah");
	q.enqueue("blah blah blah");
	while(!q.isEmpty())
	    System.out.println(q.dequeue());

	System.out.println(q.size());
    }
    





}
