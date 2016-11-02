public class Program2 {



    /** If implemented correctly, this code should output: 
     *  true
     *  1
     *  3
     *  a
     *  b
     *  c
     *  3
     *  d
     *  e
     *  f
     */
    public static final void main(String[] args) {


	TwoStackQueue<String> q = new TwoStackQueue<String>();
	System.out.println(q.isEmpty());
	q.enqueue("a");
	System.out.println(q.size());
	q.enqueue("b");
	q.enqueue("c");
	System.out.println(q.size());
	System.out.println(q.dequeue());
	System.out.println(q.dequeue());
	q.enqueue("d");
	q.enqueue("e");
	System.out.println(q.dequeue());
	q.enqueue("f");
	System.out.println(q.size());

	while(!q.isEmpty())
	    System.out.println(q.dequeue());


    }


}