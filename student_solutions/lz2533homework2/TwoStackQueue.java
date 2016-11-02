public class TwoStackQueue<T> {

    private MyStack<T> S1 = new MyStack<T>();
    private MyStack<T> S2 = new MyStack<T>();

    public void enqueue(T item){
    	S1.push(item);
    }

    public T dequeue() {
    	if(isEmpty())
    		return null;
    	else{
        if (S2.isEmpty()) {
            while (!S1.isEmpty()) {
               S2.push(S1.pop());
            }
        }
        return S2.pop();
    	}
    }


    public boolean isEmpty(){
    	if(S1.size()==0 && S2.size()==0)
    		return true;
    	else
    		return false;
    }

    public int size(){
    	return S1.size()+S2.size();
    }
}
