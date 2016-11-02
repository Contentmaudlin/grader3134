/* Sejal Jain
 * sj2735 
 * SymbolBalance.java - balances special symbols in java files */

import java.io.*;
import java.util.Scanner;

public class SymbolBalance {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		// take file name as command line argument
		File file = new File(args[0]);
		
		Scanner input = new Scanner(file);
		
	    MyStack<Character> stack = new MyStack<>(); 
	    stack.push('X');
	    
	    while(input.hasNextLine()) {
    		// iterate over each line in file
	    	
    		String line = input.nextLine();
    		char[] char_array = line.toCharArray();
    		
    		for( int i = 0; i < char_array.length; i++) {
    			// iterate over each character in one line
    			
    			char c = char_array[i];
    			if(i < char_array.length - 1) {
    				// handle block comments
    				if(c == '/' && char_array[i+1] == '*' && stack.top() != '*') {
        				stack.push(c);
        				stack.push(char_array[i+1]);
        			}
        			else if(c == '*' && char_array[i+1] == '/') {
        				if(stack.top() == '*') {
        					stack.pop();
        					stack.pop();
        				}
        			}
    			} 
    			if(c == '\"') {
    				// handle double quotes
    				if(stack.top() == '\"') {
    					stack.pop();
    				}
    				else {
    					stack.push(c);
    				}
    			}
    			else if(stack.top() != '\"' && stack.top() != '*') {
    				// handle special characters not in quotes or comments
    				if(c == '(' || c == '{' || c == '[') {
        				stack.push(c);
        			}
        			else if(c == '}') {
        				if(stack.top() == '{') {
        					stack.pop();
        				}
        				else {
        					System.out.println("Unbalanced character: " + c);
        					System.exit(-1);
        				}
        			}
        			else if(c == ')') {
        				if(stack.top() == '(') {
        					stack.pop();
        				}
        				else {
        					System.out.println("Unbalanced character: " + c);
        					System.exit(-1);
        				}
        			}
        			
        			else if(c == ']') {
        				if(stack.top() == '[') {
        					stack.pop();
        				}
        				else {
        					System.out.println("Unbalanced character: " + c);
        					System.exit(-1);
        				}
        			}
    			}	
    			
    		}
    		
    	}
    	input.close();
    	
    	// check for remaining unbalanced symbols
		if (stack.top() != 'X') {
			System.out.println("Unbalanced character: " + stack.top());
		}
		
	}
}










