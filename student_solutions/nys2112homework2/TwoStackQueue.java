//Natalie Sayegh
//October 10
//Programming 1
//Implements a generic queue using two stacks

public class TwoStackQueue<AnyType> implements MyQueue<AnyType> {
	MyStack<AnyType> S1 = new MyStack<>();
	MyStack<AnyType> S2 = new MyStack<>();
	
	// Performs the enqueue operation
		public void enqueue(AnyType x) {
			S1.push(x);
		}

		// Performs the dequeue operation. For this assignment, if you
		// attempt to dequeue an already empty queue, you should return
		// null
		public AnyType dequeue() {
			if(this.isEmpty()) {
				return null;
			}
			else {
				AnyType element;
				while(!S1.isEmpty()) {
					S2.push(S1.pop());
				}
				element = S2.pop();
				while(!S2.isEmpty()) {
					S1.push(S2.pop());
				}
				return element;
			}
		}

		// Checks if the Queue is empty
		public boolean isEmpty() {
			return S1.isEmpty();
		}

		// Returns the number of elements currently in the queue
		public int size() {
			return S1.size();
		}
}

