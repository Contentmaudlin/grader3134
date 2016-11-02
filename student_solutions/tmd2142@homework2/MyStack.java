/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.List;

public class MyStack<T> {

    public MyStack() {
    }

    private List list = new ArrayList<>();

    public void pushOn(T t) {
        list.add(t);
    }

    public T popOut() {
        if (list.size() != 0) {
            int lastIndex = list.size() - 1;
            T top = (T) list.get(lastIndex);
            list.remove(lastIndex);
            return top;
        }else{
            System.out.println("Empty Stack");
        }
        return null;
    }

    public T peekOut() {
        if (list.size() != 0) {
            return (T) list.get(list.size() - 1);
        }else{
            System.out.println("Empty Stack");
        }
        return null;
    }

    public boolean isEmpty() {
        if (list.size() > 0) {
            return false;
        }
        return true;
    }

    public int size() {
        return list.size();
    }

    public int search(T t) {
        for (int i = list.size() - 1; i >= 0; i--) {
            if (t.getClass() == String.class) {
                if (String.valueOf(list.get(i)).equals(t)) {
                    return list.size() - 1 - i;
                }
            } else if (list.get(i) == t) {
                return list.size() - 1 - i;
            }
        }
        return -1;
    }

}
