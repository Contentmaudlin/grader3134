/**
 * @author Zoe Gordin
 * zeg2103
 *
 * This class is a tester for TwoStackQueue
 */
public class Program2 {

    /**
     * if TwoStackQueue works correctly, the output should be:
     *
     *
     0
     3
     Hamilton
     Eliza
     Angelica
     Maria
     Burr
     Phillip
     Washington
     *
     */
    public static final void main(String[] args) {


        TwoStackQueue<String> q = new TwoStackQueue<String>();
        System.out.println(q.size());

        q.enqueue("Hamilton");
        q.enqueue("Eliza");
        q.enqueue("Angelica");
        System.out.println(q.size());
        q.enqueue("Maria");
        System.out.println(q.dequeue());
        q.enqueue("Burr");
        q.enqueue("Phillip");
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        q.enqueue("Washington");

        while(!q.isEmpty())

            System.out.println(q.dequeue());


    }





}
