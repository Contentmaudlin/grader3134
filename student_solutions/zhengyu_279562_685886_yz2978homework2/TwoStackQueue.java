
public class TwoStackQueue<AnyType> implements MyQueue<AnyType>{
	//create two stacks using MyStack class
	private MyStack<AnyType> Stack1=new MyStack<>();
	private MyStack<AnyType> Stack2=new MyStack<>();
	@Override
	public void enqueue(AnyType x) {
		Stack1.push(x);	
	}

	@Override
	public AnyType dequeue() {
		//if stack2 is empty, then copy data in stack1 inversely into stack2
		if (Stack2.isEmpty()){
			while(!Stack1.isEmpty()){
				Stack2.push(Stack1.pop());				
			}
		}
		//if stack2 has data inside, just pop the top one
		return Stack2.pop();
	}

	@Override
	public boolean isEmpty() {
		return this.size()==0;
	}

	@Override
	public int size() {
		//size of the queue is the sum of two stacks
		return Stack1.size()+Stack2.size();
	}

}
