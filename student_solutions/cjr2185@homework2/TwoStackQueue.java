/* Christophe Rimann
 * cjr2185
 * TwoStackQueue.java
 * A queue made up of 2 stacks that enqueues to one stack and dequeues to 
 * another.
 */
public class TwoStackQueue<AnyType> implements MyQueue<AnyType> {
	private MyStack<AnyType> S1 = new MyStack<AnyType>();
	private MyStack<AnyType> S2 = new MyStack<AnyType>();
	private int length;

	// Constructor just initializes length
	public TwoStackQueue() {
		length = 0;
	}

	/*
	 * enqueue pushes the addition to the enqueue stack S1, increases length.
	 * (non-Javadoc)
	 * @see MyQueue#enqueue(java.lang.Object)
	 * @param addition new element to add
	 */
	public void enqueue(AnyType addition) {
		S1.push(addition);
		length++;
	}

	/*
	 * dequeue checks to see if there's anything in the dequeue stack; if there
	 *  is, it just pops that element. If there isn't, it dumps the entirety of
	 *  the enqueue stack into the dequeue stack, and decreases the length. if
	 *  both are empty, returns null
	 *  (non-Javadoc)
	 * @see MyQueue#dequeue()
	 * @return first element in queue
	 */
	public AnyType dequeue() {
		if (S2.isEmpty()) {
			if (S1.isEmpty()) {
				return null;
			}
			while (!S1.isEmpty()) {
				S2.push(S1.pop());
			}
		}
		length--;
		return S2.pop();
	}

	/*
	 * Method to check if both stacks are empty
	 * (non-Javadoc)
	 * @see MyQueue#isEmpty()
	 * @return boolean stating whether or not queue is empty
	 */
	public boolean isEmpty() {
		return S1.isEmpty() && S2.isEmpty();
	}

	/*
	 *  get method that returns size of queue
	 *  (non-Javadoc)
	 * @see MyQueue#size()
	 * @return length: length of queue
	 */
	public int size() {
		return length;
	}
}
