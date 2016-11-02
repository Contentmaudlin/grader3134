import java.util.LinkedList;
/**
 * A class that defines the stack data structure.
 * @author Sharon Chen syc2138
 * @since 10/1/16
 */
public class MyStack<E>
{
	public MyStack()
	{
		stack = new LinkedList<>();
	}

	/**
	 * Finds size of the stack.
	 * @return the size of the stack
	public int size()
	{
		return stack.size();
	}

	private LinkedList<E> stack;

}
