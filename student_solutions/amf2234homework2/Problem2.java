public class Program2 {



    /** If implemented correctly, this code should output: 
     *  1
     *  2
     *  3
     *  4
     *  5
     *  10
     */
    public static final void main(String[] args) {

        TwoStackQueue<Integer> tsq = new TwoStackQueue<Integer>();

        tsq.enqueue(1);
        tsq.enqueue(2);
        tsq.enqueue(3);
        System.out.println(tsq.dequeue());
        tsq.enqueue(4);
        System.out.println(tsq.dequeue());
        System.out.println(tsq.dequeue());
        tsq.enqueue(5);
        tsq.enqueue(10);
        System.out.println(tsq.dequeue());
        System.out.println(tsq.dequeue());
        System.out.println(tsq.dequeue());

    }





}