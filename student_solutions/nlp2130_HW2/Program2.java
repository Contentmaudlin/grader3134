/* Data Structures Fall 2016
 * Homework 2
 * This tester class conducts queue operations on a queue made of two stacks. 
 * @author Natasha Porter
 */

package homework2;

public class Program2 {

	public static final void main(String[] args){

		TwoStackQueue<String> q = new TwoStackQueue<>();
		System.out.println(q.size());
		
		q.enqueue("Milena");
		q.enqueue("Alex");
		q.enqueue("Darius");
		System.out.println(q.dequeue());
		System.out.println(q.size());
		q.enqueue("Pa");
		q.enqueue("Bridget");
		System.out.println(q.dequeue());
		q.enqueue("Natasha");
		q.enqueue("Eve");
		System.out.println(q.dequeue());
		System.out.println(q.size());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());

		System.out.println(q.size());
		
		while(!q.isEmpty())
			System.out.println(q.dequeue());
	}
}


