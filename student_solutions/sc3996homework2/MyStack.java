/**
 * Created by ShuqiChen on 16/10/1.
 */

/* I am going to use linkedlist as an instance variable in MyStack class
   since we are only allowed to use the basic operations of list
   I am going to use isEmpty, add, remove, get, size
   which are listed in the basic operation of the list interface in Java API
 */

public class MyStack<AnyType> {

    private java.util.LinkedList<AnyType> list = new java.util.LinkedList<>();
    int top = -1; //no elements yet

    //check whether the list is empty
    //by using the basic list operation isEmpty
    public boolean isEmpty() {
        return list.isEmpty();
    }

    //add the element at the end of the list
    //increment top
    //by using the basic list operation add
    //the operation add() adds the element to the end of the list
    public void push(AnyType o) {
        list.add(o);
        top++;
    }

    //copy the element to p
    //remove the element from the list
    //decrement top
    //return p
    //the basic list operation remove removes the element with the index top
    public AnyType pop() {
        AnyType p = list.get(top);
        list.remove(top);
        top--;
        return p;
    }

    //return the element of index top
    //by using get method
    public AnyType peek() {
        return list.get(top);
    }

    //return the size of the list
    //by using the size()
    public int size() {
        return (list.size());
    }




}
