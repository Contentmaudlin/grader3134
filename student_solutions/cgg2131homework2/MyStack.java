// MyStack.java
// Data Structures - Homework 2
// Connor Goggins

import java.util.LinkedList;

public class MyStack<AnyType> {
  // My generic implementation of a stack as a linked list.
  private LinkedList<AnyType> newStack;
  private int size;

  // Constructor initializes the stack object as a linked list and the size to 0.
  public MyStack() {
    newStack = new LinkedList<AnyType>();
    size = 0;
  }

  public void push(AnyType x) {
    newStack.add(0, x);
    size++;
  }

  public AnyType pop() {
    // Check for underflow exception.
    if (size < 1) {
      System.out.println("Error: Underflow - cannot pop an empty stack.");
      return null;
    }
    else {
      size--;
      return(newStack.remove());
    }
  }

  public boolean isEmpty() {
    if (size < 1) {
      return true;
    }
    else {
      return false;
    }
  }

  public AnyType top() {
    if (size < 1) {
      return null;
    }
    else {
      return(newStack.get(0));
    }
  }

  public int size() {
    return size;
  }
}
