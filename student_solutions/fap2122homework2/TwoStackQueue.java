//Fernando A. Pascual
//fap2122
//Data Structures HW2

public class TwoStackQueue<E> implements MyQueue<E>
{

	private MyStack<E> eStack;
	private MyStack<E> dStack;

	public TwoStackQueue()
	{
		eStack = new MyStack<>();
		dStack = new MyStack<>();
	}	

	// Performs the enqueue operation
	public void enqueue(E e)
	{
		eStack.push(e);
	}

	// Performs the dequeue operation. For this assignment, if you
    // attempt to dequeue an already empty queue, you should return
    // null
	public E dequeue()
	{
		if (eStack.isEmpty() && dStack.isEmpty())
			return null;
		else if (dStack.isEmpty())
			while (!eStack.isEmpty())
				dStack.push(eStack.pop());
		return dStack.pop();
	}

	public boolean isEmpty()
	{
		return (eStack.isEmpty() && dStack.isEmpty());
	}

	public int size()
	{
		return eStack.size() + dStack.size();
	}
}
