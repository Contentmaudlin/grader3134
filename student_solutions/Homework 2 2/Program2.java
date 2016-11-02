public class Program2 {



    /** If implemented correctly, this code should output: 
     *  0
     *  Jake
     *  2
     *  Q
     *  Carlos
     *  zzz
     *  test
     *  bored
     */
    public static final void main(String[] args) {


	TwoStackQueue<String> q = new TwoStackQueue<String>();
	System.out.println(q.size());

	q.enqueue(“Jake”);
	q.enqueue(“Q”);
	q.enqueue(“Carlos”);
	System.out.println(q.dequeue());
	System.out.println(q.size());
	q.enqueue(“zzz”);
	q.enqueue(“test”);
	System.out.println(q.dequeue());
	q.enqueue(“bored”);

	while(!q.isEmpty())
	    System.out.println(q.dequeue());


    }





}