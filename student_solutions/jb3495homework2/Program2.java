
// ***********************************
// Homework 2, Program2.java
// Written by Jennifer Bi (jb3495)
// adapted from TwoStackQueueTester
// ***********************************


public class Program2 {



    /** If implemented correctly, this code should output: 
     *  0
     *  goin
     *  2
     *  absolute
     *  bagel
     *  this
     *  wknd
     *  4
     *  that
     *  toasted
     *  everything
     *  bagel 
     *  w/
     *  sundried tomato cream cheese 
     */
    public static final void main(String[] args) {


	TwoStackQueue<String> q = new TwoStackQueue<String>();
	System.out.println(q.size());

	q.enqueue("goin");
	q.enqueue("absolute");
	q.enqueue("bagel");
	System.out.println(q.dequeue());
	System.out.println(q.size());
	q.enqueue("this");
	q.enqueue("wknd");
	System.out.println(q.dequeue());
	System.out.println(q.dequeue());
	System.out.println(q.dequeue());
	System.out.println(q.dequeue());
	q.enqueue("that");
	q.enqueue("toasted");
	q.enqueue("everything");
	q.enqueue("bagel");
	System.out.println(q.size());
	q.enqueue("w");
	q.enqueue("sundried tomato cream cheese");
	System.out.println(q.dequeue());

	while(!q.isEmpty())
	    System.out.println(q.dequeue());


    }





}