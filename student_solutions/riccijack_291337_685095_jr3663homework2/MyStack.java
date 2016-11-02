import java.util.LinkedList;

public class MyStack<AnyType>{
    private LinkedList<AnyType> stackList = new LinkedList<>();

    public void push(AnyType x){
        stackList.addFirst(x);
    }

    public AnyType pop(){
        if(!isEmpty()){
            return stackList.removeFirst();
        }else{
            System.out.println("Empty Stack cannot be popped");
            return null;
        }
    }

    public AnyType top(){
        if(!isEmpty()) {
            return stackList.getFirst();
        }else{
            //System.out.println("No value at top of Stack");
            return null;
        }
    }

    public boolean isEmpty(){
        if(stackList.size() == 0){
            return true;
        }else{
            return false;
        }
    }

    public int getSize(){
        return stackList.size();
    }

    public LinkedList<AnyType> getStackList() {
        return stackList;
    }
}