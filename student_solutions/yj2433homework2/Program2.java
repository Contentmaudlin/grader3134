/* Yuncheng Jiang
 *  UNI:yj2433
 *Test the queue
 *Expected:
 0
 Apple
 2
 Orange
 Purple
 Red
 Grape
 Car
 */
public class Program2 {
    public static final void main(String[] args) {
        TwoStackQueue<String> q = new TwoStackQueue<String>();
        System.out.println(q.size());
        q.enqueue("Apple");
        q.enqueue("Orange");
        q.enqueue("Purple");
        System.out.println(q.dequeue());
        System.out.println(q.size());
        q.enqueue("Red");
        q.enqueue("Grape");
        System.out.println(q.dequeue());
        q.enqueue("Car");
        while(!q.isEmpty())     
        System.out.println(q.dequeue());
    }
}