/* Name : Peter Drake
 * UNI : pjd2132
 *  
 *  MyStack.java - Provides necessary methods for HW2 in order
 *  to use stacks.
 */
import java.util.LinkedList;

public class MyStack<AnyType> {
    
    //Contains the actual stack
    private LinkedList<AnyType> stack = new LinkedList<AnyType>();
    
    public AnyType pop(){
        //Returns the top of the stack and removes that element
        AnyType temp = stack.getFirst();
        stack.removeFirst();
        return (temp);
    }
    
    public void push(AnyType element){
        //Adds an element to the top of the stack
        stack.addFirst(element);
    }
    
    public AnyType top(){
        //Returns the element on top of the stack
        return (stack.getFirst());
    }
    
    public int getSize(){
        //Returns the number of elements in the stack
        return (stack.size());
    }
    
    public boolean isEmpty(){
        //Returns boolean that shows if stack is empty
        return (stack.size() == 0);
    }
}