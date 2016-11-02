//*************************************
//
//  MyStack.java
//
//  Class to implement my own generic Stack
//
//  Anh Phung
//  adp2161
//**************************************

import java.util.LinkedList;


public class MyStack<AnyType> {

	// instance variables
	LinkedList<AnyType> theList;


	// constructor
	public MyStack()
	{
		// initialize instance variables
		theList = new LinkedList<AnyType>();
	}


	// adding an element to top of stack
	public void push (AnyType x)
	{
		theList.addFirst(x);
	}


	// remove and return the top element of stack
	public AnyType pop()
	{
		// check if empty
		if (theList.isEmpty())
			return null;

		// remove and return top element
		AnyType item = theList.removeFirst();
		return item;
	}


	// peek at the top element of stack
	public AnyType peek()
	{
		// check if empty
		if (theList.isEmpty())
			return null;

		// return the top element
		return theList.getFirst();
	}


	// check if the stack is empty
	public boolean isEmpty()
	{
		return size() == 0;
	}
	

	// return number of elements in stack
	public int size()
	{
		return theList.size();
	}
}