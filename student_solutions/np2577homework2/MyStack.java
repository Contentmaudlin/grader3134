/* Nishant Puri
 * np2577
 * HW2
 * MyStack.java Implements Stack using an instance of Linked List
 */

import java.util.LinkedList;

public class MyStack<AnyType> {
	private LinkedList<AnyType> Stack;
	
    public MyStack( )
    {
    	Stack = new LinkedList<AnyType>();
    }

    // adds element to start of the linked list
	public void push(AnyType x){
		Stack.add(0,x);
	}
	
	// removes first element of linked list
	public AnyType pop(){
		AnyType x = Stack.get(0);
		Stack.remove(0);
		return x;
	}
	
	//looks at first element of linked list
	public AnyType peek(){
		return Stack.get(0);
	}
	
	public boolean isEmpty(){
		return Stack.isEmpty();
	}
	
	public int size(){
		return Stack.size();
	}
}
