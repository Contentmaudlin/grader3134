// **************************************************
// MyStack.java
// October 10, 2016
// Written by Aaron Friedman --> amf2234
//
// A stack class that uses a linked list
// and has push and pop methods only  
// **************************************************
import java.util.LinkedList;

public class MyStack<AnyType> {
    private int top;
    private LinkedList<AnyType> list;

    public MyStack() {
        //top here represents the last used space, not the first unused space
        top = -1;
        list = new LinkedList<>();
    }

    public void push(AnyType element) {
        list.add(element);
        top ++;
    }

    public AnyType pop() {
        if (top < 0)
            return null; //return null if an empty stack is popped
        else {
            AnyType popped = list.remove(top);
            top --;
            return popped;
        }
    }

    public AnyType peek() {
        if (top < 0)
            return null; //return null if an empty stack is peeked
        else
            return list.get(top);
    }

    public int size() {
        return top + 1;
    }

    public boolean isEmpty() {
        if (top < 0)
            return true;
        else
            return false;
    }
}