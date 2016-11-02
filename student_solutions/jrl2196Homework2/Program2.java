public class Program2 {



    /** If implemented correctly, this code should output: 
     *  0
     *  bill
     *  frank
     *  3
     *  yes
     *  apple
     *  no
     *  Theodore
     */
    public static final void main(String[] args) {


	TwoStackQueue<String> q = new TwoStackQueue<String>();
	System.out.println(q.size());

	q.enqueue("bill");
	System.out.println(q.dequeue());
	q.enqueue("frank");
	System.out.println(q.dequeue());
	q.enqueue("yes");
	q.enqueue("apple");
	q.enqueue("no");
	System.out.println(q.size());
	System.out.println(q.dequeue());
	System.out.println(q.dequeue());
	q.enqueue("Theodore");

	while(!q.isEmpty())
	    System.out.println(q.dequeue());


    }





}