
//*****************************
//Class TwoStackQueue 
//
//
//Name: Dengyuan Shi 
//UNI: DS3441
//This is a generic class 
//that implements the queue ADT
//using two separate stacks. 
//*****************************
public class TwoStackQueue<AnyType> implements MyQueue<AnyType>{
	MyStack<AnyType> stack1;
	MyStack<AnyType> stack2;
	int size=0; 
	
	public TwoStackQueue(){
		stack1 = new MyStack<>();
		stack2 = new MyStack<>();	
	}
	
	public void enqueue(AnyType x) {
			stack1.push(x);
			size+=1; 
		
	}


	public AnyType dequeue() {
		if(!stack2.isEmpty()){
			size-=1;
			return stack2.pop();		
		}
		else{
			while(!stack1.isEmpty()){
				stack2.push(stack1.pop());
			}
			size-=1;
			return stack2.pop();
		}
	}


	public boolean isEmpty() {
		
		return stack1.isEmpty()&&stack2.isEmpty();
	}


	public int size(){
		return size;
	}
	
}
