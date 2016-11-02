/******************************************
/ TwoStackQueue.java 
/ By Sungmin An (UNI: sa3333)
/ To implement the MyQueue ADT from using two 
/ completely separate stacks.
******************************************/

public class TwoStackQueue<AnyType> implements MyQueue<AnyType>{

	/* Instance Variables. */
	private MyStack<AnyType> S1, S2; 
	private int size; 
	private int whoseTurn;

	/* Constructor initializes IVs. */
	public TwoStackQueue(){
		S1 = new MyStack<>(); 
		S2 = new MyStack<>(); 
		size = 0;  
	}

	/* Performs the enqueue operation via push on stack 1. 
	   @param AnyType x. 
	*/
	public void enqueue(AnyType x){
		S1.push(x);
		size++; 
	}

	/* Performs the dequeue operation via pop() on stack 2. 
	   If one attempts to dequeue an already empty queue, 
	   returns null. @return AnyType. 
	*/
	public AnyType dequeue(){
		if (isEmpty()){
			return null; 
		}
		else{
			/* Pop from S2 if it's not empty. Else,
			   move everything from S1 to S2 and pop
			   from S2
			*/ 
			if(!S2.empty()){
				size--; 
				return S2.pop();
			}
			else{
				/* Copies over all elements in S1 into S2 so
				   that the order of elements is reversed.
				*/ 
				while(!S1.empty()){
					S2.push(S1.pop());
				}
				size--;
				return S2.pop(); 
			}
		}
	}

	/* Checks if the Queue is empty. 
	   @return boolean size() == 0. 
	*/
	public boolean isEmpty(){
		return size() == 0; 
	}

	/* Returns the number of elements currently in the Queue. 
	   @return int size. 
	*/
	public int size(){
		return size; 
	}
}