import java.util.*;

public class TwoStackQueue<AnyType> implements MyQueue<AnyType> {
	
	private MyStack<AnyType> S1;
	private MyStack<AnyType> S2;
	
	public TwoStackQueue() {
		S1 = new MyStack<AnyType>();
		S2 = new MyStack<AnyType>();
	}
	
	public void enqueue(AnyType a) {
		S1.push(a);
	}
	
	public AnyType dequeue() {
		if(S2.isEmpty()) {
			//if there's nothing to dequeue, return null
			if(S1.isEmpty()){
				return null;
			}
			//if there is stuff to dequeue
			while (!S1.isEmpty()) {
				//push all of S1 onto S2 (will be in opp order)
				S2.push(S1.pop()); 
			}
		}
		//return top of S2 (bottom of S1)
		return S2.pop();
	}
	
	public boolean isEmpty(){
		//if there are no elems in either stack
		if(S2.isEmpty() && S1.isEmpty()){
			return true;
		}
		//if there are
		else {
			return false;
		}
	}
	
	//no elements repeat because you're just moving S1 to S2, so size is sum
	public int size(){
		return S2.size() + S1.size();
	}
	

}

