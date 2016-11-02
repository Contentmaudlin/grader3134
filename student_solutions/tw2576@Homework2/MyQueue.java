/* Tianwu Wang
 * tw2576
 * MyQueue.java
 * MyQuene interface
 */

public interface MyQueue<AnyType>{
	
	public void enqueue(AnyType x);
	
	public AnyType dequeue();
	
	public boolean isEmpty();
	
	public int size();
}