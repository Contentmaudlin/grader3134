//Natalie Sayegh
//October 10
//Programming 1
//Checks an input file for imbalances in { ( [ “ /*

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class SymbolBalance {

	public static String checkBalance(String fileName) throws FileNotFoundException {
		MyStack<Character> stack = new MyStack<>();
		File testFile = new File(fileName);
		Scanner input = new Scanner(testFile);

		String result = "Yay. All symbols are balanced.";
		boolean errorFound = false;
		boolean inComment = false;
		boolean inString = false;

		while (input.hasNextLine() && !errorFound) {
			String line = input.nextLine();

			int i = 0;
			while (i < line.length() && !errorFound) {
				char current = line.charAt(i);
				
				// update inString and inComment
				if (current == '"') {
					if (!inComment) {
						if (!inString)
							inString = true;
						else // inString == true
							inString = false;
					}
				}

				else if (current == '/') {
					if (!inComment && !inString) {
						i++;
						if (i < line.length()) {
							current = line.charAt(i);
							if (current == '*')
								inComment = true;
						}
					}
				}

				else if (current == '*') {
					if (inComment) {
						i++;
						if (i < line.length()) {
							current = line.charAt(i);
							if (current == '/')
								inComment = false;
						}
					}
				}

				else { // the current character is something other than *, /, or
						// "
					if (!inComment && !inString) {
						if (current == '{' || current == '(' || current == '[') {
							stack.push(current); // push opening symbols onto
													// the
													// stack
						} else if (current == '}' || current == ')' || current == ']') { // check
																							
// closing
																							
// symbols
							if (stack.isEmpty()) { // error case 1: closing
													// symbol
													// with
													// empty stack
								errorFound = true;
								result = "Error! Closing symbol " + current + " without opening one.";
							} else {
								char top = stack.pop();
								if (current != partner(top)) { // error case 2:
																// mismatched
																// symbols
									errorFound = true;
									result = "Error! Symbol " + top + " mismatched with " + current;
								}
							}
						}
					}
				}
				i++;
				if (inString && i == line.length()) { // no closing " by end of
														// line
					errorFound = true;
					result = "Error! Unclosed string literal.";
				}
			} // end of inner while loop (end of line, or error found)
		} // end of outer while loop (end of file, or error found)

		if (!errorFound) { // if no errors yet found at end of file, check
							// additional
							// conditions.
			if (!stack.isEmpty()) { // opening symbols left in the stack
				errorFound = true;
				if (inComment) {
					result = "Error! Unclosed block comment, missing */.";
				} else {
					result = "Error! Closing symbols not found for: ";
					while(!stack.isEmpty()) {
						char character = stack.pop();
						result = result + character + " ";
					}
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Please provide a file name as a command line argument.");
			System.exit(0);
		}
		try {
			System.out.println(checkBalance(args[0]));
		} catch (FileNotFoundException e) {
			System.out.println("Invalid file name.");
			System.exit(0);
		}
	}

	private static char partner(char a) {
		if (a == '{')
			return '}';
		else if (a == '(')
			return ')';
		else if (a == '[')
			return ']';
		else
			return 'x';
	}

} // end of class
