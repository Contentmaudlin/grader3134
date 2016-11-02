//************************************************************************************************
// Marco Starger
// mes2312
// TwoStackQueue Class
//************************************************************************************************


public class TwoStackQueue<AnyType> implements MyQueue<AnyType> {
	
	MyStack<AnyType> stack1;
	MyStack<AnyType> stack2;
	
	public TwoStackQueue()
	{
		stack1 = new MyStack<AnyType>();
		stack2 = new MyStack<AnyType>();
	}
	
	// Performs the enqueue operation
    public void enqueue(AnyType x)
    {
    	stack1.push(x);
    }

    // Performs the dequeue operation. For this assignment, if you
    // attempt to dequeue an already empty queue, you should return
    // null
    public AnyType dequeue()
    {
    	if (this.size() == 0)
    	{
    		return null;
    	}
    	else
    	{
    		while (this.size() > 0)
    		{
    			stack2.push(stack1.pop());
    		}
    	}
    	AnyType value = stack2.pop();
    	
    	while (stack2.size() > 0)
    	{
    			stack1.push(stack2.pop());
    	}
    	
    	return value;
    }

    // Checks if the Queue is empty
    public boolean isEmpty()
    {
    	if (this.size() == 0)
    	{
    		return true;
    	}
    	return false;
    }

    // Returns the number of elements currently in the queue
    public int size()
    {
    	return stack1.size();
    }

}
