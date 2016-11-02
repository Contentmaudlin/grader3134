import java.util.*;

/**
 * @author Zoe Gordin
 * zeg2103
 *
 * This LinkedList has stack properties written for it
 */
public class MyStack<AnyType>
{
    private int size;//the size of the stack
    private LinkedList<AnyType> stack = new LinkedList<AnyType>();

    /**
     * adds an element to the top of the stack
     * @param newElement the element to be added
     */
    public void push(AnyType newElement)
    {
        stack.addFirst(newElement);
    }

    /**
     * removes an element from the top of the stack
     * @return the top element
     */
    public AnyType pop()
    {
        if(!stack.isEmpty())
        {
          return stack.removeFirst();
        }
        else
        {
            return null;
        }
    }

    /**
     * examines the element on top of the stack without removing it
     * @return the top element
     */
    public AnyType peek()
    {
        if(!stack.isEmpty())
        {
            return stack.get(stack.size());
        }
        else
        {
            return null;
        }
    }

    /**
     * checks if the stack is empty
     * @return true if the stack is empty, false if not
     */
    public boolean isEmpty()
    {
        return stack.isEmpty();
    }

    /**
     * gets the size of the stack
     * @return the size of the stack
     */
    public int getSize()
    {
        return stack.size();
    }

    /**
     * sets the size of the stack
     * @param s the intended stack size
     */
    public void setSize(int s)
    {
        this.size = s;
    }
}
