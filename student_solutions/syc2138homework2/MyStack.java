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
	 * Adds an element to the top of the stack.
	 * @param element the element to add to the stack.
	 */
	public void push(E element)
	{
		stack.addFirst(element);
	}
	
	/**
	 * Removes and returns the topmost element in the stack.
	 * @return removed element, null if empty
	 */
	public E pop()
	{	
		if (stack.isEmpty())
		{
			return null;
		}
		else
		{
			return stack.removeFirst();
		}
	}
	
	@Override
	public String toString()
	{
		String stackString = stack.toString();
		return "\nStack: " + stackString.substring(1, stackString.length() - 1);
	}
	
	/**
	 * Finds size of the stack.
	 * @return the size of the stack
	 */
	public int size()
	{
		return stack.size();
	}

	private LinkedList<E> stack;

}
