/* Sejal Jain
 * sj2735 
 * MyStack.java - implementation of a queue using 2 stacks */

public class TwoStackQueue<AnyType> extends MyStack<AnyType> implements MyQueue<AnyType> {
	// defines implementation of a queue using 2 stacks

	public MyStack<AnyType> S1;
	public MyStack<AnyType> S2;
	
	public TwoStackQueue() {
		S1 = new MyStack<AnyType>();
		S2 = new MyStack<AnyType>();
	}
	
	
	// Performs the enqueue operation
    public void enqueue(AnyType x) {
    	if (S1.size() == 0) {
    		S2.push(x);
    	}
    	else {
    		while(S1.size() != 0) {
    			S2.push(S1.pop());
    		}
    		S2.push(x);
    	}
    	
    }

    // Performs the dequeue operation. 
    public AnyType dequeue() {
    	if(isEmpty()) {
    		return null;
    	}
    	
    	else if (S1.size() == 0){
    		while(S2.size() != 0) {
    			S1.push(S2.pop());
    		}
    		return S1.pop();
    	}
    	else {
    		return S1.pop();
    	}
    }

    // Checks if the Queue is empty
    public boolean isEmpty() {
    	if (this.size() == 0) {
    		return true;
    	}
    	else {
    		return false;
    	}
    	
    }

    // Returns the number of elements currently in the queue
    public int size() {
    	return this.S1.size() + this.S2.size();
    }
}
