public class TwoStackQueue<AnyType> implements MyQueue<AnyType> {

        //instance variables
	MyStack<AnyType> S1;
	MyStack<AnyType> S2;
	int length;

	// This is the interface that your TwoStackQueue class must implement.
        //constructor which initializes S1 and S2
	public TwoStackQueue() {

		S1 = new MyStack<AnyType>();
		S2 = new MyStack<AnyType>();
		length = 0;

	}

	// Performs the enqueue operation
	//push elements in the first stack
	public void enqueue(AnyType x) {
		S1.push(x);
		length++;
	}


	// Performs the dequeue operation.
	// For this assignment, if you
	// attempt to dequeue an already empty queue, you should return // null
	public AnyType dequeue() {
                //check if S2 is empty or not 
		if(S2.isEmpty()){
                        //if you have elements in your S1 then push them to S2
			while (!(S1.isEmpty())) {
				S2.push(S1.pop());
			}
		}

                //initialize your poppedElement to null 
		AnyType poppedElement = null;
                //if S2 is not empty then pop each element in it and decrement the length 
		if(!(S2.isEmpty())){
			poppedElement = S2.pop();
			length--;
		}
		return poppedElement;
	}

	// Checks if the Queue is empty
	public boolean isEmpty() {
		return length == 0;
	}
	// Returns the number of elements currently in the queue

	public int size() {
		return length;
	}

}// end class
