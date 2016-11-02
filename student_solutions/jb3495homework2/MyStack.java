
// ***********************************
// Homework 2, MyStack.java
// Written by Jennifer Bi
// jb3495
// ***********************************


import java.util.LinkedList;
import java.util.Iterator;

public class MyStack<T>{

	private LinkedList<T> list;
	private int size;
	private Iterator<T> myIterator;

	public MyStack(){
	list = new LinkedList<>();
	size = 0;
	}


	public void push(T x){
		list.add(0,x);
		size++;
	}

	public T pop(){
		T data = list.get(0);
		list.remove();
		--size;
		return data;

	}

	public int top(){
		return size;
	}

	public void printStack(){
		myIterator = list.iterator();
		System.out.println("--------");
		while (myIterator.hasNext()){
			System.out.println(myIterator.next());
		}
		System.out.println("--------");


	}





}