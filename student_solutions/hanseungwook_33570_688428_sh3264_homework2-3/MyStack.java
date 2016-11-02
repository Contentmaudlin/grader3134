
/* Author: Seungwook Han
 * UNI: sh3264
 * Data Structures
 * MyStack - This is the class that defines the Stack class 
 * to be used for the SymbolBalance and TwoStackQueue classes
 */

import java.util.*;

public class MyStack<AnyType> {

	// MyStack implements the LinkedList generic for the stack 
	private LinkedList<AnyType> stack;

	// This constructor creates a new LinkedList to be used as the stack
	public MyStack() {
		stack = new LinkedList<>();

	}

	/* This method checks whether the stack is empty by
	 * checking if the size of the stack is 0 or not
	 * @return boolean, true if the stack is empty
	 * false if the stack is not empty
	 */
	public boolean isEmpty() {
		if (stack.size() == 0) {
			return true;
		} else {
			return false;
		}
	}

	/* This method adds the generic object into the first
	 * element of the stack
	 * @param item is an object of AnyType generic
	 */
	public void push(AnyType item) {
		stack.addFirst(item);
	}

	/* This method removes the first element of the stack
	 * if the size of the stack is greater than 0
	 * If the stack is empty (size 0), it returns null
	 * @return the first element of the stack that is being
	 * removed will be returned unless the stack is empty which
	 * will return null
	 */ 
	public AnyType pop() {
		if (stack.size() > 0) {
			return stack.removeFirst();
		} else {
			return null;
		}

	}

	// This method returns the size of the stack
	// @return int, size of the stack
	public int size() {
		return stack.size();
	}

}
