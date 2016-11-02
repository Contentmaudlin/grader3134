
public class TwoStackQueue<AnyType> implements MyQueue<AnyType>{
	private MyStack<AnyType> in;
	private MyStack<AnyType> out;
	
	public TwoStackQueue(){
		in = new MyStack<AnyType>();
		out = new MyStack<AnyType>();
	}
	// Performs the enqueue operation
    public void enqueue(AnyType x){
    	in.push(x);
    }

    // Performs the dequeue operation. For this assignment, if you
    // attempt to dequeue an already empty queue, you should return
    // null
    public AnyType dequeue(){
    	if(this.isEmpty()){
    		return null;
    	}
    	if(out.isEmpty()){	// out empty, push whole in to out
    		while (!in.isEmpty()){
    			out.push(in.pop());
    		}
    	}
    	return out.pop();
    }

    // Checks if the Queue is empty
    public boolean isEmpty(){
    	return (in.isEmpty() && out.isEmpty());
    }
    
    // Returns the number of elements currently in the queue
    public int size(){
    	return in.size() + out.size();
    }
}
