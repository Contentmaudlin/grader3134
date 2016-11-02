/**
 * Created by ShuqiChen on 16/10/2.
 */
import java.util.NoSuchElementException;

public class TwoStackQueue<AnyType> implements MyQueue<AnyType>{
    private MyStack<AnyType> stack1; //back of the queue
    private MyStack<AnyType> stack2; //front of the queue

    //constructor
    public TwoStackQueue() {
        stack1 = new MyStack<>();
        stack2 = new MyStack<>();
    }

    public boolean isEmpty() {
        return (stack1.isEmpty() && stack2.isEmpty());
    }

    public int size() {
        return (stack1.size() + stack2.size());
    }

    //move the elements in stack1 to stack2
    //which might be useful when do dequeue
    public void moveStack1ToStack2() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }

    //push new element into stack1
    public void enqueue(AnyType i) {
        stack1.push(i);
    }

    //before dequeue, we have to check whether the queue is empty
    //then check whether stack2 is empty
    //if stack2 is empty, then move elements in stack1 to stack2
    //return stack2.pop()
    public AnyType dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException ("the queue is empty already");
        }
        else if (stack2.isEmpty()) {
            moveStack1ToStack2();
        }
        return stack2.pop();
    }

}
