
/**
 * Name: Victor Au
 * UNI: va2239
 * COMS W3134
 * 
 * Homework 2
 * Programming #2a: Two Stack Queue
 */
public class TwoStackQueue<anyType> implements MyQueue<anyType> {
    MyStack<anyType> stack1 = new MyStack<>();
    MyStack<anyType> stack2 = new MyStack<>();
    
    /**
     * Constructor.
     */
    public TwoStackQueue() {}
    
    /**
     * Mutator method.
     * Performs the enqueue operation (pushes x to stack1).
     * It pushes to stack1 because this approach (my original approach,
     *   as detailed in README) usually stores the elements in stack1.
     */
    public void enqueue(anyType x) {
        stack1.push(x);     // pushes to stack1, the normal "queue"
    }
    
    /**
     * Performs the dequeue operation.
     * @return the oldest remaining element in the queue via pop(),
     *   whether it's in stack1 or stack2.
     * It does this via transferring stack1's elements to stack2
     *   (which reverses the order of the elements), capturing the
     *   popped element's info in returnElement, transferring the
     *   elements from stack2 back to stack1, and then returning
     *   returnElement. The elements only go to stack2 when I
     *   call dequeue(), and they do so temporarily!
     * @return null if the queue (basically stack1) is empty.
     */
    public anyType dequeue() {
        if (stack1.isEmpty()) {
            return null;        // if queue is empty
        } else {
            transferStackElements(stack1, stack2);  // xfers over
            anyType returnElement = stack2.pop();   // pops stack2
            transferStackElements(stack2, stack1);  // xfers back
            return returnElement;       // returns element popped
        }
    }
    
    /**
     * Mutator method.
     * Moves firstStack's elements to secondStack via push/pop methods.
     * It pops from stack1 and then pushes that element to stack2, and
     *   it does this until stack1 is empty.
     * (This reverses the order of the elements!)
     */
    private void transferStackElements(MyStack<anyType> firstStack,
    MyStack<anyType> secondStack) {
        while (!firstStack.isEmpty()) {
            secondStack.push(firstStack.pop());
        }
    }
    
    /**
     * Accessor method.
     * @return boolean of whether the queue is empty.
     */
    public boolean isEmpty() {
        if (stack1.size() == 0) {
            return true;
        }
        return false;
    }
    
    /**
     * Accessor method.
     * @return int number of elements in the queue.
     */
    public int size() {
            return stack1.size();
    }
}
