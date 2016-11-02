/*Ziyi Sun
 *zs2293
 */

import java.util.LinkedList;

public class MyStack<E> {
	
	LinkedList<E> stack = new LinkedList<E>();
	
	//returns true if stack is empty
	public boolean isEmpty(){
		return stack.size() == 0;
	}
	
	//pushes new item x on top of stack
	public void push (E x){
		stack.addLast(x);
	}
	
	//returns the top of the stack and removes it
	public E pop(){
		return stack.removeLast();
	}
	
	//returns the top of the stack and doesn't remove it
	public E peek(){
		return stack.getLast();
	}
	
	//returns size of stack
	public int size(){
		return stack.size();
	}	
	
}
