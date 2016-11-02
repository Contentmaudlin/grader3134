//Or Aboodi, oda2102, solving problem 2 on homework 2
//This is the queue class made up of two MyStacks

public class TwoStackQueue <AnyType>implements MyQueue<AnyType>{
	
	private MyStack<AnyType> s1;
	private MyStack<AnyType> s2;
	
	public TwoStackQueue() {
		s1 = new MyStack<AnyType>();
		s2 = new MyStack<AnyType>();
	}
	
	public void enqueue(AnyType x) {
		s1.push(x);
	}

	// Performs the dequeue operation. For this assignment, if you 
	// attempt to dequeue an already empty queue, you should return null 
	public AnyType dequeue() {
		
		if (isEmpty())
			return null;
		//get the size of s1 at the moment
		int queueSize = s1.size();
		
		//reverse all of the stack onto s2
		for (int i=0; i<queueSize; i++){
			s2.push(s1.pop());
		}
		
		//store the element to return
		AnyType elementOut = s2.pop();
		
		//move the stack back onto s1 just without the last element
		for (int i=0; i<queueSize-1; i++){
			s1.push(s2.pop());
		}
		
		return elementOut;
	}
	
	// Checks if the Queue is empty 
	public boolean isEmpty() {
		return (s1.size()==0);
	}
	
	// Returns the number of elements currently in the queue 
	public int size() {
		return s1.size();
	}
	
}