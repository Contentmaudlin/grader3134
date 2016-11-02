//Homework2 - Problem1
//Kehan Lu - kl2858

import java.util.LinkedList;

public class MyStack<AnyType> {
	private LinkedList<AnyType> myStack;
	private int s=0;
	
	public MyStack() {
		myStack=new LinkedList<AnyType>();
	}
	
	public boolean empty() {
		return myStack.isEmpty();
	}
	public void push(AnyType a) {
		myStack.addFirst(a);
		s++;
		
	}
	
	public AnyType pop() {
		if (!empty()){
			s--;
			return myStack.removeFirst();
		}
		else
			return null;
	}
	
	public AnyType peek() {
		if (!myStack.isEmpty())
			return myStack.getFirst();
		else
			return null;
	}
	
	public int size(){
		return s;
	}

}
