/* Tianwu Wang
 * tw2576
 * MyStack.java
 * generic stack class 
 * provide pop, push, size, isEmpty methods
 */

import java.util.*; 

public class MyStack<AnyType>{
		
	LinkedList<AnyType> myList = new LinkedList<AnyType>();	 //create a LinkedList called myList	
	
	public int size(){                 //get the size of the stack
		return myList.size();
	}
	
	public AnyType push(AnyType data){  //push data to the end of the list
		 myList.add(myList.size(), data);
		 return data;
	}
	
	public AnyType pop(){      		//pop the data at the end of the list if it is nonempty
		if(myList.size() == 0){
			throw new EmptyStackException();
		}else{
			return myList.remove(myList.size()-1); 
		}
	}
	
	public boolean isEmpty(){ 		//check if the list is empty
		return myList.size() == 0;
	}
}