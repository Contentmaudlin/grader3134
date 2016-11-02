
/***************************************
/ MyStack.java
/ By Sungmin An (UNI: sa3333) 
/ To implement the Stack ADT
***************************************/

import java.util.LinkedList;

public class MyStack<AnyType>{
	
	/* Instance variable. */
	private LinkedList<AnyType> list;

	/* Constructor initializes IV */
	public MyStack(){
		list = new LinkedList<AnyType>(); 
	}	

	/* Puts element into top of the stack. 
	   @param AnyType item. @return AnyType item.
	*/
	public AnyType push(AnyType item){
		list.addLast(item); 
		return item; 
	}

	/* Returns and removes item on top of the stack.
	   @return AnyType lastItem. 
	*/
	public AnyType pop(){
		AnyType lastItem = list.getLast(); 
		list.removeLast(); 
		return lastItem; 
	}

	/* Returns the last item on top of the stack without
	   removing it. @return AnyType list.getLast().
	*/
	public AnyType peek(){
		return list.getLast();
	}

	/* Checks to see if the stack is empty. 
	   @return boolean list.peek() == null.
	*/
	public boolean empty(){
		return list.size() == 0;
	}

}