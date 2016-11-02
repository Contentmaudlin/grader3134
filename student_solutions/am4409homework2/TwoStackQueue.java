//*****************************************
//Arjun Mangla
//am4409
//Paul Blaer
// Data Structures
//Fall 2016
//Homework-2
//*****************************************

import java.util.LinkedList;

//Implementation of Queue using 2 stacks
public class TwoStackQueue <AnyType> implements MyQueue <AnyType>{
	
	//Instance variables are just 2 objects of the MyStack class
	MyStack <AnyType> S1;
	MyStack <AnyType> S2;

	//Constructor for the TwoStackQueue object
	public TwoStackQueue() {
		S1 = new MyStack <AnyType> (new LinkedList <AnyType> ());
		S2 = new MyStack <AnyType> (new LinkedList <AnyType> ());
	}
	
	//enqueue adds the element to the back
	//of the Queue(Top of S1)
	@Override
	public void enqueue(AnyType x) {
		S1.push(x);
	}

	//dequeue method returns the element at
	//the front of the queue.
	//(pops elements from S1 and simultaneously
	//pushes them to top of S2, then pops S2)
	@Override
	public AnyType dequeue() {
		while(S1.size != 0) {
			S2.push(S1.pop());
		}
		if(S2.size == 0)
			return null;
		else
			return S2.pop();
	}

	//Boolean to check if size is 0 or not
	@Override
	public boolean isEmpty() {
		if(size() == 0)
			return true;
		else
			return false;
	}

	// returns the size of the queue
	@Override
	public int size() {
		return S1.size + S2.size;
	}

}
