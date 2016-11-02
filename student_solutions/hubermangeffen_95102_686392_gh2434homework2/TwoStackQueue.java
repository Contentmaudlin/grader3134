public class TwoStackQueue<AnyType> implements MyQueue<AnyType>{

	final MyStack<AnyType> stackie1;
	final MyStack<AnyType> stackie2;

	public TwoStackQueue(){
		stackie1 = new MyStack<AnyType>();
		stackie2 = new MyStack<AnyType>();
	}

	public void enqueue(AnyType x){
		stackie1.push(x);
	}

	public AnyType dequeue(){

		AnyType toPop = stackie1.top();
		while (stackie1.getSize() >= 1){
			stackie2.push(stackie1.top());
			toPop = stackie1.top();
			stackie1.pop();
		}
		stackie2.pop();
		while (stackie2.isEmpty() == false){
			stackie1.push(stackie2.top());
			stackie2.pop();
		}

		return toPop;
	}

	public boolean isEmpty(){

		if (stackie1.getSize() == 0){
			return true;
		}
		else{
			return false;
		}
	}

	public int size(){
		return stackie1.getSize();
	}
}
