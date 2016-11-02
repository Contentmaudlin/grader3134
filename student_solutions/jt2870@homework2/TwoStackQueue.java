
public class TwoStackQueue<AnyType> implements MyQueue<AnyType> {
	private MyStack<AnyType> S1;
	private MyStack<AnyType> S2;
	public int size;
	public TwoStackQueue(){
		S1=new MyStack<>();
		S2=new MyStack<>();
		size=0;
	}
	public void enqueue(AnyType x){
		/** first need to check whether any elements left in S2
		in order to satisfy the requirement, we need to put every elements in S2
		back to S1 at first.*/
		while(!S2.isEmpty())
			S1.push(S2.pop());
		S1.push(x);
		//System.out.println(S1.top());
	}
    public AnyType dequeue(){
    	// put all the elements in S1 to S2
    	while(!S1.isEmpty())
    		S2.push(S1.pop());
    	if(!S2.isEmpty()){
    		return S2.pop();
    	}
    	else
    		return null;
    }

    // Checks if the Queue is empty
    public boolean isEmpty(){
    	size=S1.getsize()+S2.getsize();
    	if(size==0)
    		return true;
    	else
    		return false;
    }

    // Returns the number of elements currently in the queue
    public int size(){
    	size=S1.getsize()+S2.getsize();
    	return size;
    }
}
