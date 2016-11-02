/* Andrew Lee
 * awl2144
 * TwoStackQueue.java
 */

public class TwoStackQueue<AnyType> implements MyQueue<AnyType> {

	MyStack<AnyType> stack1 = new MyStack<AnyType>();
	MyStack<AnyType> stack2 = new MyStack<AnyType>();

	public void enqueue(AnyType x) {
		stack1.push(x);
	}

	public AnyType dequeue() {
		if (stack1.isEmpty()) {
			return null;
		}
		while (!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
		AnyType temp = stack2.pop();
		while (!stack2.isEmpty()) {
			stack1.push(stack2.pop());
		}
		return temp;
	}

	public boolean isEmpty() {
		return stack1.isEmpty();
	}

	public int size() {
		return stack1.size();
	}


}
