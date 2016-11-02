//*******************************************************************
//Christian Cruz Godoy
//COMSW 3134: MyStack class
//Generic class that creates a stack
//*******************************************************************

import java.util.NoSuchElementException;

public class MyStack<AnyType>
{
	public int theSize;
	public character first;
	
	//This is my constructor. Since we only care about the top value in
	//the stack, I set the value of first.
	public MyStack()
	{
		first = null;
	}
	
	//This is my size method. It returns the size.
	public int size()
	{
		return theSize;
	}

	//This method adds an item to the stack.
	public void add(AnyType item) 
	{
		character newCharacter = new character();
		newCharacter.data = item;
		newCharacter.next = first;
		first = newCharacter;	
		theSize++;
	}

	//This method removes the item from the stack and then
	//returns the value of the item it removed.
	public AnyType remove() 
	{
		if(first==null)
		{
			throw new NoSuchElementException();
		}
		AnyType item = first.data;
		first = first.next;
		theSize--;
		return item;
		
	}
	
	//This is the method that checks whether the stack is empty.
	//it returns null for the first value since that would mean it is
	//empty
	public boolean empty()
	{
		return first == null;
	}
	
	//This is a nested class. I looked back into the textbook BigJava 
	//to do this
	class character
	{
		public AnyType data;
		public character next;
	}
	
}

