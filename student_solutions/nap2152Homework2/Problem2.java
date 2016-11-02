
public class Problem2 {



    /** If implemented correctly, this code should output: 
     *  0
     *  true
     *  false
     *  1
     *  5 - This is the size
     *  2
     *  3
     *  4
     *  5
     *  6
     *  null
     */
    public static final void main(String[] args) {


	TwoStackQueue<Integer> que = new TwoStackQueue<Integer>();
	System.out.println(que.size());
	System.out.println(que.isEmpty());
	que.enqueue(1);
	System.out.println(que.isEmpty());
	que.enqueue(2);
	que.enqueue(3);
	que.enqueue(4);
	que.enqueue(5);
	que.enqueue(6);
	System.out.println(que.dequeue());
	System.out.println(que.size());
	
	while(!que.isEmpty())
	    System.out.println(que.dequeue());
	System.out.println(que.dequeue());
    }
    




}
