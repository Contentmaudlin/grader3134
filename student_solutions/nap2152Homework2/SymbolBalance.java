import java.io.*;
import java.util.Scanner;

public class SymbolBalance {

	public static void main(String[] args) throws IOException{
		// Create a stack of Characters
		MyStack<Character> x = new MyStack<Character>();
		
		//Get and read the file to a string
		File inFile = null;
		String fileContents = "";
		//Checks to make sure there is an args
		if(args.length > 0 ) {
			try {
				inFile = new File(args[0]);
				//Scans all the lines of the file to a string
				Scanner input = new Scanner(inFile);
				while (input.hasNextLine()) {
					fileContents += input.nextLine() + "\n";
				}
				input.close();
			}
			//Checks for errors, including that the file exists
			catch (IOException e) {
	    		System.out.println("No such file exists");
	    		System.out.println(e.getMessage());
	    		return;
	    	}
			catch (Exception e) {
	    		System.out.println("Something went wrong");
	    		System.out.println(e.getMessage());
	    	}
		} else {
			System.out.println("There needs to be a command line argument to "
					+ "read");
			return;
		}

		// Iterates through every character in the fileContents string and
		// checks if they are an opening for a symbol, checks for all symbol
		// mismatches for the {}, [], (), /**/, and "" symbols
		for (int i = 0; i < fileContents.length(); i++) {
			char c = fileContents.charAt(i);
			// Checks if the stack is empty before calling top to avoid an error
			if (!x.isEmpty()) {
				if (x.top() == '*') { // If there is a block comment
					// Check to see if the block comment ends, if it does pop it
					if (c == '*') {
						if (fileContents.charAt(i + 1) == '/') {
							x.pop();
						}
					}
					//Otherwise continue so it doesnt read code in the comment
					continue;
				} else if (x.top() == '"') { //Checks if its in a string
					//Pops it if the string ends
					if (c == '"') {
						x.pop();
					}
					if (c == '\n') {
						System.out.println("ERROR, quotes can't "
								+ "be on seperate lines");
						return;
                    }
					// Continues so it doesnt read the string
					continue;
				}
			}
			// If there is an open symbol, push it onto the stack
			if (c == '(' || c == '{' || c == '[' || c == '"') {
				x.push(c);
				continue;
			} else if ( c == '/') {
				if (fileContents.charAt(i+1) == '*') {
					x.push('*');
				}
				continue;
			} else if ( c == ')' || c == '}' || c == ']') { // If it is a closing symbol
				//Checks if the stack is empty, returns an error saying its missing its open
				if (x.isEmpty()) {
					System.out.println("ERROR, symbol mismatched, no open " +
							"symbol for " + c);
					return;
				}
				// Pops a character and saves it
				char popped = x.pop();
				//Makes sure the popped character is a match for the close symbol
				if ( (popped == '(' && c == ')') || (popped == '{' && 
						c == '}')  || (popped == '[' && c == ']') ) {
					continue;
				} else {
					System.out.println("ERROR, Umbalanced Symbol " + 
				c + " is mismatched");
					return;
				}
			}
		}
		
		// At the end, checks to make sure there is nothing left in the stack
		// and that everything has been successfully matched
		if (!x.isEmpty()) {
			System.out.println("Error, missing a closing symbol for symbol " +
		x.top());
			return;
		}
		
		System.out.println("Symbols are balanced");
	}
}
