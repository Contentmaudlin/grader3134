/* Trung Vu
 * UNI: ttv2107
 * COMS W3134
 * Instructor: Professor Blaer
 * Homework 2
 * October 7th, 2016
 */

/* This implementation of the queue abstract data type uses
 * 2 stacks: a reverse stack and forward stack.
 * 
 * The method for the queue data type are implementation as follows:
 * A. Enqueue(x): x is pushed into the forward stack.
 * B. Dequeue(): If the reverse stack is not empty, pop the first item from
 * the reverse stack. If it is empty, pop all items from the forward stack 
 * and push them into the reverse stack (one by one), then pop the first item
 * from the reverse stack.
 * C. size(): return the sum of the sizes of the two stacks
 * D. empty(): return (size() == 0)
 */

public class TwoStackQueue<T> implements MyQueue<T> {
    private MyStack<T> forwardStack;
    private MyStack<T> reverseStack;
    
    public TwoStackQueue() {
       forwardStack = new MyStack<>();
       reverseStack = new MyStack<>();
    }

    public void enqueue(T x) {
        forwardStack.push(x);
    }

    public T dequeue() {
        if (reverseStack.empty()) {
            while (!forwardStack.empty()){
               reverseStack.push(forwardStack.pop());
            }
        }

       return reverseStack.pop();
    }

    public int size() {
       return (forwardStack.size() + reverseStack.size());
    }

    public boolean isEmpty() {
       return (size() == 0);
    } 
}
