/* Andrew Lee
 * awl2144
 * MyStack.java
 */

import java.util.LinkedList;
import java.util.NoSuchElementException;

import java.util.Arrays;

public class MyStack<AnyType> {

	public LinkedList<AnyType> stack = new LinkedList<AnyType>();

	public MyStack() {}

	public void push(AnyType o) {
		stack.add(0, o);
	}

	public AnyType pop() {
		if (stack.isEmpty()) {
			throw new IllegalStateException("Stack empty");
		}
		AnyType temp = stack.get(0);
		stack.remove(0);
		return temp;
	}

	public boolean isEmpty() {
		return stack.isEmpty();
	}

	public AnyType peek() {
		if (stack.isEmpty()) {
			throw new IllegalStateException("Stack empty");
		}
		AnyType temp = stack.pop();
		stack.push(temp);
		return temp;
	}

	public int size() {
		return stack.size();
	}

	public String toString() { //for debugging
		return Arrays.toString(stack.toArray());
	}

}
