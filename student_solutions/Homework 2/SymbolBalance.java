//*****************************************************************************
//
// Name - Ishaan Kishore Agrawal
// UNI - ia2341
// Date - 7th October, 2016
//
// SymbolBalance Class
//
// This class contains the algorithm required to test whether symbols in a java
// file are balanced or not. The algorithm skips over literal strings and 
// comment blocks. The algorithm reads a .java file and reports the FIRST error 
// it finds
//
//*****************************************************************************

// import the necessary classes
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

// begin class
public class SymbolBalance {
	
	// instance variables (booleans) required to test whether the symbol under 
	// consideration is in code syntax or in a string or comment
	private boolean comment;
	private boolean string;
	
	// constructor of the class
	public SymbolBalance() {
		
		// initialize both as false - .java files begin as code syntax.
		comment = false;
		string = false;
	}

	// method which returns a string contents of the entire.java file
	public String readFile(String fileName) throws IOException {
		
		// creates a buffered reader of the input file
		FileReader file = new FileReader(fileName);
		BufferedReader reader = new BufferedReader(file);
		
		// initializes output variables
		String output = "";
		String line;
		
		// while the java file line still has contents
		while((line = reader.readLine()) != null) {
			output += line + "\n";
		}

		// close the reader and return the output
		reader.close();
		return output;
	}
	
	// method which checks the balancing of all symbols
	public String checkBalance(String input) {
		
		// creates a Character stack which will contain the symbols.
		MyStack<Character> stack = new MyStack<Character>();
		Character car;
		
		// iterating all the characters through the entire string (java file 
		// contents)
		for (int i = 0; i < input.length(); i ++) {
			
			// the variable is the current character 
			car = input.charAt(i);

			// if the character is any open symbol and it isn't in any string or
			// comment block
			if (((car == '(') || (car == '{') || (car == '[')) && !comment && 
					!string) {
				
				// push it onto the stack
				stack.push(car);
			}
			
			// else, in code if the character is a closing )
			else if ((car == ')') && !comment && !string) {
				
				// check if popping the stack gives a (
				String output = checkClosing(stack, car, '(');
				
				// if not, return error message
				if (output != null) {
					return output;
				}
			}
			
			// else, in code if the character is a closing }
			else if ((car == '}') && !comment && !string) {
				
				// check if popping the stack gives a (
				String output = checkClosing(stack, car, '{');
				
				// if not, return error message
				if (output != null) {
					return output;
				}
			}
			
			// else, in code if the character is a closing }
			else if ((car == ']') && !comment && !string) {
				
				// check if popping the stack gives a (
				String output = checkClosing(stack, car, '[');
				
				// if not, return error message
				if (output != null) {
					return output;
				}
			}
			
			// else, if the character in code syntax is a quotation mark
			else if ((car == '"') && !comment) {
				
				// negate the string boolean
				string = !string;	
			}
			
			// else, if the character is a /
			else if (car == '/' && !comment && !string) {
				
				
				if (i + 1 < input.length()) {
					
					// if the next character is a *
					if (input.charAt(i + 1) == '*') {
						
						// make comment true
						comment = true;
						
						// if the first character of the comment block is /, 
						// ignore it otherwise, comment boolean will become 
						// false
						if (input.charAt(i + 2) == '/')
							i += 2;
					}
				}
				
			}
			
			// else, if the character is a *
			else if (car == '*' && !string) {
				
				// check if there is a next character
				if (i + 1 < input.length()) {
					
					// check whether the next character is /
					if (input.charAt(i + 1) == '/' ) {
						
						// if yes, check whether you are in a comment block
						if (!comment)
							
							// if no, return an error
							return "Missing /* symbol";
						else
							// otherwise, make comment block false
							comment = false;
					}
				}
				
			}
		}
		
		// check all the post - read conditions and return an error
		return checkConditions(stack);
		
	}
	
	// method which checks all the post - read conditions
    private String checkConditions(MyStack<Character> stack) {
		
    	// get the String output of the 1st condition
		String output = condition1();
		
		// if there is an error, return the error
		if (output != null)
			return output;

		// else check for the 2nd condition
		output = condition2();
		
		// if there is an error, return the error
		if (output != null)
			return output;
		
		// otherwise, check the 3rd error condition
		output = condition3(stack);
		
		// if there is an error, return it
		if (output != null)
			return output;
		
		// otherwise, print a message that states that the file has no error
		else 
		    return "The file contains no symbol balancing error";
	}
	
    // method which checks the 1st condition
	private String condition1() {
		
		// if we are still in a string, print an error
		if (string)
			return "Missing \" mismatch error.";
		
		// otherwise return null
		return null;
	}
	
	// method which checks the 2nd condition
	private String condition2() {
		
		// if we are still in a comment block, return an error
		if (comment)
			return "Missing */ mismatch error";
		
		// otherwise return null
		return null;
	}

	// method which checks the 3rd error condition
	private String condition3(MyStack<Character> stack) {
		
		// if the stack is not empty
		if (!stack.isEmpty()) {
			
			// print an error message
			String output = "Missing symbol mismatch: " + stack.top() + " is "
					+ "not closed.";
			
			// return it
			return output;
		}
		
		// otherwise, return null
		return null;
	}

	// method which checks the closing balance of each symbol
	private String checkClosing(MyStack<Character> stack, Character car, 
			Character desired) {

		// if the stack is empty within the file when a closing symbol is 
		// encountered
		if (stack.isEmpty()) {
			
			// print an error message and return it
			String output = "Extra symbol " + car + " is mismatched";
			return output;
		}
		
		// check the first character on the stack
		char temp = (char) stack.pop();
		
		// if the character is not as desired
		if (temp != desired) {	
			
			// return an error message
			String output = "Unbalanced " + temp + " mismatched by " + car;
			return output;
	    }

		// otherwise, return null
		else
			return null;
	}
	
	// begin main method
	public static void main(String[] args) throws IOException {
		
		try {
			
			// create a new SymbolBalance object
			SymbolBalance test = new SymbolBalance();
			
			// get all the file contents as a string
			String fileContents = test.readFile(args[0]);
			
			// print out the balance properties of the file
			System.out.println(test.checkBalance(fileContents));
			
		}
		
		catch (FileNotFoundException e) {
			System.out.println("The file to test could not be found.");
		}
		
		catch (IOException e) {
			System.out.println("There was an IO Error.");
		}
		
		catch(Exception e) {
			System.out.println("An unknown error occured");
		}
		
	}
	// end main method
}
// end class
