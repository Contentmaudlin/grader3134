import java.util.ArrayList;
public class MyStack<T> implements Stack<T>{
	private ArrayList<T> imp;
	private int size;
	public MyStack(){
		imp=new ArrayList<>();
		size=0;
	}
	public void push(T x){
		imp.add(imp.size(),x);
		size++;
	}
	public T top(){
		if(imp.size()==0)
			return null;
		else{
		T top=imp.get(imp.size()-1);
		return top;}
	}
	public T pop(){
		if(imp.size()==0)
			return null;
		else{
		T pop=imp.get(imp.size()-1);
		imp.remove(imp.size()-1);
		size--;
		return pop;}
	}
	public int getsize(){
		return imp.size();
	}
	public boolean isEmpty(){
		if(imp.size()==0)
			return true;
		else
			return false;
	}
}
