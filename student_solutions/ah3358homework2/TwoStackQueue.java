/**
 * Name: Anlan Huang  UNI: ah3358
 *
 * Build a queue out of two completely separate stacks, S1 and S2. Enqueue
 * operations happen by pushing the data on to stack 1. Dequeue operations
 * are completed with a pop from stack 2. Using only push and pop operations.
 * The class TwoStackQueue provides the Queue ADT using two stacks and
 * explicitly implement the interface.
 *
 * Created by anlan on 9/30/16.
 */

public class TwoStackQueue <AnyType> implements MyQueue<AnyType>{
    private MyStack<AnyType> stack1 = new MyStack<AnyType>();
    private MyStack<AnyType> stack2 = new MyStack<AnyType>();
    private int size;

    // Performs the enqueue operation
    public void enqueue(AnyType x){
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }

        stack1.push(x);
        size++;

        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }

    }

    // Performs the dequeue operation. For this assignment, if attempt to dequeue an already empty queue, you should return null
    
    public AnyType dequeue(){
        if(!stack2.isEmpty()) {
            size--;
            return stack2.pop();
        }
        return null;
    }

    // Checks if the Queue is empty
    public boolean isEmpty(){
        return size == 0;
    }

    // Returns the number of elements currently in the queue
    public int size(){
        return size;
    }
}
