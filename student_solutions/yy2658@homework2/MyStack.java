//yy2658
//Yilun Ying
//MyStack
//implements a stack using a linked list

import java.util.LinkedList;

public class MyStack<AnyType> {
	
	LinkedList<AnyType> myStack;
	int lastEmpty;
	
	public MyStack(){
		myStack = new LinkedList<AnyType>();
		lastEmpty = 0;
	}
	
	public void push(AnyType e){
		myStack.add(lastEmpty, e);
		lastEmpty++;
	}
	
	public AnyType pop(){
		if(lastEmpty<=0){
			throw new ArrayIndexOutOfBoundsException();
		}
		AnyType dataToReturn;
		dataToReturn = myStack.get(lastEmpty-1);
		lastEmpty--;
		return dataToReturn;
	}
	
	
	
	public int sizeOfStack(){
		return lastEmpty;
	}
	
	public AnyType peek(){
		return myStack.get(lastEmpty-1);
	}

}
