/*Paul Bloom
* pab2163
* TwoStackQueue Class makes a queue with quque functionalities,
* as specified by the MyQueue interface, using two stacks from the
* MyStack class */



public class TwoStackQueue <AnyType> implements MyQueue<AnyType> {
	MyStack <AnyType> S1 = new MyStack<AnyType>();
	MyStack <AnyType> S2 = new MyStack<AnyType>();


	/**
	* Adds item of AnyType to queue
	* @param x, object of AnyType to add to queue
	*/
    public void enqueue(AnyType x){
    	S1.push(x);
    }


	/**
	* Dequeues the first item added to the queue
	* @return an item of AnyType
	*/
    public AnyType dequeue(){
    	if(this.isEmpty()){
    		return null;
    	}
    	else{
    		if(S2.isEmpty()){
    			while(!S1.isEmpty()){
    				S2.push(S1.pop());
    			}
    		}
    		return(S2.pop());
    	}
    }


	/**
	* Checks to see if the queue is empty
	* @return true if queue is empty, false if not
	*/
    public boolean isEmpty(){
    	if(S1.isEmpty() & S2.isEmpty()){
    		return true;
    	}
    	else{
    		return false;
    	}
    }

    /**
	* Returns the numbeer of elements currently in the queue
	* @return int value of number of elements in queue
	*/
    public int size(){
    	return(S1.size() + S2.size());
    }

}