/**
 * Name: Anlan Huang  UNI: ah3358
 *
 * A tester class with a main method to demonstrate that TwoStackQueue works
 * correctly (by enqueueing a number of objects and then dequeueing and
 * printing them in the correct order).
 *
 * Created by anlan on 9/26/16.
 */

public class Program2 {
    /**
     * If implemented correctly, this code should output:
     Saber
     Archer
     Lancer
     Caster
     Assassin
     Berserker
     Rider
     0
     null
     */
    public static final void main(String[] args) {
        TwoStackQueue<String> q = new TwoStackQueue<String>();

        String[] servant = {"Saber", "Archer", "Lancer", "Caster", "Assassin",
                "Berserker", "Rider"};
        for (int i = 0; i < servant.length; i++) {
            q.enqueue(servant[i]);
        }

        while (!q.isEmpty()) {
            System.out.println(q.dequeue());
        }
        System.out.println(q.size());
        System.out.println(q.dequeue());
    }
}