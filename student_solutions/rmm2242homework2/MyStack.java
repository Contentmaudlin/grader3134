import java.util.LinkedList;

public class MyStack<AnyType> extends LinkedList<AnyType> {
	
	private LinkedList theStack;

	public MyStack() {
		theStack = new LinkedList();
	}

	public AnyType pop() {
		AnyType first = (AnyType)theStack.removeFirst();
		return first;
	}

	public void push(AnyType x) {
		theStack.addFirst(x);
	}

	public int size() {
		return theStack.size();
	}

	// public static void main(String[] args) {

	// 	MyStack thestack = new MyStack<Integer>();
	// 	thestack.push(5);
	// }

}