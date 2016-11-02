/* Natasha Porter 
 * nlp2130
 * Data Structures Fall 2016
 * This class creates 2 generic stacks and includes queue operations using stack methods. 
 */
package homework2;
import java.util.Stack;

public class TwoStackQueue<E> {


	private Stack<E> S1 = new Stack<E>();
	private Stack<E> S2 = new Stack<E>();

	public void enqueue(E item){ //push item onto Stack 1
		S1.push(item);
	}

	public E dequeue() { //pop the elements from Stack 1 and push them onto stack 2
		if (S2.isEmpty()) 
			while(!S1.isEmpty())
				S2.push(S1.pop());
		return S2.pop(); //pop elements from Stack 2
		}
	
	
	public boolean isEmpty(){ //check if the stack is empty 
		if(S1.isEmpty() && S2.isEmpty())
			return true;
		else
			return false;
	}

	public int size(){ //returns the size of the queue
		return S2.size();
	}
}
