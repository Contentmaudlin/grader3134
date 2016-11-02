//yy2658
//Yilun Ying

public class TwoStackQueue<AnyType> {
	
	int stackLocation;
	MyStack<AnyType> stack1;
	MyStack<AnyType> stack2;
	
	public TwoStackQueue(){
		stack1 = new MyStack<AnyType>();
		stack2 = new MyStack<AnyType>();
	}
	
	// Performs the enqueue operation 
	public void enqueue(AnyType x){
		stack1.push(x);
	}
	
	// Performs the dequeue operation. For this assignment, if you 
	// attempt to
	// dequeue an already empty queue, you should return 
	// null 
	public AnyType dequeue(){
		if(this.isEmpty()){
			return null;
		}
		else{
		AnyType dataToReturn;
		if(stack2.sizeOfStack()==0){
			while(stack1.sizeOfStack()>0){
			stack2.push(stack1.pop());
			}
		}
		dataToReturn = stack2.pop();
		return dataToReturn;
		}
	}
	
	// Checks if the Queue is empty 
	public boolean isEmpty(){
		if(this.size()<=0){
			return true;
		}
		else{
			return false;
		}
	}
	
	// Returns the number of elements currently in the queue 
	public int size(){
		int size;
		size = stack1.sizeOfStack()+stack2.sizeOfStack();
		return size;
	}

}
