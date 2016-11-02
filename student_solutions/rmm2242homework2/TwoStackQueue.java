import java.util.LinkedList;

public class TwoStackQueue<AnyType> implements MyQueue<AnyType> {

	private MyStack backofline;
	private MyStack frontofline;

	public TwoStackQueue() {
		backofline = new MyStack();
		frontofline = new MyStack();
	}

	// Performs the enqueue operation
    public void enqueue(AnyType x) {
    	backofline.push(x);
	}	
    // Performs the dequeue operation. For this assignment, if you
    // attempt to dequeue an already empty queue, you should return
    // null
    public AnyType dequeue() {
    	if (frontofline.size() == 0) {
    		int size = backofline.size();
    		for(int i=0; i < size; i++) {
    			AnyType transfer = (AnyType) backofline.pop();
    			frontofline.push(transfer);
    		}
    	}
    	return (AnyType) frontofline.pop();
    }

    // Checks if the Queue is empty
    public boolean isEmpty() {
    	if ((backofline.size() == 0) && (frontofline.size() == 0)) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }

    // Returns the number of elements currently in the queue
    public int size() {
    	return (backofline.size() + frontofline.size());
    }

}