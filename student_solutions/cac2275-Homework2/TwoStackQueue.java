//*******************************************************************
//Christian Cruz Godoy
//COMSW 3134: TwoStackQueue class
//This is my generic class for my Two Stack Queue. 
//*******************************************************************

public class TwoStackQueue<Anytype> implements MyQueue 
{
	//I create two distinct stacks since its a two stack queue
	MyStack<String> firstStack = new MyStack<String>();
	MyStack<String> secondStack = new MyStack<String>();
	
	private int theSize;
	public String st;
	private String firstEnqueue;
	private String firstDequeue;
	
	//This is just my constructor
	public TwoStackQueue()
	{
		st = null;
	}
	
	//This dequeue method decreases the size of the queue by one
	//each time its called. It then takes the first stack and
	//removes the elements and adds them two the secondstack until 
	//there is only one left in the first stack. Then it returns the
	//last element in the first stack.
	public String dequeue()
	{
		theSize--;
		if(firstStack.size() + secondStack.size() ==0)
		{
			return null;
		}
		
		else if(secondStack.size()==0)
		{
			while(firstStack.size()>1)
			{
				firstDequeue = firstStack.remove();
				secondStack.add(firstDequeue);
			}
			
			return firstStack.remove();
		}
			
		else
		{
			return secondStack.remove();
		}	
		
	}
	
	//This method checks if the queue is empty. It does this by checking
	//that the sum of the sizes of both stacks are zero.
	public boolean isEmpty()
	{
		
		if(firstStack.size() + secondStack.size() == 0)
		{
			return true;
		}
		else return false;
	}
	
	//This method returns the size of the stack by just adding the sizes
	//of the first and second stack.
	public int size()
	{
		theSize = firstStack.size() + secondStack.size();
		return theSize;
	}
	
	//This method just adds the enqueued object to the first stack.
	public void enqueue(Object x) 
	{
		String firstEn = (String) x;
		firstEnqueue = firstEn;
		firstStack.add(firstEnqueue);
		theSize++;
	}	
}

