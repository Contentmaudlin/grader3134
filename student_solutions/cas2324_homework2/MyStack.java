import java.util.LinkedList;

public class MyStack<T> {

    private String symbols = "{}()[]";

    private LinkedList<T> stack;

    public MyStack() {
        stack = new LinkedList<>();
    }

    public void push(T item) {
        // Add item to the beginning of the linked list,
        // aka the "top" of the stack.
        stack.add(0, item);
    }

    public T pop() {
        return((T) stack.remove());
    }

    public T peek() {
        return((T) stack.get(0));
    }

    public int size() {
        return(stack.size());
    }
}
