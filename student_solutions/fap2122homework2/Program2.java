//Fernando A. Pascual
//fap2122
//Data Structures HW2

public class Program2
{
	public static void main(String[] args)
	{
		TwoStackQueue<Integer> q = new TwoStackQueue<Integer>();
		System.out.println(q.size());

		q.enqueue(1);
		q.enqueue(3);
		q.enqueue(65);

		System.out.println(q.size());

		System.out.println(q.dequeue());

		System.out.println(q.size());

		q.enqueue(100);

		while(!q.isEmpty())
	    	System.out.println(q.dequeue());

	}
}
