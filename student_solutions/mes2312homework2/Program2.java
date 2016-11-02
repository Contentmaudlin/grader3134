public class Program2 {

    /** this should output
     *  0
     * 	3
     * 	4
     * 	5
     */
    public static final void main(String[] args) {


	TwoStackQueue<Integer> q = new TwoStackQueue<Integer>();
	System.out.println(q.size());

	q.enqueue(1);
	q.enqueue(2);
	q.enqueue(3);
	q.dequeue();
	q.enqueue(4);
	q.dequeue();
	q.enqueue(5);

	while(!q.isEmpty())
	    System.out.println(q.dequeue());
    }
}