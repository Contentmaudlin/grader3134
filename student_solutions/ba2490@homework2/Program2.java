/*****************************
* Problem2.java 
* Ben Arbib - ba2490
* This progrem is a tester for 
* the TwoStackQueue class.
* it implements two queues - 
* String and Integer.
******************************
*/

public class Program2{

	public static void main (String[] args){

	TwoStackQueue<String> q = new TwoStackQueue<String>();
	TwoStackQueue<Integer> q2 = new TwoStackQueue<Integer>();

	System.out.println(q.size());
	System.out.println(q2.size());

	q.enqueue("Hello");
	q.enqueue("Shalom");
	q.enqueue("Salam");
	System.out.println(q.size());
	q.enqueue("Nehau");
	q.enqueue("Hola");
	System.out.println(q.dequeue());
	System.out.println(q.dequeue());
	q.enqueue("Bonjour");

	while(!q.isEmpty())
	    System.out.println(q.dequeue());

	q.dequeue();
	q.dequeue();

	q2.enqueue(72);
	q2.enqueue(10);
	q2.enqueue(5);
	
	q2.enqueue(45);
	q2.enqueue(45);
	System.out.println(q2.dequeue());
	System.out.println(q2.dequeue());
	q2.enqueue(55);

	System.out.println(q2.size());
	while(!q2.isEmpty())
	    System.out.println(q2.dequeue());

	
	q2.dequeue();
	q2.dequeue();
	q2.dequeue();
	q2.dequeue();
	q2.dequeue();
	q2.dequeue();
	q2.dequeue();
	q2.dequeue();


	}
}