public class Program2 {

    public static final void main(String[] args) {


	TwoStackQueue<Integer> q = new TwoStackQueue<Integer>();
	System.out.println(q.size());

	q.enqueue(1);
	q.enqueue(2);
	q.enqueue(3);
	System.out.println(q.dequeue());
	System.out.println(q.size());
	q.enqueue(4);
	q.enqueue(5);
	System.out.println(q.dequeue());
	q.enqueue(6);

	while(!q.isEmpty())
	    System.out.println(q.dequeue());


    }





}