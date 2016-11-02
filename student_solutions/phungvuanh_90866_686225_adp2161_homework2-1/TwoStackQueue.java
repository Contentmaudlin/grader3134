//*************************************
//
//  TwoStackQueue.java
//
//  Class to implement generic Queue using two stacks
//
//  Anh Phung
//  adp2161
//**************************************

public class TwoStackQueue<AnyType> implements MyQueue<AnyType>
{
	// two private stacks to implement queue
	private MyStack<AnyType> stack1;
	private MyStack<AnyType> stack2;


	// constructor 
	public TwoStackQueue()
	{
		stack1 = new MyStack<AnyType>();
		stack2 = new MyStack<AnyType>();
	}	


	// enqueue one element into the queue
	public void enqueue(AnyType x)
	{
		stack1.push(x);
	}


	// dequeue an element from the queue
	public AnyType dequeue()
	{
		// push all elements from 1st stack to 2nd stack
		if (stack2.isEmpty())
		{
			while(!stack1.isEmpty())
			{
				stack2.push(stack1.pop());
			}
		}

		// queue is empty
		if (stack2.isEmpty())
		{
			return null;
		}

		// pop and return the element
		AnyType item = stack2.pop();
		return item;
	}


	// check if queue is empty
	public boolean isEmpty()
	{
		return stack1.isEmpty() && stack2.isEmpty();
	}


	// return size of queue
	public int size()
	{
		return stack1.size() + stack2.size();
	}
}