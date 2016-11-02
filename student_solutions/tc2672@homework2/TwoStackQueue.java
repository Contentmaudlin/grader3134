/***************************************************************
 * TwoStackQueue.java
 * By: Tahiya Chowdhury 
 * Homework 2
 ***************************************************************/

public class TwoStackQueue<AnyType> implements MyQueue<AnyType> {
	
	private MyStack<AnyType> stack1; // input stack
    private MyStack<AnyType> stack2; // output stack
    private int totalElement;
    
    public TwoStackQueue(){
    	stack1 = new MyStack<AnyType>();
    	stack2 = new MyStack<AnyType>();
    	totalElement = 0;
    }
	@Override
	//Adds elements to the queue
	public void enqueue(AnyType e) {
		stack1.push(e);
		totalElement++;
	}

	@Override
	// Removes elements from the queue
	public AnyType dequeue() {
		AnyType dequeuedElement = null;
		
		if(stack2.isEmpty()) { // Returns null if both stacks are empty
		   if (stack1.isEmpty()) {
		       return null;
		   }
		   else {
			/* Transfers elements from stack2 to stack1 
			 * until sta1 is empty 
			 */
			   while(!stack1.isEmpty()){
				   stack2.push(stack1.pop());
			   }
		   }
		}
		/*Pops elements out of stack2 until it's empty
		 * to remove elements from the queue */
		if(!stack2.isEmpty()) {
			dequeuedElement = stack2.pop(); 
			totalElement--;
		}
		return dequeuedElement;
	}

	@Override
	// Checks if queue is empty
	public boolean isEmpty() {
		if(size() != 0){
			return false;
		}
		return true;
	}

	@Override
	// Returns the number of elements in the queue
	public int size() {
		return totalElement;
	}

}
