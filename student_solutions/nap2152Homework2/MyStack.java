import java.util.LinkedList;


public class MyStack<AnyType>{
	private LinkedList<AnyType> stack = new LinkedList<AnyType>();
	
	public void push(AnyType x) {
		stack.add(stack.size(), x);
	}

	public AnyType pop() {
		if (this.isEmpty()) {
			return null;
		}
		return stack.remove(stack.size()-1);
	}
	
	public AnyType top() {
		if (this.isEmpty()) {
			return null;
		}
		return stack.get(stack.size()-1);
	}
	
	public int size() {
		return stack.size();
	}
	
	public boolean isEmpty() {
		return stack.size() == 0;
	}
}
