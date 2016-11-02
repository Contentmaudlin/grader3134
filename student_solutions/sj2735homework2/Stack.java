/* Sejal Jain
 * sj2735 
 * Stack.java - interface for a Stack */

public interface Stack<AnyType> {
	
	/* Push a new item x on top of the stack */
    public void push(AnyType x);
    
    /* Remove and return the top item of the stack */ 
    public AnyType pop();
    
    /* Return the top item of the stack without removing it */
    public AnyType top();
}
