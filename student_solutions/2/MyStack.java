//a stack class by Or Aboodi, oda2102, for problem 1 homework 2
//used in SymbolBalance.java

import java.util.LinkedList;

public class MyStack <AnyType> {
	
	private LinkedList<AnyType> stack; //used as the stack
	
	public MyStack () {
		stack = new LinkedList<AnyType>();
	}
	
	public AnyType pop() {
		AnyType itemPopped = stack.get(0);
		stack.remove(0); //remove the object
		return itemPopped;
	}
	
	public void push(AnyType x){
		stack.add(0,x);
	}

	public AnyType peek(){
		return stack.get(0);
	}
	
	public int size() {
		return stack.size();
	}
	
}