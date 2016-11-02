//rjs2204, Ravi Sinha

public class TwoStackQueue<E> implements MyQueue<E> {
	//creating two generic stacks
	private MyStack<E> stack1;    
	private MyStack<E> stack2;   
	//constructor
	public TwoStackQueue () {
		stack1 = new MyStack<E>();
		stack2 = new MyStack<E>();
	}
	//creating enqueue method which pushes(adds) onto stack
	public void enqueue (E item)
	{
		stack1.push(item);   
	}

	//creating dequeue method 
	public E dequeue() {
		if (stack2.isEmpty() && !stack1.isEmpty())
		{
			//push from stack 1 to stack 2 if stack 2 is empty
			while (!stack1.isEmpty())
			{
				stack2.push (stack1.pop());
				//push onto stack 2 whatever is being popped from stack 1

			}
			return stack2.pop();

		}
		else 
			return stack2.pop();
	}

	// Checks if the Queue is empty
	public boolean isEmpty() {
		return stack1.isEmpty() && stack2.isEmpty();
	}

	// Returns the number of elements currently in the queue
	public int size() {
		return stack1.size() + stack2.size();
	}
}
