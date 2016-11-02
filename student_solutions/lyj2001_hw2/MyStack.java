/******************************************************************************
 * By: Lydia Jiang
 * Class: MyStack
 * Stack class capable of handling any object reference
 ******************************************************************************/


import java.util.ArrayList;

public class MyStack <AnyType>{
	
	private ArrayList<AnyType> a;
	private int top;
	
	public MyStack() {
		a = new ArrayList<AnyType>();
		top  = -1;
	}
	
	/*
	 * @name push
	 * @param AnyType e
	 * @return void
	 * 
	 * Adds AnyType e to stack, increments top by one
	 */
	public void push(AnyType e) {
		a.add(e);
		top++;
	}
	
	/*
	 * @name pop
	 * @param none
	 * @return AnyType
	 * 
	 * Removes top element of stack, decrease top by one
	 * return the deleted element (null if stack is empty)
	 */
	public AnyType pop() {
		if(!isEmpty()) {
			AnyType removed = (AnyType) a.get(top);
			a.remove(top--);
			return removed;

		}
		else
		{
			System.out.println("The stack is empty");
		}
		return null;
	}
	
	/*
	 * @name peek
	 * @param none
	 * @return AnyType
	 * 
	 * Returns the top element of the stack, null if stack is empty
	 */
	public AnyType peek() {
		if (!isEmpty())
			return (AnyType) a.get(top);
		return null;
	}
	
	/*
	 * @name size
	 * @param none
	 * @return int
	 * 
	 * returns the size of the stack
	 */
	public int size() {
		return top;
	}
	
	/*
	 * @name isEmpty
	 * @param none
	 * @return boolean
	 * 
	 * Returns true if stack is empty, false otherwise
	 */
	public boolean isEmpty() {
		if (top == -1)
			return true;
		else
			return false;
	}

}

