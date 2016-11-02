/********************************************
* Ben Arbib - ba2490
* MyStack class acts as a stack
* where the element added in (push) goes to head
* and removing an element accures only 
* from the head (pop)
* it uses a LinkedList.
*********************************************/

import java.util.LinkedList;

public class MyStack<AnyType>{
	LinkedList<AnyType> s;

	// constructor
	public MyStack(){
		s = new LinkedList<AnyType>();
	}

	//inserts element to first position
	public void push(AnyType e){
		s.addFirst(e);
	}

	// removes and returns first element
	public AnyType pop(){
		return s.remove();
	}

	// returns, but does not remove first element
	// if it is empty, returns null
	public AnyType peek(){
		if (!isEmpty())
			return s.element();
		
		else return null; 
	}

	// indicates if the stack is empty
	public boolean isEmpty(){
		if (s.isEmpty()) return true;
		else return false;
	}

	// returns number of elements in the stack
	public int size(){
		return s.size();
	}

}