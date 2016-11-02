
/* Data Structures Fall 2016
 * Homework 2
 * Class provides the usual stack methods using arraylist operations. 
 * @author Natasha Porter
 */
import java.util.ArrayList;

public class MyStack<AnyType>{
	
	private ArrayList<AnyType> stack; //stack from an arraylist
	private int topOfStack; 

	public MyStack() {
		stack = new ArrayList<>(); //create stack 
		topOfStack = -1;
	
	}
	
	public void push(AnyType x){  //push items onto stack
		topOfStack++;
		stack.add(x);
	}
	
	public AnyType pop(){ //pop items from stack
		return stack.get(topOfStack--);
	}
	
	public int peek() { //view topOfStack
		return topOfStack;
	}
	
	public boolean isEmpty(){ //check if stack is empty
		if(stack.size() == 0)
				return true;
		else
			return false;	
	}
	
	public int getSize(){ //check size of stack
		return stack.size();
	}
}
	
