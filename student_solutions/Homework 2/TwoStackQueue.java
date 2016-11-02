//*****************************************************************************
//
// Name - Ishaan Kishore Agrawal
// UNI - ia2341
// Date - 8th October, 2016
//
// TwoStackQueue Class
//
// This class contains the constructor for the queue object which consists of 2 
// stacks
//
//*****************************************************************************

import java.util.NoSuchElementException;


// begin class
public class TwoStackQueue<AnyType> implements MyQueue<AnyType> {
	
	// instance variables - the 2 stacks
	private MyStack<AnyType> enqueueStack;
	private MyStack<AnyType> dequeueStack;
	
	// constructor which creates the queue object
	public TwoStackQueue() {
		enqueueStack = new MyStack<AnyType>();
		dequeueStack = new MyStack<AnyType>();
	}
	
	// method that adds an element onto the queue
	public void enqueue(AnyType x) {
		enqueueStack.push(x);
	}

	// method that dequeue an element from the queue
	public AnyType dequeue() throws NoSuchElementException {
		
		if (dequeueStack.isEmpty() && enqueueStack.isEmpty()) {
			System.out.println("ERROR: The queue is empty.");
			throw new NoSuchElementException();
		}
		
		// if the dequeueStack is empty
		if (dequeueStack.isEmpty())
			// transfer all the data from the enqueueStack onto the dequeueStack
			transferFromEnqueue();

		// return the top element from the dequeueStack
		return dequeueStack.pop();
	}

	// returns whether queue is empty or not
	public boolean isEmpty() {
		return this.size() == 0;
	}

	// returns the sum of the enqueueStack and dequeueStack
	public int size() {
		return enqueueStack.size() + dequeueStack.size();
	}
	
	// method that transfers all the data to the dequeueStack
	private void transferFromEnqueue() {
		
		// while the enqueueStack is not empty
		while (!enqueueStack.isEmpty())
			// pop the top element from the enqueueStack onto the dequeueStack
			dequeueStack.push(enqueueStack.pop());
	}
}
// end class
