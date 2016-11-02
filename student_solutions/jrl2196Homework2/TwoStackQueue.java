public class TwoStackQueue<AnyType> implements MyQueue<AnyType>{

	private int mySize;
	private MyStack<AnyType> s1, s2;
	
	public TwoStackQueue(){
		mySize = 0;
		s1 = new MyStack<AnyType>();
		s2 = new MyStack<AnyType>();
	}
	   // Performs the enqueue operation
    public void enqueue(AnyType x){
    	s1.push(x);
    	mySize++;
    }

    // Performs the dequeue operation. For this assignment, if you
    // attempt to dequeue an already empty queue, you should return
    // null
    public AnyType dequeue(){
    	//decrement the size
    	mySize--;

    	//if your second stack is empty, you need to fill it with everything froms s1 before popping off the top item
    	if (s2.isEmpty()) {
    		while(!s1.isEmpty()){
    			s2.push(s1.pop());
    		}
    		return s2.pop();
    	}
    	//if you still have items on the second stack you can just pop one off
    	else{
    		return s2.pop();
    	}

    }

    // Checks if the Queue is empty
    public boolean isEmpty(){
    	return mySize==0;
    }

    // Returns the number of elements currently in the queue
    public int size(){
    	return mySize;
    }
}