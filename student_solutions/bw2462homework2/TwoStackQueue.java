/* Boya Wang
 * bw2462
 * TwoStackQueue.java
 */

public class TwoStackQueue<AnyType> implements MyQueue<AnyType>{
	
	public MyStack<AnyType> S1;
	public MyStack<AnyType> S2;
	
	public TwoStackQueue(){
      S1 = new MyStack<AnyType>();
      S2 = new MyStack<AnyType>();
	}
	
	public void enqueue(AnyType x){
		S1.push(x);
	}
	
	//Dequeue: if S2 is not empty, pop it. If S2 is empty, pop all the elements from S1 and push them into S2,
	//and then pop the first one in S2. 
	public AnyType dequeue(){
		
		if(!(S2.isEmpty())){
			return S2.pop();
		    }else{
		    	if(S1.isEmpty()){    //To check if both stacks are empty. If so, there's an error. 
		    		System.out.println("Stack Underflow");
		    		AnyType error = (AnyType) "error";
		    		return error;
		    	}
		    	else{
		    		while(!(S1.isEmpty())){
		    			S2.push(S1.pop());
		    		}
			    return S2.pop();
		    	}
		    }
		 }
	 
	public boolean isEmpty(){
		if ((S1.isEmpty())&&(S2.isEmpty())) {
			return true;
		} else {
			return false;
		}
	}
	public int size(){
		int size1 = S1.size();
		int size2 = S2.size();
		return size1 + size2;
	}
	
	
	

}
