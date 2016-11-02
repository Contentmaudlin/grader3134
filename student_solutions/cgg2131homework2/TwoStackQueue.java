// TwoStackQueue.java
// Data Structures - Homework 2
// Connor Goggins

// Queue composed of two stacks implementing the MyQueue interface.
public class TwoStackQueue<T> implements MyQueue<T> {
  private MyStack<T> inStack;
  private MyStack<T> outStack;

  // Constructor initializes the two stack variables using objects of my stack class.
  public TwoStackQueue() {
    inStack = new MyStack<T>();
    outStack = new MyStack<T>();
  }

  public void enqueue(T x) {
    // Add the additional element to the input stack.
    inStack.push(x);
  }

  public T dequeue() {
    // First, check for an underflow error.
    if(inStack.isEmpty() == true && outStack.isEmpty() == true) {
      return null;
    }

    // If the output stack is empty, then push everything from the input stack to the output stack.
    if(outStack.isEmpty() == true) {
      while (inStack.top() != null) {
        outStack.push(inStack.pop());
      }
    }

    // Then, pop the output stack.
    return(outStack.pop());
  }

  public boolean isEmpty() {
    if(inStack.isEmpty() == true && outStack.isEmpty() == true) {
      return true;
    }
    else {
      return false;
    }
  }

  public int size() {
    return(inStack.size() + outStack.size());
  }
}
