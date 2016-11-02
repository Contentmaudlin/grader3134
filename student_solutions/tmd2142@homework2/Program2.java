/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author an vo
 */
public class Program2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        TwoStackQueue<String> q = new TwoStackQueue<String>();
        q.dequeue();
        System.out.println(q.size());
        q.enqueue("a");
        q.enqueue("b");
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.size());
        q.enqueue("c");
        q.enqueue("d");
        q.enqueue("e");
        System.out.println(q.size());
        while (!q.isEmpty()) {
            System.out.println(q.dequeue());
        }
        System.out.println(q.size());
       
    }

}
