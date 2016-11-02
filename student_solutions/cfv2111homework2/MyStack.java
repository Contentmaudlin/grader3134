/* Chiara Vallini 
 * cfv2111
 * MyStack.java 
 * This generic class implements stacks methods using LinkLists basic operations
 */

import java.util.*;

// MyStack class is a generic class 
public class MyStack <AnyType>{
	// Instance variable LinkedList 
	public LinkedList <AnyType> stack;
	
	//Constructor 
	public MyStack(){
		stack = new LinkedList<AnyType>(); 
	}
	// Pop method throws an Exception if the stack is empty 
	// otherwise it removes the last element of the stack and returns it 
	public AnyType pop(){ 
		if (stack.size() == 0){
			new EmptyStackException();
		}
			
		AnyType element = stack.removeLast();
		return element; 
	}
	// Peak method throws an Exception if the stack is empty 
	// otherwise it returns the last element of the stack
	public AnyType peak(){ 
		if (stack.isEmpty()){
			new EmptyStackException();
		}
		return stack.getLast();
		
	}
	
	// empty method throws an Exception if the stack is empty 
	public Boolean empty(){
		if(stack.size() == 0){
			return true;
		}
		else{
			return false;
	    }
	}
	// push method adds a new element at the end of the stack
	public void push(AnyType element ){ 
		stack.add(element);

	}
	// size method returns the size of the stack 
	public int size (){
		return stack.size();
	}
}
