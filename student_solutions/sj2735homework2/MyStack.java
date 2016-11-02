/* Sejal Jain
 * sj2735 
 * MyStack.java - implementation of a stack */

import java.util.LinkedList;

public class MyStack<AnyType> implements Stack<AnyType> {
	// defines the implementation of a stack
	public LinkedList<AnyType> s;
	
	public MyStack() {
		s = new LinkedList<AnyType>();
	}
	// add element x to top of stack
	public void push(AnyType x) {
		s.add(s.size(), x);
	}
	
	// delete top element of stack
	public AnyType pop() {
		return s.remove(s.size() - 1);
	}
	
	// return top element of stack
	public AnyType top() {
		return s.get(s.size() - 1);
	}
	public int size() {
		return s.size();
	}
	
}
