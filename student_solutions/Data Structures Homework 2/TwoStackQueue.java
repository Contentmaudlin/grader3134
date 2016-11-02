//*************************************************************
//TwoStackQueue.java
//
//by Sophie Ishak
//*************************************************************

public class TwoStackQueue<AnyType> implements MyQueue<AnyType>{
	
	private MyStack<AnyType> S1,  S2;
	private int size;
	
	public TwoStackQueue(){
		S1=new MyStack<AnyType>();
		S2=new MyStack<AnyType>();
		size=0;
	}
	
	public void enqueue(AnyType x) {
		S1.push(x);
		size++;
	}
	
	public AnyType dequeue(){
		if (S2.isEmpty()) {
			while (!S1.isEmpty()) {
				AnyType x = S1.pop();
				S2.push(x); //S2 takes as input S1's values
			}
		} 
		size --;
		return S2.pop();	
	}
	
	public boolean isEmpty() {
		if (size==0) {
			return true;
		}
		return false;
	}
	
	public int size(){
		return size;
	}
}
