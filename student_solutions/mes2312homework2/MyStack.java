//************************************************************************************************
// Marco Starger
// mes2312
// MyStack Class
//************************************************************************************************

import java.util.LinkedList;

public class MyStack<AnyType> {
	LinkedList<AnyType> myList;
	
	public MyStack()
	{
		myList = new LinkedList<AnyType>();
	}
	
	
	public AnyType push(AnyType x)
	{
		myList.addFirst(x);
		return x;
	}
	
	public AnyType pop()
	{
		return myList.removeFirst();
	}
	public AnyType peek()
	{
		return myList.getFirst();
	}
	
	public boolean isEmpty()
	{
		if (myList.size() == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public int size()
	{
		return myList.size();
	}
	
	public String toString()
	{
		String print = "";
		for (int i = 0; i < myList.size(); i++)
		{
			print = print + myList.get(i);
		}
		return print;
	}
}
