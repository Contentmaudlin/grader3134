/* Christophe Rimann
 * cjr2185
 * MyStack.java
 * Description: A simple implementation of the Stack ADT using the 
 * linkedlist built into Java
 */

import java.util.LinkedList;
public class MyStack<AnyType> {
	private LinkedList<AnyType> list = new LinkedList<AnyType>();
	private int length;
	
	//Constructor just sets length to 0
	public MyStack(){
		length = 0;
	}
	
	/*
	 * Push adds the addition to the stack and increases the length
	 * @param addition: thing to add to the stack
	 * @return true if the addition was succesful 
	 */
	public boolean push(AnyType addition){
		list.add(addition);
		length++;
		return true;
	}
	
	/*
	 * Method that removes the last element from the list and returns it
	 * @Return the top value on the stack
	 */
	public AnyType pop(){
		try{
			return list.remove(--length);
		} catch (java.lang.IndexOutOfBoundsException e){
			throw e;
		}
	}
	
	/*
	 * Method to return the last element
	 * @return the top value on the stack
	 */
	public AnyType peek(){
		try{
			return list.get(length-1);
		} catch(java.lang.IndexOutOfBoundsException e){
			throw e;
		}
	}
	
	/*
	 * Method to get size of stack
	 * @return size of stack
	 */
	public int size(){
		return length;
	}
	
	/*
	 * Method to check if the stack is empty or not
	 * @return true if empty, false otherwise
	 */
	public boolean isEmpty(){
		return (length==0);
	}
}
