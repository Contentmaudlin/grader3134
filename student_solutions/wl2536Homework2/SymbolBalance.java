/*
 * UNI:wl2536
 * Author: Wenbo Li
 * Program: SymbolBalance
 */
import java.util.Stack;

	public class SymbolBalance {
	    public boolean isValidSympat(String o) {
	        Stack<Character> michael = new Stack<Character>();
	        if(o == null || o.length() == 0)
	        	//verify the volume of the stack
	            return true;
	        for(int j = 0; j < o.length(); j++){
	            if(o.charAt(j) == ')'){
	                if(!michael.isEmpty() && michael.peek() == '(')
	                    michael.pop();
	                //check the symbol of the stack
	                else
	                    return false;
	            }else if(o.charAt(j) == ']'){
	                if(!michael.isEmpty() && michael.peek() == '[')
	                    michael.pop();
	                else
	                    return false;
	            }else if(o.charAt(j) == '}'){
	                if(!michael.isEmpty() && michael.peek() == '{')
	                    michael.pop();
	                else
	                    return false;
	            }else{
	                michael.push(o.charAt(j));
	            }
	        }
	        if(michael.isEmpty())
	            return true;
	        else
	            return false;
	    }
	}
