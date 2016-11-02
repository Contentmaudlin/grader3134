/***************************************************************
 * SymbolBalance.java
 * By: Tahiya Chowdhury
 * Homework 2
 ***************************************************************/


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SymbolBalance {
	
	public static void main (String[] args){

		try {
			
			BufferedReader br = new BufferedReader(new FileReader(args[0]));
			System.out.println(checkParentheses(readEntireFile(br)));
			
		}
		catch(FileNotFoundException e){
			System.out.println("We're sorry, we are unable to find that file");
		}
		catch (IOException e1) {
			System.out.println("We're sorry, we are unable to read that file");
		}
	}
	
	public static String checkParentheses (String s) {
		MyStack<Character> newStack = new MyStack<Character>();	
		
		char tmp;
		
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
           
            //Identifies if it's a comment and ignores
            if(c == '/'){
            	
            	if(s.charAt(i+1) == '*') {
            		i = i+2;
            		
            		while(!((s.charAt(i+1) == '*') && (s.charAt(i+2) == '/'))){
            			
            			i= i+1;
            			if (i == s.length() - 1){
            				return "Error! There is an imbalance of "
            						+ "comment symbols";
            			}
            		}
            		i = i+2;
            	}
            }
            
            else if(c == '*'){
            	if (s.charAt(i + 1) == '/'){
            		return "Error! There is an imbalance of "
            						+ "comment symbols"; 
            	}
            }
            
            //Identifies if it's a string and ignores
            else if(c == '"'){
            	i = i+1;
            	while (s.charAt(i) != '"'){
            		i = i+1;
            		if (i == (s.length()-1)) {
            			return "There is an imbalance of quotation"
            					+ " marks.";
            		}
            	}
            }
            
            /* If outside of comments or string literals, uses the stack
             *  to ensure the parentheses are balanced
             */
            else {
            	if(c == '[' || c == '(' || c == '{') {
            		newStack.push(c);
            	}
            	
            	else if(c == ']') {
            		if(newStack.isEmpty()) {
            			return "Error! Closing symbol ] is missing "
            					+ "an opening symbol";
            		}
            		else if((tmp = newStack.pop()) != '[') {
            			 return "Error! Left " + tmp +
                			" matched by right ]";
            		}
            	}
            	else if(c == ')') {
            		if(newStack.isEmpty()) {
            			return "Error! Closing symbol ) is missing "
            					+ "an opening symbol";
            		}
            		else if((tmp = newStack.pop()) != '(') {
            			 return "Error! Left " + tmp + " matched by "
            					+ "right ) ";
            		}
            	}
            	else if(c == '}') {
            		if(newStack.isEmpty()) {
            			return "Error! Closing symbol } is missing "
                			+ "an opening symbol";
            		}
            		else if((tmp = newStack.pop()) != '{') {
            			return "Error! Left " + tmp +
                			" matched by right }";
            		}
            	}
             }
        }
        
        /*If stack is not empty, it means there are opening symbols without
        closing symbols */
        if (!newStack.isEmpty()) {
			char temp = newStack.pop();
			return "Error! Opening symbol " +  temp + 
    				" does not have a closing symbol"; 
        }
        return "Success! Everything is balanced!";
	}
	
	public static String readEntireFile(BufferedReader br) throws IOException {
		StringBuilder everything = new StringBuilder();
	    String eachLine;
	    
	    while((eachLine = br.readLine()) != null) {
	       everything.append(eachLine);
	    }
	    
	    String text = everything.toString();
	    return text;
	}
	
}
