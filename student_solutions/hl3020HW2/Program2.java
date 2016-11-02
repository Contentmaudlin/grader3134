public class Program2 {



    /** If implemented correctly, this code should output: 

	 *	0
	 *	2001 Space Odyssey
	 *	3
	 *	the Matrix
	 *	3
	 *	Inception
	 *	Metropolis
	 *	Interstellar
	 *	Her
     */
    public static final void main(String[] args) {


	TwoStackQueue<String> q = new TwoStackQueue<String>();
	System.out.println(q.size());

	q.enqueue("2001 Space Odyssey");
	q.enqueue("the Matrix");
	q.enqueue("Inception");
	System.out.println(q.dequeue());
	q.enqueue("Metropolis");
	System.out.println(q.size());
	System.out.println(q.dequeue());
	q.enqueue("Interstellar");
	System.out.println(q.size());
	System.out.println(q.dequeue());
	q.enqueue("Her");

	while(!q.isEmpty())
	    System.out.println(q.dequeue());


    }





}