
public class TwoStackQueue<AnyType> implements MyQueue<AnyType>{

	//Creates two stacks that will create the queue
	MyStack<AnyType> S1 = new MyStack<AnyType>();
	MyStack<AnyType> S2 = new MyStack<AnyType>();
	//creates integers that will mark the front and back of the queue
	//back and front are incremented everytime to keep size current
	int back = 0;
	int front = 0;
	
	//adds element to stack one which enqueues the element
	@Override
	public void enqueue(AnyType x) {
		S1.stackPush(x);
		back++;
	}

	//Checks if stack two is empty, if it is the elements in stack one are popped over
	//this reverses their order and allows for them to be dequeued one at a time
	//also checks if both are empty in order to return null
	//if stack two isn't empty it just dequeues the element of the top
	@Override
	public AnyType dequeue() {
		if (S2.isEmpty() == true) {
			if (S1.isEmpty() == true ) {
				return null;
			}
			else while (S1.isEmpty() != true) {
				S2.stackPush(S1.stackPop());
				back--;
				front++;
			}
			front--;
			return S2.stackPop();
		}
		else {
			front--;
			return S2.stackPop();
		}
	}

	//adds a way to check if the queue is empty based off of the stacks isEmpty() method
	@Override
	public boolean isEmpty() {
		if (S1.isEmpty() == true && S2.isEmpty() == true) {
			return true;
		}
		else {
			return false;
		}
	}

	//uses the front and back markers to return the size of the whole queue
	@Override
	public int size() {
		return front + back;
	}

}
