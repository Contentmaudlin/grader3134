
public class Program2{
    /** If implemented correctly, this code should output: 
     *  0
     *  4
     *  <^>v
     *  <3
     *  0
     */
	
	public static void main(String[] args){
		
		TwoStackQueue<Character> c = new TwoStackQueue<>();
		System.out.println(c.size);
		c.enqueue('<');
		c.enqueue('^');
		c.enqueue('>');
		c.enqueue('v');
		System.out.println(c.size);
		System.out.print(c.dequeue());
		System.out.print(c.dequeue());
		System.out.print(c.dequeue());
		System.out.println(c.dequeue());
		c.enqueue('<');
		c.enqueue('3');
		System.out.print(c.dequeue());
		System.out.println(c.dequeue());
		System.out.print(c.size);
	}
}
