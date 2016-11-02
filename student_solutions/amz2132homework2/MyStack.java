/*
 * Angela Zhang
 * amz2132
 * COMS 3134 Data Structures
 * MyStack class for Homework 2
 * This class provides the implementation of stacks (top, pop, push, isEmpty, size) using LinkedList methods. This
 * class uses an exception class UnbalancedSymbolException that is included in the zip file.
 */


import java.util.LinkedList;

public class MyStack <AnyType> 
{
	private LinkedList<AnyType> stack = new LinkedList<AnyType>();
	
	//stack's top function returns the element last added to the stack
	public AnyType top()
	{
		if (stack.isEmpty())
		{
			throw new UnbalancedSymbolException("Ran out of symbols");
		}
		//returns the first element (latest addition) in the stack 
		else
		{
		return stack.getFirst();
		}
		
	}
	
	//pop removes the latest addition to the stack
	public AnyType pop()
	{		
		return stack.removeFirst();
	}
	
	//push adds a specified AnyType n to the beginning of the list (top of the stack)
	public void push(AnyType n)
	{
		stack.addFirst(n);
	}
	
	//isEmptyreturns a boolean, true is the stack is empty and false otherwise
	public boolean isEmpty()
	{
		return stack.isEmpty();
	}
	
	//size returns an integer that represents the number of elements in the stack
	public int size()
	{
		return stack.size();
	}
	
}
