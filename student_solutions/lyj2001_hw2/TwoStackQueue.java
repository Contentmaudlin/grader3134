/******************************************************************************
 * By: Lydia Jiang
 * Class: TwoStackQueue
 * Queue class made from two separate stacks
 ******************************************************************************/

import java.util.Stack;

public class TwoStackQueue <AnyType> implements MyQueue<AnyType>{

	private Stack<AnyType> in = new Stack<AnyType>();
    private Stack<AnyType> out = new Stack<AnyType>();
	
	/*
	 * @name enqueue
	 * @param AnyType x
	 * @return void
	 * 
	 * Adds AnyType x to the in stack
	 */
	public void enqueue(AnyType x) {
		in.push(x);
	}

	/*
	 * @name dequeue
	 * @param none
	 * @return AnyType
	 * 
	 * Removes element from out stack, returns removed element
	 * Returns null if both stacks are empty
	 * If only out stack is empty, remove elements from in stack
	 * and add into out stack
	 * 
	 */
	public AnyType dequeue() {
		
		if (size()==0) 
		{
			System.out.println("Error: nothing to dequeue!");
        	return null;
		}
		
		else if (out.isEmpty()) {
            while (!in.isEmpty()) {
               out.push(in.pop());
            }
        }
		return out.pop();
      
	}

	/*
	 * @name isEmpty
	 * @param none
	 * @return boolean
	 * 
	 * Return true if both stacks are empty, false otherwise
	 */
	public boolean isEmpty() {
		if(in.isEmpty() && out.isEmpty())
			return true;
		return false;
	}

	/*
	 * @name size
	 * @param none
	 * @return int
	 * 
	 * Returns the size the queue
	 */
	public int size() {
		int s = 0;
		s = in.size() + out.size();
		return s;
	}

}

