//*****************************************
//Arjun Mangla
//am4409
//Paul Blaer
// Data Structures
//Fall 2016
//Homework-2
//*****************************************

public class Program2 {

    public static final void main(String[] args) {


	TwoStackQueue<String> q = new TwoStackQueue<String>();
	System.out.println(q.size());

	q.enqueue("Puneet Mangla");
	System.out.println(q.dequeue());
	System.out.println(q.size());
	q.enqueue("Shruti Mangla");
	q.enqueue("Arjun Mangla");
	q.enqueue("Ishaan Mangla");
	while(!q.isEmpty())
	    System.out.println(q.dequeue());
	q.enqueue("Ayesha Bedi");
	System.out.println(q.dequeue());

    }





}