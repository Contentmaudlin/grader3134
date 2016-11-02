import java.util.LinkedList;

public class MyStack<AnyType> {
	private LinkedList<AnyType> listL;

	public MyStack() {
		listL = new LinkedList<AnyType>();

	}

	// push method
	public void push(AnyType y) {
		// using the add first method instead of the push method to add an
		// element to
		// the top of the stack
		listL.addFirst(y);
	}

	// pop method
	public AnyType pop() {
		// declaring y
		AnyType y;
		// using the remove method to take off the toppest element in the stack
		// and storing its value in y
		y = listL.removeFirst();

		return y;
	}

	// peak method
	public AnyType peek() {
		// declaring z
		AnyType z;
		// using the getFirst method instead of peak and storing it in z
		z = listL.getFirst();

		// returning z
		return z;
	}

	// is empty method
	public boolean isEmpty() {
		// check if size of the list is 0
		if (listL.size() == 0)
			return true;
		else
			return false;

	}
}// end class
