/*
      Loie Plautz
      lmp2180
      Homework 2
*/

public class Program2
{
	public static void main(String[] args)
	{
		TwoStackQueue<Integer> q = new TwoStackQueue<Integer>();
		q.enqueue(1); //first in 
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);
		System.out.println("The size is: " + q.size());
		System.out.println(q.dequeue()); //should be 1
		System.out.println(q.dequeue()); //should be 2
		System.out.println(q.dequeue()); //should be 3
		System.out.println(q.dequeue()); //should be 4
		System.out.println(q.dequeue()); //should be 5
	}
}