//*****************************************************************************
//
// Name - Ishaan Kishore Agrawal
// UNI - ia2341
// Date - 8th October, 2016
//
// MyStack Class
//
// This class contains the a constructor of MyStack and all the methods that are 
// used by the object.
//
//*****************************************************************************

// import the necessary modules
import java.util.LinkedList;

// begin class
public class MyStack<AnyType> {

	// instance variables - linked list of data and an index integer
	private LinkedList<AnyType> theItems;
	private int topOfStack;
	
	// constructor of the object
	public MyStack() {
		
		// creates a new linked list and initializes topOfStack to 0
		theItems = new LinkedList<AnyType>();
		topOfStack = 0;
	}
	
	// method which pushes the element onto the stack
	public void push(AnyType element) {
		
		// add the element onto the stack and increment topOfStack
		theItems.add(element);
		topOfStack++;
	}
	
	// removes the top element of the stack and returns it
	public AnyType pop() {
		return theItems.remove(--topOfStack);
	}
	
	// returns the value of the top element of the stack
	public AnyType top() {
		return theItems.getLast();
	}

	// checks whether the stack is empty or not
	public boolean isEmpty() {
		return (topOfStack == 0);
	}
	
	// returns the number of objects in the stack
	public int size() {
		return (topOfStack);
	}
}
// ends the class