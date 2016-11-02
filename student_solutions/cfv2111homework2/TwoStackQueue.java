/* Chiara Vallini 
 * cfv2111
 * TwoStackQueue.java 
 * This class implements the MyQueue interface to build a queue of two separate stacks, S1 and S2
 */

import java.util.*;


// Generic class 
public class TwoStackQueue<AnyType> implements MyQueue<AnyType>{
	
	
	// Create two stacks objects using the MyStack class 
	private MyStack<AnyType> s1;
    private MyStack<AnyType> s2;
    
    // Constructor
    public TwoStackQueue(){
    	s1  = new MyStack<AnyType>();
    	s2 = new MyStack<AnyType>();
    	
    }
    
    // Enqueue method pushes a new element into stack 1 
    public void enqueue(AnyType element) {
        s1.push(element);
    }
    // Dequeue method pushes a new element into stack 1 
    public AnyType dequeue() {
    	if (isEmpty()){
    		throw new NoSuchElementException ();
    	}
    	if (s2.empty()){
    		shiftElements();
    	}
    	return s2.pop();
    } 
    
    //Shift all elements from stack one to stack two until stack 1 is empty
    public void shiftElements(){
    	while (s1.empty() == false){
    		s2.push(s1.pop());
    	}
    }		
    

    // Checks if the Queue is empty
    public boolean isEmpty(){
    	return s1.empty() && s2.empty();
    }

    // Returns the number of elements currently in the queue
    public int size(){
    	return s1.size() + s2.size();
    }
    
}
