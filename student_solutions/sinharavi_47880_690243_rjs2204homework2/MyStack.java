//rjs2204, Ravi Sinha

import java.util.LinkedList;

public class MyStack<E> {

	LinkedList<E> myList; 
	//building generic stack class from linked list
	
	public MyStack() {
		myList = new LinkedList<E>();
	}

	//creating pop method
	public E pop () {
		return myList.removeLast();

	}
	//creating push method
	public void push (E x) {
		myList.add(x);

	}

        //creating size method
	public int size() {
		return myList.size();

	}

	//method to check to see if stack is empty
	public boolean isEmpty() {
		if (myList.size() == 0)
		{
			return true; 
		}
		else
			return false;  

	}

}
