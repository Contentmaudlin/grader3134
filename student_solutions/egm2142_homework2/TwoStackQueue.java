
public class TwoStackQueue<AnyType> implements MyQueue<AnyType> {

	MyStack<AnyType> stack1;
	MyStack<AnyType> stack2;

	public TwoStackQueue() {
		stack1 = new MyStack<AnyType>();
		stack2 = new MyStack<AnyType>();
	}

	public void enqueue(AnyType x) {
		stack1.push(x);
	}

	public AnyType dequeue() {
		if (stack2.isEmpty()) {
			if (stack1.isEmpty()) {
				return null;
			}
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		return stack2.pop();
	}

	public boolean isEmpty() {
		if (stack1.isEmpty() && stack2.isEmpty()) {
			return true;
		}
		return false;
	}

	public int size() {
		return stack2.size();
	}

}
