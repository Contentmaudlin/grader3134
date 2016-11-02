public class TwoStackQueue<AnyType> extends MyStack<AnyType> implements MyQueue<AnyType> {

	MyStack<AnyType> S1 = new MyStack<>();
	MyStack<AnyType> S2 = new MyStack<>();
	AnyType newElement;
	AnyType firstElement;

    // constructor
	public TwoStackQueue() {
		newElement = null;
		firstElement = null;
	}

    // adds element to queue
	public void enqueue(AnyType x) {
		newElement = x;
		S1.push(newElement);
	}

    // removes element from queque
    public AnyType dequeue() {
    	if(S1.isEmpty()) 
    		return null;
    	else {
    		while(!S1.isEmpty()) {
    			S2.push(S1.pop());
    		}
    		firstElement = S2.pop();
    		while(!S2.isEmpty()) {
    			S1.push(S2.pop());
    		}
    		return firstElement;
    	}
    }

    // returns size of queue
    public int size() {
    	return S1.size();
    }

    // checks if queue is empty and returns result of that check
    public boolean isEmpty() {
     	return S1.size() == 0;
    }
}