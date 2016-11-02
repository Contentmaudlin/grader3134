public class Problem2 {
	/** This code should output: 
     *  0
     *  4
     *  Jessica
     *  4
     *  Sharon
     *  Moriah
     *  Brenda
     *  Emily
     *  Jessica
     *  0
     */
	public static final void main(String[] args)
	{
		
		TwoStackQueue<String> q = new TwoStackQueue<String>();
		System.out.println(q.size());
		
		q.enqueue("Jessica");
		q.enqueue("Sharon");
		q.enqueue("Moriah");
		q.enqueue("Brenda");
		System.out.println(q.size());
		System.out.println(q.dequeue());
		q.enqueue("Emily");
		System.out.println(q.size());
		q.enqueue("Jessica");
		
		while(!q.isEmpty())
		{
		    System.out.println(q.dequeue());
		}
		
		System.out.println(q.size());
		
	}
}