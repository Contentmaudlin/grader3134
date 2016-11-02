//Name: Yiwei Lian
//UNI: yl3434
//Date: 10/10
//Assignment: HW2
import java.util.LinkedList;

public class TwoStackQueue<AnyType> implements MyQueue<AnyType> {
	
	//two stacks as instance variables
	public MyStack<AnyType> S1 = new MyStack<AnyType>(new LinkedList <AnyType>
	());
    public MyStack<AnyType> S2 = new MyStack<AnyType>(new LinkedList <AnyType>
    ());

	// Performs the enqueue operations
	public void enqueue(AnyType x){
		S1.push(x);
	}

	// Performs the dequeue operation. For this assignment, if you
	// attempt to dequeue an already empty queue, you should return
	// null
	public AnyType dequeue(){
        if (S2.isEmpty()) {
        	moveS1ToS2();
        	return null;
        }
        return S2.pop();
	}

	// Checks if the Queue is empty
	public boolean isEmpty(){
		return S1.isEmpty() && S2.isEmpty();
	}

	// Returns the number of elements currently in the queue
	public int size() {
		return S1.size() + S2.size();
	}
	
	//move elements from S1 to S2
	public void moveS1ToS2() {
        while (!S1.isEmpty())
            S2.push(S1.pop());
    }
}
