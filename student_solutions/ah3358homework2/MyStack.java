/**
 * Name: Anlan Huang   UNI: ah3358
 *
 * Own stack class that uses java.util.LinkedList as an instance variable in
 * the MyStack class, but only allowed to use its basic list operations, not
 * the stack operations themselves.
 *
 * Created by anlan on 9/28/16.
 */

import java.util.LinkedList;

public class MyStack<AnyType> {

    // Instantiate a Linkedlist for the stack
    private LinkedList<AnyType> list = new LinkedList<AnyType>();
    private int size;

    // Push the element to the first place
    public void push(AnyType character) {
        list.add(0, character);
        size++;
    }

    public AnyType top() {
        return list.get(0);
    }

    // get the first element
    public AnyType pop(){
        AnyType temp = list.get(0);
        list.remove(0);
        size--;
        return temp;
    }

    public boolean isEmpty(){
        return size == 0;
    }
}
