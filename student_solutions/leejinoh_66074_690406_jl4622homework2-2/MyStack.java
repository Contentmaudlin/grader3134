
/* Written by Jinoh Lee (jl4622), Homework 2, Programming Problem 1
 * This class is a stack class
 */
import java.util.LinkedList;

public class MyStack<AnyType> {

	public LinkedList<AnyType> stack;

	// Creates MyStack object
	public MyStack() {
		stack = new LinkedList<AnyType>();
	}

	// Inserts a value at the top
	public void push(AnyType a) {
		stack.add(a);
	}

	// Removes top value and returns it
	public AnyType pop() {
		if (stack.size() > 0) { // Checks if there's anything to pop
			AnyType temp = stack.get(stack.size() - 1); //index is size - 1 because starts at 0
			stack.remove(stack.size() - 1); 
			return temp; 
		} else {
			throw new NullPointerException("Nothing to Pop!");
		}
	}
	
	//gives number of elements in stack
	public int size() { 
		return stack.size(); 
	}

	//retrieves value at index
	public AnyType get(int i) {
		return stack.get(i);
	}

}
