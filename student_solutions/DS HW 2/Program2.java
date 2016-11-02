/*Ziyi Sun
 *zs2293
 */


public class Program2 {
	
    public static final void main(String[] args) {
    
    /*
      Should outprint
0
1
2
2
5
3
4
5
6
7
2
      
		
     */


	TwoStackQueue<Integer> q = new TwoStackQueue<Integer>();
	System.out.println(q.size());

	q.enqueue(1);
	q.enqueue(2);
	q.enqueue(3);
	System.out.println(q.dequeue());
	System.out.println(q.size());
	q.enqueue(4);
	q.enqueue(5);
	System.out.println(q.dequeue());
	q.enqueue(6);
	q.enqueue(7);
	System.out.println(q.size());

	while(!q.isEmpty())
	    System.out.println(q.dequeue());
	
	q.enqueue(6);
	q.enqueue(7);
	System.out.println(q.size());


    }

}
