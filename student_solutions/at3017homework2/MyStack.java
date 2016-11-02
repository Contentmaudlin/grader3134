/**
 * Akbota Toxanbayeva
 * at3017
 */

import java.util.ArrayList;

public class MyStack<T> {
	private ArrayList<T> stack = new ArrayList<>();
	
	public boolean isEmpty() {
		return stack.size() == 0;
	}
	
	public void push(T o){
		// Debugging
		// System.out.println("pushing " + o.toString());
		stack.add(o);
	}
	
	public T pop(){
		if(stack.size() < 1){
			throw new IndexOutOfBoundsException("Stack is empty");
		}
		
		T popped = stack.remove(stack.size() - 1);
		
		// Debugging
		// System.out.println("popping " + popped.toString());
		
		return popped;
	}
	
	public T peek(){
		if(stack.size() < 1){
			throw new IndexOutOfBoundsException("Stack is empty");
		}
		return stack.get(stack.size() - 1);
	}
	
	public int size() {
		return stack.size();
	}
}
