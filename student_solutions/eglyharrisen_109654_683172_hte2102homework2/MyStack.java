import java.util.LinkedList;


public class MyStack<AnyType> {
	//Creates the Linked List that will be the stack
	public LinkedList<AnyType> stack = new LinkedList<AnyType>();
	
	//Uses the List feature addLast() to push x onto the stack at the end
	public void stackPush(AnyType x) {
		stack.addLast(x);
	}
	
	//First checks if the stack is empty using the Linked list is empty check
	//then removes and returns the last thing in the list
	//effectively popping the stack
	public AnyType stackPop() {
		if (stack.isEmpty() ==false) {
			AnyType thing = stack.removeLast();
			return thing;
		}
		//returns stack is empty if the stack is empty
		else {
			System.out.println("Stack is empty");
			return null;
		}
			
	}
	//checks last element of list and returns it without removing it
	public AnyType peek() {
		return stack.peekLast();
	}
	
	//uses list's is empty function to create a empty function for the stack
	public boolean isEmpty() {
		if (stack.isEmpty() == true) {
			return true;
		}
		else {
			return false;
		}
	}
		
}
