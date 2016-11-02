/* Yuncheng Jiang
 *  UNI:yj2433
 *Use two stacks to perform queue behavior
 */
public class TwoStackQueue<AnyType>{
    
    MyStack<AnyType> s1 = new MyStack<>();
    MyStack<AnyType> s2 = new MyStack<>();
    
    public int size() {//define the size of the queue
        return (s1.size() + s2.size());
    }
    
    public boolean isEmpty() {//return whether the queue is empty
        if(s1.isEmpty() && s2.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
    
    public void enqueue(AnyType data) {//enqueue
        s1.push(data);
    }
    
    public AnyType dequeue() {//dequeue
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {//push everything from s1 to s2
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }
    
    
}