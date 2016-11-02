///* Nishant Puri
// * np2577
// * HW2
// * TwoStackQueue.java: Creates a Queue using two stacks
// */
import java.util.LinkedList;

public class TwoStackQueue<AnyType> implements MyQueue<AnyType> {

	private MyStack<AnyType> S1;
	private MyStack<AnyType> S2;

	public TwoStackQueue() {
		S1 = new MyStack<AnyType>();
		S2 = new MyStack<AnyType>();
	}

	public void enqueue(AnyType x) {
		S1.push(x);
	}

	
	//if S2 is non empty it has the next element that needs to be dequeued. 
	// If it is empty then the next element is at the bottom of stack S1.
	public AnyType dequeue() {
		if (!S2.isEmpty()) {
			return S2.pop();
		} else if (!S1.isEmpty()) {
			transfer();
			return S2.pop();
		} else {
			System.out.println("Error: Can't dequeue because queue is empty");
		}
		return null;
	}

	//one by one pop each element off S1 and put on S2
	private void transfer() {
		while (!S1.isEmpty()) {
			AnyType x = S1.pop();
			S2.push(x);
		}
	}

	public boolean isEmpty() {
		return (S1.isEmpty() & S2.isEmpty());
	}

	public int size() {
		return (S1.size() + S2.size());
	}
}
