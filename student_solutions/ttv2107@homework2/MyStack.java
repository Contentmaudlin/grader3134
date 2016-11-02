/* Trung Vu
 * UNI: ttv2107 
 * COMS W3134
 * Instructor: Professor Blaer
 * Homework 2
 * October 7th, 2016
 */

/* This is an implementation of the stack abstract data type
 * using a Java LinkedList class. The first item of the linked list
 * is considered the "top" of the stack. Therefore, items are pushed,
 * popped, and peeked at the beginning of the linked list.
 */

import java.util.LinkedList;

public class MyStack<T> {
	private LinkedList<T> theStack;
	
	public MyStack() {
		theStack = new LinkedList<T>();
	}


	public void push(T x) {
		theStack.addFirst(x); //Add the item to the beginning
	}

	public T pop() {
            if (empty()) {
                return null;
            }
            return theStack.remove(); //Pop the item from the beginning 
        }

	public T peek() {
		return theStack.getFirst();//Return the top item without popping
	}

	public int size() {
		return theStack.size(); //Return the size
	}
    
    public boolean empty() {
        return (size() == 0);
    }
}
