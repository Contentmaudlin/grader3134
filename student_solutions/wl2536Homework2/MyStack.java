/*
 * UNI:wl2536
 * Author: Wenbo Li
 * Program: MyStack
 */


import java.util.*;

public class MyStack {
	  private Object stack[];
	  private int size;
	  private int pointer;

	  private static final int DEFAULT_STACK_SIZE = 100;

	  public MyStack () {
	    this(DEFAULT_STACK_SIZE);
	  }

	  public MyStack (int size) {
	    stack = new Object[size];
	    this.size = size;
	    pointer = 0;
	  }

	  public void clear () {
	    Arrays.fill(stack, 0, pointer, null);
	    pointer = 0;
	  }

	  public void push (Object x) throws Exception {
	    if (pointer >= size) {
	      throw new Exception("stack overflow");
	    }
	    stack[pointer++] = x;
	  }

	  public Object pop () throws Exception {
	    if (pointer <=0) {
	      throw new Exception();
	    }
	    Object val = stack[--pointer];
	    stack[pointer] = null;
	    return val;
	  }

	  public boolean isEmpty () {
	    return pointer == 0;
	  }

	  public String toString () {
	    String s = "MyStack=[";
	    for (int i = 0; i < pointer; ++i) {
	      s = s + stack[i];
	      if (i < pointer - 1) {
	        s = s + ",";
	      }
	    }
	    s = s + "]";
	    return s;
	  }
}