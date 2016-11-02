//Natalie Sayegh
//October 10
//Programming 1
//Generic linked list implementation of stack

import java.util.LinkedList;

public class MyStack<AnyType> {
	private LinkedList<AnyType> list;
	
	public MyStack() {
		list = new LinkedList<>(); //constructs an empty list
	}
	
	public void push(AnyType x) {
		list.addFirst(x);
	}
	
	public AnyType pop() {
		return list.removeFirst();
	}
	
	public AnyType peek() { 
		return list.getFirst();
	}
	
	public boolean isEmpty() {
		return list.size() == 0;
	}
	
	public int size() {
		return list.size();
	}
	
}

