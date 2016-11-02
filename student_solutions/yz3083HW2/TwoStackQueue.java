public class TwoStackQueue<AnyType> implements MyQueue<AnyType> {
    private MyStack a= new MyStack(); //creat two stacks
    private MyStack b= new MyStack();
    int size=0;//set the size of two stacks to be zero at first
	@Override
	public void enqueue(AnyType x) { //directly push into stack a
		// TODO Auto-generated method stub
		a.push(x);
	}

	@Override
	public AnyType dequeue() {  
		// TODO Auto-generated method stub
		if(b.IsEmpty()){  // if the second stack is empty, then push everything from stack a to b, then pop from b
		    while(a.IsEmpty()!=true){
		    	b.push(a.pop());
		    }
		    return (AnyType) b.pop();//otherwise pop from stack b directly
		}
		else{
			return (AnyType) b.pop();
		}
	
	
	}

	@Override
	public boolean isEmpty() { //check if there the queue is empty
		// TODO Auto-generated method stub
		return a.IsEmpty()&&b.IsEmpty();}
	

	@Override
	public int size() { //the size of the queue is equal to the sum of the elements in two stacks
		// TODO Auto-generated method stub
		
		return a.size()+b.size();
	}

}
