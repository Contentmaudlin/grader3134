public class TwoStackQueue<AnyType> implements MyQueue<AnyType>{
	private MyStack<AnyType> stack1;
	private MyStack<AnyType> stack2;
	
	
	public TwoStackQueue(){
		stack1 = new MyStack<>(); //declaring both enqueue(1) and dequeue(2) stacks
		stack2 = new MyStack<>();
	}
	public AnyType dequeue(){
		
		
		//first we push all values of stack1 onto stack2 until stack 1 is empty
		while(stack1.isEmpty()==false){
			stack2.push(stack1.pop());
		}
		
		//save the value we want to pop
		AnyType returnValue = stack2.pop();
		
		//pop the rest of the values back into stack 1
		while(stack2.isEmpty()==false){
			stack1.push(stack2.pop());
		}
		
		//return 1st popped value
		return returnValue;
		
		
	}
	
	public void enqueue(AnyType x){ //enqueue just by pushing object onto enqueue stack (stack1)
		stack1.push(x);
	}
	
	public boolean isEmpty(){
		return stack1.isEmpty();
	}
	
	public int size(){
		return stack1.size();
	}
	
}
