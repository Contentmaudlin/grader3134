import java.util.ArrayList;

public class MyStack<AnyType>{
	
	ArrayList<AnyType> stack;

	public MyStack() {
		stack = new ArrayList<AnyType>();
	}

	public boolean isEmpty() {
		return (stack.size() == 0);
	}

	public void push(AnyType x) {
		stack.add(x);
	}

	public AnyType pop() {
		AnyType top = stack.get(stack.size() - 1);
		stack.remove(stack.size() - 1);
		return top;
	}

}