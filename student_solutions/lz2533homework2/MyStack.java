import java.util.EmptyStackException;
import java.util.LinkedList;

public class MyStack<T>{

    private LinkedList<T> list;
    public int idx;


    public MyStack(){
    	list = new LinkedList<>();
    	idx=0;
    }

    public void push(T item){
    	list.add(idx,item);
    	idx++;
    }

    public T pop(){
    	if(idx==0)
    		throw new EmptyStackException();
    	T data = list.get(idx-1);
    	list.remove(idx-1);
    	idx--;
    	return data;
    }

    public boolean isEmpty(){
    	return idx==0;
    }

    public int size(){
    	return idx;
    }
}
