import java.util.LinkedList;

/**
 * Name: Victor Au
 * UNI: va2239
 * COMS W3134
 * 
 * Homework 2
 * Programming #1: Symbol Balancing
 */
public class MyStack<anyType> {
    private LinkedList<anyType> list;

    /**
     * Constructor for objects of class MyStack
     */
    public MyStack() {
        list = new LinkedList<>();
    }
    
    /**
     * Mutator method.
     * "Pushes" an element x to the top of the stack.
     */
    public void push(anyType x) {
        list.addFirst(x);
    }
    
    /**
     * Returns element at topOfStack before decrementing topOfStack.
     * If stack is empty, prints it and then returns null.
     */
    public anyType pop() {
        if (list.size() > 0) {
            return list.removeFirst();
        } else {
            System.out.println("The stack is empty!");
            return null;
        }
    }
    
    /**
     * Accessor method.
     * @return element located at topOfStack index.
     * If stack is empty, prints it and returns null.
     */
    public anyType peek() {
        
        if (list.size() > 0) {
            return list.getFirst();
        } else {
            System.out.println("The stack is empty!");
            return null;
        }
    }
    
    /**
     * Accessor method.
     * @return true if stack is empty.
     */
    public boolean isEmpty() {
        if (list.size() == 0) {
            return true;
        }
        return false;
    }
    
    /**
     * Accessor method.
     * @return size of the stack.
     */
    public int size() {
        return list.size();
    }
    
    public String toString() {
        if (list.size() == 0) {
            return "The list is empty.";
        } else {
            for (anyType item : list) {
                System.out.println(item);
            }
            return null;
        }
    }
}
