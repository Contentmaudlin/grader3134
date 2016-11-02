//Written by Jinoh Lee (jl4622), Homework 2, Programming Problem 2
//This class combines two stacks to function as a queue 
@SuppressWarnings("rawtypes") // suppress this to properly implement
public class TwoStackQueue<AnyType> implements MyQueue {

	public MyStack<AnyType> S1;
	public MyStack<AnyType> S2;

	// Constructor
	public TwoStackQueue() {
		S1 = new MyStack<AnyType>();
		S2 = new MyStack<AnyType>();
	}

	// first in
	@SuppressWarnings("unchecked") // suppresses to properly implement
	public void enqueue(Object x) {
		S1.push((AnyType) x);
	}

	// first out
	public AnyType dequeue() {
		if (S2.size() <= 0) {
			while (S1.size() > 0) {
				AnyType temp = S1.pop();
				S2.push(temp); // Moves all Elements to S2
			}
		}
		return S2.pop();
	}

	// checks if stacks both have no elements
	public boolean isEmpty() {
		if (S1.size() + S2.size() == 0) {
			return true;
		} else {
			return false;
		}
	}

	// gives number of elements
	public int size() {
		int size = S1.size() + S2.size();
		return size;
	}

}
