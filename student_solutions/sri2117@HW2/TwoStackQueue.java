/*********************
Sunand Iyer
sri2117
This is a class for 
implementing a queue
with 2 stacks
**********************/


public class TwoStackQueue<AnyType> implements MyQueue<AnyType>{

	//instance variables
	private MyStack<AnyType> S1;
	private MyStack<AnyType> S2;


	public TwoStackQueue(){

		//instantiating instance variables;
		S1 = new MyStack<AnyType>();
		S2 = new MyStack<AnyType>();
	}

	public void enqueue(AnyType x){

		//pushing the value onto the first stack
		S1.push(x);
	}

	public AnyType dequeue(){

		//check to see if output stack is empty
		if (S2.isEmpty()){
			//reverse input stack onto output stack
			//puts first element on top of output stack
			while (!S1.isEmpty()){
				S2.push(S1.pop());
			}
		}
		//return null if output stack is still empty
		if (S2.isEmpty()){
			return null;
		} else {
			return S2.pop();
		}
		
	}

	public boolean isEmpty(){

		//check to see if both stacks are empty
		return S2.isEmpty() && S2.isEmpty();
	}

	public int size(){

		//add up the sizes to get size of queue
		return S2.size() + S1.size();
	}
}