//Fernando A. Pascual
//fap2122
//Data Structures Homework 2

import java.util.LinkedList;

public class MyStack<E>
{
	private LinkedList<E> stack;

	public MyStack()
	{
		stack = new LinkedList<E>();
	}

	public E pop()
	{
		if (stack.size() == 0)
			return null;
		else
			return stack.remove();
	}

	public void push(E e)
	{
		stack.addFirst(e);
	}

	public E peek()
	{
		if (stack.size() == 0)
			return null;
		else
			return stack.getFirst();
	}

	public boolean isEmpty()
	{
		return stack.isEmpty();
	}

	public int size()
	{
		return stack.size();
	}
}