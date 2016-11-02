/**
 * This program implements a queue that consists of two stacks.
 * @author Sharon Chen syc2138 10/2/16
 */
public class TwoStackQueue<E> implements MyQueue<E>
{
	public TwoStackQueue()
	{
	   stack1 = new MyStack<E>();
	   stack2 = new MyStack<E>();
	}

	/**
	 * Performs the enqueue operation.
	 * @param x the item to enqueue
	 */
   public void enqueue(E x)
   {
   	stack1.push(x);
   }

   /**
    * Performs the dequeue operation.
    * @return the element that is dequeued, or null if empty queue
    */
	public E dequeue()
	{
		if (stack2.size() == 0)
		{
			while (stack1.size() > 0)
			{
				stack2.push(stack1.pop());
			}
		}
		return stack2.pop();
	}

   /**
    * Checks if the Queue is empty.
    * @return true if the queue is empty, false if not
    */
   public boolean isEmpty()
   {
   	return stack1.size() == 0 && stack2.size() == 0;
   }

   /**
    * Returns the number of elements currently in the queue.
    * @return the number of elements currently in the queue
    */
   public int size()
   {
   	return stack1.size() + stack2.size();
   }
	
   MyStack<E> stack1;
   MyStack<E> stack2;
	
}
