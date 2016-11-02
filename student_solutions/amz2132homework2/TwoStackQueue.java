/*
 * Angela Zhang
 * amz2132
 * COMS 3134 Data Structures
 * TwoStackQueue class for Homework 2
 * This class creates a queue using two stacks. The stack implementation from programming problem 1 is utilized.
 */

public class TwoStackQueue<AnyType> extends MyStack <AnyType> implements MyQueue<AnyType>
{
	//create input and output stacks
	private MyStack<AnyType> input= new MyStack<AnyType>();
	private MyStack<AnyType> output = new MyStack<AnyType>();
	
	//performs the enqueue operation
	public void enqueue(AnyType x)
	{
		input.push(x);	
	}

	//performs dequeue operation
	public AnyType dequeue()
	{
		//if the output stack is empty, then move the contents from the input stack from most recent addition
		//to earliest addition
		if(output.isEmpty())
		{
			while (!input.isEmpty())
			{
				output.push(input.pop());
			}
			//once while loop is completed, input stack is empty
		}
		//returns the top of the output stack
		return output.pop();
	}
	
	//returns a boolean that determines if the queue is empty or not
	public boolean isEmpty()
	{
		//if both lists are empty, then the queue is empty
		if (input.isEmpty()&&output.isEmpty())
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	//returns the size of the whole queue
	public int size()
	{
		//the sum of both the input and output sizes gives the size of the whole queue
		return input.size() + output.size();
	}

}
