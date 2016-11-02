public class Program2{
	
    /** This code should output: 
     *  0
     *  1
     *  2
     *  2
     *  3
     *  4
     *  5
     *  6
     */
    public static final void main(String[] args) {

		TwoStackQueue<Integer> q = new TwoStackQueue<Integer>();
		System.out.println(q.size());

		q.enqueue(1);
		q.enqueue(2);
		System.out.println(q.dequeue());
		q.enqueue(3);
		System.out.println(q.size());
		q.enqueue(4);
		q.enqueue(5);
		System.out.println(q.dequeue());
		q.enqueue(6);

		while(!q.isEmpty())
		    System.out.println(q.dequeue());


    }

}