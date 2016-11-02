//*************************************************************
//MyStack.java
//
//by Sophie Ishak
//*************************************************************



import java.util.LinkedList;

public class MyStack<AnyType> {
	
	private LinkedList<AnyType> myStack;
	//constructor
	//make a blank linked list
	public MyStack(){
		myStack = new LinkedList<AnyType>();
	}
	
	//make a push function using addFirst()
	public void push(AnyType x){
		myStack.addFirst(x);
	}
	
	//make a pop function using removeFirst()
	public AnyType pop(){
		if (!myStack.isEmpty())
			return myStack.removeFirst();
		else {
			System.out.println("You can't pop an empty stack.");
			return null;
		}
	}
	
	public boolean isEmpty() {
		return myStack.isEmpty();
	}
	
}
