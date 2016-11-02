/* Paul Bloom
* pab2163
* Implements a stack using a doubly linked list. 
* Top of stack = last element in list
*/

import java.util.LinkedList;

public class MyStack<AnyType> {

LinkedList <AnyType> myList = new LinkedList<AnyType>();
	

	// empty constructor -- doesn't really need to do anything for now
	public MyStack (){
	}

	/**
	*Push method, adds object to end of the list
	*@param a, a an object of AnyType
	*/
	public void push(AnyType a){
		myList.add(a);
	}

	/**
	*Pop method -- pops the top of the stack, or the last element in the list 
	*@return an object of AnyType
	*/
	public AnyType pop(){
		return myList.remove(myList.size()-1);
	}

	/**
	*isEmpty method -- determines if stack is empty or not
	*@return a boolean, true means empty
	*/
	public boolean isEmpty(){
		boolean empty;
		if(myList.size() == 0){
			empty = true;
		}
		else{
			empty = false;
		}
		return empty;
	}


	/**
	*size method -- returns the number of elements in the stack
	*@return an integer of the stack size
	*/
	public int size (){
		return myList.size();
	}


	/**
	*peek method -- returns the top of the stack WITHOUT popping it
	*@return an object of type AnyType
	*/
	public AnyType peek() {
			return myList.get(myList.size()-1);
	}

}