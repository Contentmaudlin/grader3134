import java.util.LinkedList;

/**
 * Created by johnzhang on 9/23/16.
 *
 * Stack class
 */
public class myStack<T> {
    private LinkedList<T> l;

    public myStack(){
        l = new LinkedList<T>();
    }

    public void push(T elem){
        l.add(0, elem);

    }

    /**
     *
     * @return top element or null if empty
     */
    public T peek(){
        return l.get(0);
    }
    public int size() {
        return l.size();
    }

    /**
     *
     * @return returns and removes top element or null if empty
     */
    public T pop(){
        T ans = l.get(0);
        if (!l.isEmpty()){
            l.remove(0);

        }
        return ans;

    }
}
