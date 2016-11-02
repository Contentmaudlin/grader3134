import java.util.LinkedList;

/**
 * 
 * @author gracemilstein gam2138
 *
 */
public class MyStack<AnyType> {

	private LinkedList<AnyType> element = new LinkedList<AnyType>();

	public void push(AnyType value) {
		element.add(value);

	}

	public AnyType pop() {
		if (element.size() > 0) {
			return element.remove((element.size() - 1));
		} else {
			return null;
		}
	}

	public AnyType top() {
		if (element.size() > 0) {
			return element.get(element.size() - 1);
		} else {
			System.err.println("The Stack is empty, you can't call top");
			return null;
		}
	}

	public boolean isEmpty() {
		if (element.size() == 0) {
			return true;
		} else {
			return false;
		}
	}

	public int size() {
		return element.size();

	}

}
