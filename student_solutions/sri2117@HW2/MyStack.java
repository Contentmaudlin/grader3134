/*********************
Sunand Iyer
sri2117
This is a class for 
implementing a stack
**********************/


import java.util.LinkedList;

public class MyStack<AnyType>{

	//instance variable
	public LinkedList<AnyType> stack;

	public MyStack(){

		//instantiating instance variable
		stack = new LinkedList<AnyType>();
	}

	public void push(AnyType x){

		//adding element at 0th index
		stack.add(0,x);
	}

	public AnyType pop(){

		//if stack is empty, just return null
		if (stack.size() == 0){
			return null;
		} else {
		//otherwise just remove the first element 
		//and return it
		return stack.remove(0);

		}
	}

	public AnyType peek(){

		//return null if empty stack
		if (stack.size() == 0){
			return null;
		} else {
			//get the item but not remove it
			return stack.get(0);	
		}
		
	}

	public boolean isEmpty(){

		//check if empty
		return stack.isEmpty();
	}

	public int size(){

		//return size
		return stack.size();
	}
}