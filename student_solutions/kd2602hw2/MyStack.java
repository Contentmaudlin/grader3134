/*
 Kendall Dabaghi
 KD2602
 */

import java.util.LinkedList;

public class MyStack<T extends Comparable<? super T>> {

    // Implement a stack using a LinkedList with an int 'back' to track
    // the index that holds the last item in the stack.  Thus, if 
    // back is -1, then there are no values.  If it is 0, then the 
    // first value is at index 0, etc.

    private LinkedList<T> myList;
    int back;

    public MyStack() {
        back = -1;
        myList = new LinkedList<>();
    }

    public boolean empty() {
        return back == -1;
    }

    public T peek() {
        if(!empty()) {
            return myList.get(back);
        } else {
            return null;
        }
    }

    public T pop() {
        if(!empty()) {
            back--;
            return myList.get(back+1);
        } else {
            return null;
        }
    }

    public T push(T item) {
        back++;
        myList.add(back, item);
        return item;
    }

    public int search(T item) {
        for(int i = 0; i < myList.size(); i++) {
            if(myList.get(i).compareTo(item) == 0) {
                return i;
            }
        }
        return -1;
    }

}
