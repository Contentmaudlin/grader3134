
public class TwoStackQueue<AnyType> implements MyQueue<AnyType> {

	private MyStack<AnyType> stack1 = new MyStack<AnyType>();
	private MyStack<AnyType> stack2 = new MyStack<AnyType>();
	private int count = 0;

	@Override
	public void enqueue(AnyType x) {
		stack1.push(x);
		count++;
	}

	@Override
	public AnyType dequeue() {
		if (stack2.isEmpty()){  // if stack 2 is empty 
			if (stack1.isEmpty()){
				System.err.println("There is nothing in the queue");//if stack 1 is empty return error (all stacks are empty)
				return null;
			}
			else{ //if stack 2 is not empty
				while(stack1.isEmpty()==false){ //push all values from stack1 onto stack2
					stack2.push(stack1.pop());
				}
			}
		}
		count--;
		return stack2.pop(); //return top value
	}

	@Override
	public boolean isEmpty() {
		return count == 0;
	}

	@Override
	public int size() {
		return count;
	}

}
