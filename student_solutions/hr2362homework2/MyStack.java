/* Kelly Ryu
 * hr2362
 * MyStack.java - defines stack class with push, pop, peek, empty methods
 */

public class MyStack<AnyType>{
    
    // use LinkedList to store data
    java.util.LinkedList<AnyType> list;
    int top;
    
    public MyStack(){
        list = new java.util.LinkedList<AnyType>();
        top = -1;
    }   
    
    public AnyType push(AnyType x){
        list.add(x);
        top++;
        return x;
    }
    
    public AnyType pop(){
        if (top == -1){
            return null;
        }
        else{
            AnyType e = list.get(top);
            list.remove(top);
            top--;
            return e;
        }
    }
    
    public AnyType peek(){
        if (top == -1){
            return null;
        }
        else{
            AnyType e = list.get(top);
            return e;
        }
    }
    
    public boolean empty(){
        if (top == -1){
            return true;
        }
        else{
            return false;
        }
    }
    
    public int size(){
        return list.size();
    }
    
}
