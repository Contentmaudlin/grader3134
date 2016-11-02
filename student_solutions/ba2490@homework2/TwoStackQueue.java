/********************************************
* Ben Arbib - ba2490
* TwoStackQueues class is a queue built 
* from two stacks. It enqueues to S1 (stack1)
* and dequeues to S2 (stack2).
* it uses MyStack class as its stack
*********************************************/

public class TwoStackQueue<AnyType> implements MyQueue<AnyType>{

	MyStack<AnyType> S1;
	MyStack<AnyType> S2;

	// constructor
	public TwoStackQueue(){

		S1 = new MyStack<AnyType>();
		S2 = new MyStack<AnyType>();
	}

	// enqueues into stack1
	public void enqueue(AnyType x){
		S1.push(x);
	}

	// dequeues from stack2, if it is empty
	// it transfers all elements from
	// stack1 to stack2 and then dequeues
	// from stack2. returns null if both
	// are empty.
	public AnyType dequeue(){
		if (S2.isEmpty())
			while(!S1.isEmpty()) S2.push(S1.pop());

		if (isEmpty()) return null;
		else return S2.pop();
	}

	// if both stack1 and stack2 are empty
	// returns true, otherwise returns false
	public boolean isEmpty(){
		return (S1.isEmpty() && S2.isEmpty());
	}

	// takes size of both stacks and returns
	// and the size of the queue
	public int size(){
		return (S1.size()+S2.size());
	}
}