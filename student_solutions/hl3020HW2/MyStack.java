import java.util.LinkedList;

public class MyStack<AnyType> {

	int currentIdx = 0;
	LinkedList<AnyType> l1 = new LinkedList();	
	
	public void push(AnyType el)
	{
		l1.add(currentIdx, el);
		currentIdx++;
	}

//get the last one and remove from the stack.
	public AnyType pop()
	{
		AnyType data = l1.get(--currentIdx);
		l1.remove(currentIdx);
		return data;
	}

	public AnyType peek()
	{
		return l1.get(currentIdx - 1);
	}

	public boolean  isEmpty()
	{
		if(l1.size() == 0)
			return true;
		else
			return false;
	}
	public int length(){
		return l1.size();
	}
}