public class TwoStackQueue<AnyType> implements MyQueue<AnyType> {
	
	MyStack<AnyType> S1 = new MyStack<>();         // for enqueueing 
	MyStack<AnyType> S2 = new MyStack<>();         // for dequeueing

	//performs the enqueue operation. 
	public void enqueue(AnyType x)
	{
        while(!S2.isEmpty())
        {
            S1.push(S2.pop());
        }
        S1.push(x);

	}

    // Performs the dequeue operation. For this assignment, if you
    // attempt to dequeue an already empty queue, you should return
    // null
    public AnyType dequeue()
    {
        while(!S1.isEmpty())
        {
            S2.push(S1.pop());
        }
        if(S2.isEmpty())
        {
            return null;
        }
        else
        {
            return S2.pop();
        }
    }

    // Checks if the Queue is empty
    public boolean isEmpty()
    {
        if(S1.isEmpty() && S2.isEmpty())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    // Returns the number of elements currently in the queue
    public int size()
    {
        int size = 0;
        size = S1.length() + S2.length();
        return size;
    }
}