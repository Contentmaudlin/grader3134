public class Problem2 {
	 /** If implemented correctly, this code should output:
     *  0
     *  Apple
     *  3
     *  Orange
     *  Banana
     *  3
     *  Watermelon
     *  2
     *  Pear
     *  1
     *  Berry
     *  0
     */
    public static final void main(String[] args) {


	MyQueue<String> q = new MyQueue<String>();
	System.out.println(q.size());

	q.enqueue("Apple");
	q.enqueue("Orange");
	System.out.println(q.size());
	System.out.println(q.dequeue());
	q.enqueue("Banana");
	q.enqueue("Watermelon");
	System.out.println(q.size());
	q.enqueue("pear");
	System.out.println(q.dequeue());
	q.enqueue("Berry");

	while(!q.isEmpty()){
	    System.out.println(q.dequeue());
	    System.out.println(q.size());
	}

/*/**/
    }

}
