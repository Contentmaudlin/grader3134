//*************************************************************
//Program2.java
//
//by Sophie Ishak
//*************************************************************

public class Program2 {
	
	/** If implemented correctly, this code should output: 
     *  Is
     *  3
     *  Donald
     *  Trump
     *  A
     *  2
     *  false
     *  Natural
     *  Blond?
     */
	
	public static final void main(String[] args) {
		
	TwoStackQueue<String> a = new TwoStackQueue<String>();
	
	a.enqueue("Is");
	System.out.println(a.dequeue());
	a.enqueue("Donald");
	a.enqueue("Trump");
	a.enqueue("A");
	System.out.println(a.size());
	a.enqueue("Natural");
	a.enqueue("Blond?");
	System.out.println(a.dequeue());
	System.out.println(a.dequeue());
	System.out.println(a.dequeue());
	System.out.println(a.size());
	System.out.println(a.isEmpty());
	while(!a.isEmpty())
	    System.out.println(a.dequeue());
	
	}
}
