import java.util.ArrayList;

public class MyStack<AnyType> {
public int top;
private ArrayList<AnyType> stack = new ArrayList<>();

MyStack(){
	top=-1;	
}

public void push(AnyType object ){
	++top;
	stack.add(top,object);
}

public AnyType pop(){
if(stack.isEmpty()){
	//System.out.println("The array is empty.");
	return null;} 
else{
	
	return stack.remove(top--);}
}

public boolean isEmpty(){
	return stack.isEmpty();
}

public int size(){
	return stack.size();
}

public AnyType peek() { 
	if(!stack.isEmpty())
		return (AnyType) stack.get(top);//[top];
	else
		return null;
}

}