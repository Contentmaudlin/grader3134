//Homework2 - Problem2
//Kehan Lu - kl2858

public class TwoStackQueue<AnyType> implements MyQueue<AnyType>{
	
	private MyStack<AnyType> stack1, stack2;
	
	public TwoStackQueue() {
		stack1=new MyStack<>();
		stack2=new MyStack<>();
	}
	
	public void enqueue(AnyType x){
		stack1.push(x);
	}
	
	public AnyType dequeue(){
		if (stack2.empty())
			while (!stack1.empty())
				stack2.push(stack1.pop());
		return stack2.pop();
	}
	
	public boolean isEmpty(){
		return (stack1.empty()&&stack2.empty());
	}
	
	public int size(){
		return stack1.size()+stack2.size();
	}

}
