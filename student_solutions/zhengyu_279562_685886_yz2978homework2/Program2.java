public class Program2 {
    /** If implemented correctly, this code should output: 
     *  0
     *  111
     *  1
     *  222
     *  3
     *  333
     *  444
     *  555
     *  666
     *  777
     */
    public static final void main(String[] args) {
		TwoStackQueue<Integer> q = new TwoStackQueue<Integer>();
		System.out.println(q.size());
	
		q.enqueue(111);
		q.enqueue(222);
		System.out.println(q.dequeue());
		System.out.println(q.size());
		q.enqueue(333);		
		q.enqueue(444);
		q.enqueue(555);
		System.out.println(q.dequeue());
		System.out.println(q.size());
		q.enqueue(666);
		q.enqueue(777);
		while(!q.isEmpty()){
		    System.out.println(q.dequeue());
		}
    }

}