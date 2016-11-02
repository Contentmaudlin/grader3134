/*
 * Name: Pranav Arora
 * UNI: pa2450
 * Description: Implements a queue using two stacks
 * 
 */

public class TwoStackQueue<AnyType> implements MyQueue<AnyType>{
	
	MyStack<AnyType> S1 = new MyStack<>();
	MyStack<AnyType> S2 = new MyStack<>();
	
	@Override
	public void enqueue(AnyType x) {
		S1.push(x);
	}
	
	@Override
	public AnyType dequeue() {
		
		if (this.isEmpty()){
			System.out.println("Error: Trying to dequeue from an empty queue");
		}
		
		// is S2 is empty, fill it up by reversing S1
		if (S2.size() == 0){
			
			while (S1.size() != 0){
				S2.push(S1.pop());
			}
		
			return S2.pop();
		}
		
		else {
			return S2.pop();
		}
		
	}

	@Override
	public boolean isEmpty() { 
		return ((S1.size() + S2.size()) == 0);
	}

	@Override
	public int size() {
		return (S1.size() + S2.size());
	}
 
}
