/*
 * UNI:wl2536
 * Author: Wenbo Li
 * Program: TwoStackQueue
 */

import java.util.Stack;

public class TwoStackQueue {
    private Stack<Integer> stackPush;

    private Stack<Integer> stackPop;

    public TwoStackQueue() {
        this.stackPush = new Stack<Integer>();
        this.stackPop = new Stack<Integer>();
    }

    public void add(int e) {
        this.stackPush.push(e);
    }

    public int poll() {
        tranfer();
        return this.stackPop.pop();
    }

    public int peek() {
        tranfer();
        return this.stackPop.peek();
    }

    private void tranfer() {
        if (this.stackPop.empty()) {
            if (this.stackPush.isEmpty()) { // isEmpty is the Vector method inherited by stack
                throw new RuntimeException("Your queue is empty.");
            }
            while (!this.stackPush.empty()) { // empty is the method of stack
                this.stackPop.push(this.stackPush.pop());
            }
        }
    }