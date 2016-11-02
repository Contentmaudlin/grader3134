/* Author: Seungwook Han
 * UNI: sh3264
 * Data Structures
 * TwoStackQueue - This class creates two stacks inStack (for input) and
 * outStack (for output) in order to implement the Queue by adequately transferring
 * the data from the inStack to the outStack and popping when dequeued
 */

public class TwoStackQueue<AnyType> implements MyQueue<AnyType> {

	private MyStack<AnyType> inStack;
	private MyStack<AnyType> outStack;

	// This constructor creates two MyStack stacks, one for input and another for output
	
	public TwoStackQueue() {
		inStack = new MyStack<>();
		outStack = new MyStack<>();
	}

	/* This method pushes the item into the inStack (input stack)
	 * @param item is the object being used in the Queue
	 */
	@Override
	public void enqueue(AnyType item) {
		inStack.push(item);
	}

	/* This method pops the inStack and pushes it onto the outStack
	 * when the inStack is not empty
	 * @return returns null if the inStack is empty (meaning no inputs yet)
	 * and returns the latest object that was pushed onto the outStack
	 *
	 */
	@Override
	public AnyType dequeue() {
		if (outStack.size() == 0) {
			if (inStack.size() == 0) {
				return null;
			}

			while (inStack.size() != 0) {
				outStack.push(inStack.pop());
			}
		}
		return outStack.pop();
	}

	/* This method checks if Queue (defined by the combination of inStack
	 * and outStack stacks) is empty
	 * @return boolean, true if the size if 0 and false if otherwise
	 */
	@Override
	public boolean isEmpty() {
		if (size() == 0) {
			return true;
		} else {
			return false;
		}
	}

	/* This method checks the size of the Queue by adding the sizes
	 * of the inStack and outStack
	 * @return int of the sum of the inStack and outStack sizes
	 */
	@Override
	public int size() {
		return inStack.size() + outStack.size();
	}

}
