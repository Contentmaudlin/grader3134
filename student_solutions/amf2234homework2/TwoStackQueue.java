// ***************************************************
// TwoStackQueue.java
// October 10, 2016
// Written by Aaron Friedman --> amf2234
//
// A queue class that uses the push and pull methods 
// of two distinct stacks to form a queue with its ADT
// ***************************************************
public class TwoStackQueue<AnyType> implements MyQueue<AnyType> {
    
    private MyStack<AnyType> S1;
    private MyStack<AnyType> S2;
    private int size;

    public TwoStackQueue() {
        S1 = new MyStack<AnyType>();
        S2 = new MyStack<AnyType>();
        size = 0;
    }

    public void enqueue(AnyType x) {
        S1.push(x);
        size ++;
    }

    public AnyType dequeue() {
        if ((S1.isEmpty()) && (S2.isEmpty()))
            return null; //return null if dequeueing an empty queue
        else {
            if (S2.isEmpty() == false) {
                size --;
                return (AnyType)S2.pop(); //change from Object to AnyType
            }
            else {
                while (S1.isEmpty() == false)
                    S2.push(S1.pop()); //S2 becomes the reverse of S1
                size --;
                return (AnyType)S2.pop(); //change from Object to AnyType
            }
        }
    }

    public boolean isEmpty() {
        if ((S1.isEmpty()) && (S2.isEmpty()))
            return false;
        else
            return true;
    }

    public int size() {
        return size;
    }
}