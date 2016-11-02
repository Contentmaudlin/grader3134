
/**
 * Created by johnzhang on 10/1/16.
 * Tester class for Two Stack Queue
 */
public class Program2 {

    public static void main(String[] args){
        TwoStackQueue<String> tsq = new TwoStackQueue<>();

        System.out.println(tsq.size());
        tsq.enqueue("hello");
        tsq.enqueue("world");
        tsq.enqueue("kanye");
        tsq.enqueue("west");
        System.out.println(tsq.dequeue());
        System.out.println(tsq.size());
        System.out.println(tsq.dequeue());
        tsq.enqueue("stacks");
        tsq.enqueue("on");
        tsq.enqueue("stacks");

        while (!tsq.isEmpty()){
            System.out.println(tsq.dequeue());
        }
        System.out.println(tsq.size());

        tsq.enqueue("Peter");
        tsq.enqueue("Paul");
        tsq.enqueue("Mary");
        System.out.println(tsq.dequeue());
        System.out.println(tsq.size());
        tsq.enqueue("Simon");
        tsq.enqueue("Alvin");
        System.out.println(tsq.dequeue());
        tsq.enqueue("Theodore");

        while(!tsq.isEmpty())
            System.out.println(tsq.dequeue());
        /* Expected output:
            0
            hello
            3
            world
            kanye
            west
            stacks
            on
            stacks
            0
            Peter
            2
            Paul
            Mary
            Simon
            Alvin
            Theodore

         */

    }



}
