/*
      Loie Plautz
      lmp2180
      Homework 2
*/
import java.util.ArrayList;

public class MyStack<E>{
	
	private ArrayList<E> stack;
	//the arraylists used are generic so they work with any type
	//E is the anytype variable

	public MyStack()
	{
		stack = new ArrayList<E>();
	}


	public E pop()
	{
		if(stack.size()<1)
			return null;
		else
		{
			E popped = stack.get(stack.size()-1);
			stack.remove(stack.size()-1);
			return popped;
	//to pop, the item must be returned AND removed
		}
	}

	public void push(E x)
	{
		//pushing is just adding to the end
		stack.add(x);
	}

	public int size()
	{
		return stack.size();
	}

	public boolean isEmpty()
	{
		if(stack.isEmpty())
			return true;
		else
			return false;
	}

}