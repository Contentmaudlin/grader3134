/**
 * Name: Victor Au
 * UNI: va2239
 * COMS W3134
 * 
 * Homework 2
 * Programming #2b: Two Stack Queue (Tester Class)
 */
public class Program2 {
    /** If implemented correctly, this code should output: 
     *  0
     *  Bulbasaur
     *  2
     *  Ivysaur
     *  4
     *  Venusaur
     *  6
     *  ---
     *  This will now dequeue and print the rest:
     *  Charmander
     *  Charmeleon
     *  Charizard
     *  Squirtle
     *  Wartortle
     *  Blastoise
     */
    public static final void main(String[] args) {

        TwoStackQueue<String> q = new TwoStackQueue<String>();
        System.out.println(q.size());

        q.enqueue("Bulbasaur");
        q.enqueue("Ivysaur");
        q.enqueue("Venusaur");
        System.out.println(q.dequeue());    // prints "Bulbasaur"
        System.out.println(q.size());
        q.enqueue("Charmander");
        q.enqueue("Charmeleon");
        q.enqueue("Charizard");
        System.out.println(q.dequeue());    // prints "Ivysaur"
        System.out.println(q.size());
        q.enqueue("Squirtle");
        q.enqueue("Wartortle");
        q.enqueue("Blastoise");
        System.out.println(q.dequeue());    // prints "Venusaur"
        System.out.println(q.size());
        
        System.out.println("---");
        System.out.println("This will now dequeue and print the rest:");
        while (!q.isEmpty()) {
            System.out.println(q.dequeue());
        }
    }
}