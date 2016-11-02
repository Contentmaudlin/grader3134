/*
 * Name: Pranav Arora
 * UNI: pa2450
 * Description: This is a LinkedList implementation of a stack. It uses
 * list operations but not stack operations directly like push() or pop()
 * 
 */

import java.util.LinkedList;

public class MyStack <AnyType>{
	
	LinkedList<AnyType> myList = new LinkedList<>();
	
	public void push(AnyType data){
		myList.add(data);
	}
	
	public AnyType pop(){
		return (myList.removeLast());
	}
	
	public int size(){
		return myList.size();
	}

}
