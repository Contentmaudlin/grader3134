import java.util.LinkedList;

public class MyStack<AnyType> {

	// create a linked list and an int for the size of stack
	LinkedList<AnyType> myStack = new LinkedList<>();
	int stackSize;

	// constructor, initialize stack size to zero
	public MyStack() {
		stackSize = 0;
	}

	public int size() {
		return stackSize;
	}

	// checks if stack (our linked list) is empty
	public boolean isEmpty() {
		return myStack.size() == 0;
	}

	// returns the element at the top of the stack
	public AnyType peek() {
		return myStack.get(myStack.size()-1);
	}

	// removes element at top of stack and returns this element
	public AnyType pop() {
		AnyType lastElement = myStack.get(myStack.size()-1);
		myStack.remove(lastElement);
		stackSize--;
		return lastElement;
	}

	// adds new element to top of stack
	public void push(AnyType n) {
		AnyType newElement = n;
		myStack.add(newElement);
		stackSize++;
	}

}