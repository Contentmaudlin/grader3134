import java.util.*;

public class TwoStackQueue<AnyType extends Comparable<AnyType>> implements MyQueue<AnyType>{
	
	private MyStack<AnyType> stack1;
	private MyStack<AnyType> stack2; 
	
	public TwoStackQueue(){
		stack1 = new MyStack<AnyType>();
		stack2 = new MyStack<AnyType>();
	}
    // Checks if the Queue is empty
    public boolean isEmpty(){
    	if (size() == 0)
    		return true;
    	else
    		return false;
    }

    // Returns the number of elements currently in the queue
    public int size(){
    	return stack1.getSize() + stack2.getSize();
    }
    
    // Performs the enqueue operationl
    public void enqueue(AnyType x){
    	stack1.push(x);
    }

    // Performs the dequeue operation. For this assignment, if you
    // attempt to dequeue an already empty queue, you should return
    // null
    public AnyType dequeue(){
    	if( isEmpty() )
    		return null;
    	else if(stack2.isEmpty()){
    		//Here is how I decide to make the input stack to the output stack.
    		while( !stack1.isEmpty()){
    			stack2.push(stack1.pop());
    		}	
    	}
    	return stack2.pop();
    }

    //I was using this to debug my code.
    public String toString(){
    	String s = "\n---- Stacks -----!!! \n "+ stack1 + "\n " + stack2 + "\n ----------------";
    	return s;
		}
    

}
