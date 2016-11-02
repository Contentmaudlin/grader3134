/**
 * @author Zoe Gordin
 * zeg2103
 *
 * This class creates a queue from two MyStacks by utilizing the MyQueue interface
 */
@SuppressWarnings("unchecked")//deals with unchecked casting when compiling on the command line
public class TwoStackQueue<AnyType> implements MyQueue<AnyType> {
    MyStack<AnyType> S1 = new MyStack();//the first stack of the queue
    MyStack <AnyType> S2 = new MyStack();//the second stack of the queue

    public TwoStackQueue()
    {
        S1.setSize(0);
        S2.setSize(0);
    }
    // Performs the enqueue operation by pushing onto stack 1
    public void enqueue(AnyType x)
    {
        S1.push(x);
    }
    //Performs the dequeue operation by pushing from S1 to S2 and then popping from S2
    public AnyType dequeue() {

        if(S2.isEmpty()) {
            while (!S1.isEmpty()) {
                S2.push(S1.pop());
            }
        }
            return S2.pop();


    }
    // Checks if the Queue is empty
    public boolean isEmpty()
    {
        if(S1.isEmpty() && S2.isEmpty())
        {
            return true;
        }
        else
        {
            return false;
        }

    }
    // Returns the number of elements currently in the queue
    public int size()
    {
        return S1.getSize() + S2.getSize();

    }
}
