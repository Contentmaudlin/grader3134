/*Paul Bloom
* pab2163
* Tester class for my TwoStackQueue, very similar to the provided tester,
* but with some different string inputs and testing out to make sure 
* a dequque call on an empty queue will return null */



public class Program2{

    /** When I run it, the code ouputs: 
    0
	*null
	*This is the first string
	*This is the 2nd string
	*This is the 3rd string
	*This is the 4th string
	*This is the 5th string
	*null
	*3
	*This is the 6th string
	*This is the 7th string
	*This is the last string

	Seems like it works at least on this cases. 
     */
    public static final void main(String[] args) {


	TwoStackQueue<String> q = new TwoStackQueue<String>();
	System.out.println(q.size());
	System.out.println(q.dequeue()); // queue is empty, should return null
	q.enqueue("This is the first string");
	q.enqueue("This is the 2nd string");
	q.enqueue("This is the 3rd string");
	System.out.println(q.dequeue());
	q.enqueue("This is the 4th string");
	q.enqueue("This is the 5th string");
	while(!q.isEmpty())
	    System.out.println(q.dequeue());
	System.out.println(q.dequeue()); // queue is empty, should return null
	q.enqueue("This is the 6th string");
	q.enqueue("This is the 7th string");
	q.enqueue("This is the last string");
	System.out.println(q.size());

	while(!q.isEmpty())
	    System.out.println(q.dequeue());


    }
}