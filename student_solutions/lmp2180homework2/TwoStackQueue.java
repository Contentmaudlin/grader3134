/*
      Loie Plautz
      lmp2180
      Homework 2
*/

public class TwoStackQueue<AnyType> implements MyQueue<AnyType>
{
	private MyStack<AnyType> s1; //input stack
	private MyStack<AnyType> s2; //output stack
	private int size; 
	public TwoStackQueue()
	{
		s1 = new MyStack<AnyType>();
		s2 = new MyStack<AnyType>();
        //the object holds the input and output stacks
	}

    public void enqueue(AnyType x)
    {
    	s1.push(x);
        //the item is pushed to the top of the input stack
    }

    public AnyType dequeue()
    {
        if(isEmpty())
    	{
    		return null;
    	}
//if the members of the queue have not been added to the output stack
//they are pushed from the input stack to the output stack
    	if(s2.isEmpty())
        {
            while(s1.isEmpty()==false)
            {
                s2.push(s1.pop());
            }
        }
//when they are popped off the output stack, they are FIFO, like a queue
        return s2.pop();
    }

    // Checks if the Queue is empty
    public boolean isEmpty()
    {
    	if(s1.isEmpty() && s2.isEmpty())
    	{
    		return true; //if nothing is in either stack
    	}
    	else
    	{
    		return false;
    	}
    }

    // Returns the number of elements currently in the queue
    public int size()
    {
    	size = s1.size() + s2.size(); 
        //the size is just the size of both stacks 
        return size;
    }

}