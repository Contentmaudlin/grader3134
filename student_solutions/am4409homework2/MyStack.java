//*****************************************
//Arjun Mangla
//am4409
//Paul Blaer
// Data Structures
//Fall 2016
//Homework-2
//*****************************************

import java.util.LinkedList;

//Class forming the Stack implementation
//of LinkedLists
public class MyStack <AnyType> {

	//Instance variables LinkedList, ints 
	//representing size of stack and top of the stack
	public LinkedList<AnyType> theList;
	public int size;
	public int topOfStack;
	
	//Constructor for MyStack object takes in
	//LinkedList as argument
	public MyStack(LinkedList<AnyType> givenList) {
		theList = givenList;
		size = theList.size();
		topOfStack = - 1;
	}
	
	//Method to push element onto the stack
	public void push(AnyType x) {
		size++;
		theList.add(++topOfStack, x);
	}
	
	//Method to pop element off the stack
	public AnyType pop() {
		if (size > 0) {
			size--;
			return theList.get(topOfStack--);
			}
		else
			return null;
		}
	
	//Method to return the top element without
	//popping it
	public AnyType top() {
		if (size > 0) 
			return theList.get(topOfStack);
		else
			return null;
	}
	
}
