import java.io.*;
import java.util.Scanner;

public class SymbolBalance {
	// main method
	public static void main(String[] args) {
		// scanner which takes in the name of the file we want t read
		try {
			// scanning to get input
			Scanner scan = new Scanner(System.in);

			// initializing the stack
			MyStack<Character> stack = new MyStack<Character>();
			// ask the user what the file name is
			System.out.println("Please enter the file name you want to check:");
			// getting the input and storing it in filename
			String filename = scan.next();
			//close your scanner
			scan.close(); 
			// reading the file (using a try block)
			// use buffered reader to read the data from filename
			BufferedReader br = new BufferedReader(new FileReader(filename));
			// making the file one string
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			// add to string as long as there are words
			while (line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
			}
			//close br 
			br.close();
			
			// converting input to string
			String s = sb.toString();

			// check for the error where the ending has an open symbol
			char lastSymbol = s.charAt(s.length() - 1);
			if (lastSymbol == '[' | lastSymbol == '(' | lastSymbol == '{') {
				throw new Exception(" File ends with opening symbol " + lastSymbol);

			}
			// checking for the comments error
			else if (s.charAt(s.length() - 1) == '*' & s.charAt(s.length() - 2) == '\\') {
				throw new Exception(" File ends with opening symbol '\\*' ");

			}

			// checking to see if the quotes are balanced
			boolean quotes = false;
			// checking to see if the comments are
			boolean comments = false;

			// iterates through the data in order to see if there is any
			// unbalanced symbols
			for (int i = 0; i < s.length(); i++) {
				char symbol = s.charAt(i);
				// check to see if you can find another " symbol
				if (symbol == '"') {
					if (quotes == false && comments == false) {
						quotes = true;

					} else {
						quotes = false;

					}

				}

				// checking to see if you have an opening comments block
				if (symbol == '/' && (s.charAt(i + 1) == '*') && quotes == false) {
					// if you see a comments block opening, then change the
					// boolean to true
					comments = true;
				}

				// checking to see if you have a closing comments block
				if (symbol == '*' && (s.charAt(i + 1) == '/') && quotes == false) {
					// checking to see if the comments were opened before
					if (comments = true) {
						comments = false;
					} else
						throw new Exception("There is a closing symbol without an opening symbol for '*/'");

				}

				if (quotes == false && comments == false) {
					/// check to see if you have an opening brace, then push it
					if (symbol == '{' || symbol == '(' || symbol == '[') {
						stack.push(symbol);
					}
					// check to see if there is a closing brace
					if (symbol == '}') {
						// this is checking to see if the stack is empty or not
						if (stack.isEmpty()) {
							throw new Exception("There is a closing symbol without an opening symbol for " + symbol);

						}
						// determining the value of the popped element
						char removedSymbol = stack.pop();
						if (removedSymbol != '{') {
							throw new Exception("There is a mismatch between opening and closing symbols for " + symbol
									+ " and " + removedSymbol);

						}
					}
					//
					if (symbol == ')') {
						// this is checking to see if the stack is empty or not
						if (stack.isEmpty()) {
							throw new Exception("There is a closing symbol without an opening symbol for " + symbol);

						}
						// determining the value of the popped element
						char removedSymbol = stack.pop();
						if (removedSymbol != '(') {
							throw new Exception("There is a mismatch between opening and closing symbols for " + symbol
									+ " and " + removedSymbol);

						}
					}
					//
					if (symbol == ']') {
						// this is checking to see if the stack is empty or not
						if (stack.isEmpty()) {
							throw new Exception("There is a closing symbol without an opening symbol for " + symbol);

						}
						// determining the value of the popped element
						char removedSymbol = stack.pop();
						if (removedSymbol != '[') {
							throw new Exception("There is a mismatch between opening and closing symbols for " + symbol
									+ " and " + removedSymbol);

						}
					}
				}

			}
			// if there are no closing symbols for quotations
			if (quotes == true) {
				throw new Exception("There is no closing symbol for \" ");

			}

			// if there are no closing symbols for comments
			if (comments == true) {
				throw new Exception("There is no closing symbol for \\*");
			}
			// check if the stack is empty or not
			if (!stack.isEmpty()) {
				// check what is the error in the stack
				char remainingElement = stack.pop();
				throw new Exception("There is no closing symbol for " + remainingElement);
			}

		} 
		
		catch (Exception e){
			System.out.println(e.getMessage());
		}
		
	}

}// end class
