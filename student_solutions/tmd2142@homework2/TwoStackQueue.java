/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Stack;

/**
 *
 * @author an vo
 */
public class TwoStackQueue<T> implements MyQueue{
    MyStack<T> s1 = new MyStack<T>();
    MyStack<T> s2 = new MyStack<T>();
    @Override
    public void enqueue(Object x) {
        while(!s1.isEmpty())
            s2.pushOn(s1.popOut());
        T t = (T)x;
        s1.pushOn(t);
        while(!s2.isEmpty())
            s1.pushOn(s2.popOut());
    }

    @Override
    public Object dequeue() {
        s2.pushOn(s1.popOut());
        return s2.popOut() ;
    }

    @Override
    public boolean isEmpty() {
        return s1.isEmpty();
    }

    @Override
    public int size() {
        return s1.size();
    }
    
}
