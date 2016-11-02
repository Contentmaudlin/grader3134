
/**
 * 
 * @author gracemilstein
 * gam2138
 *
 */

/**
 * 
 * @author gracemilstein
 * gam2138
 *
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SymbolBalance {

	public static void main(String[] args) throws FileNotFoundException {

		File input = new File(args[0]);
		Scanner in = new Scanner(input);

		MyStack<Character> stack = new MyStack<Character>();

		// scan file
		boolean isBalanced = true;
		boolean inQuotes = false;
		boolean inComments = false;
		char prev = ' ';
		while (in.hasNextLine() && isBalanced) {
			String line = in.nextLine();
			for (int i = 0; i < line.length(); i++) {
				char c = line.charAt(i); // referred to stackoverflow

				if ((c == '[' || c == '{' || c == '(') && inQuotes == false
						&& inComments == false) {
					stack.push(c);

				}

				else if (c == ']' && inQuotes == false && inComments == false) {
					if (stack.isEmpty() == true) {
						System.out.println("Closed symbol w/o opening symbol");
						isBalanced = false;
						break;

					}
					if (stack.pop() != '[' && inQuotes == false
							&& inComments == false) {
						System.out
								.println("Unbalanced! Symbol ] is mismatched.");
						/*
						 * There is a mismatch between closing and opening
						 * symbols (for example: { [ } ] )
						 */
						isBalanced = false;
						break;
					}

				}

				else if (c == '}' && inQuotes == false && inComments == false) {
					if (stack.isEmpty() == true) {
						System.out.println("Closed symbol w/o opening symbol");
						isBalanced = false;
						break;

					}
					if (stack.pop() != '{' && inQuotes == false
							&& inComments == false) {
						System.out
								.println("Unbalanced! Symbol } is mismatched.");
						/*
						 * There is a mismatch between closing and opening
						 * symbols (for example: { [ } ] )
						 */
						isBalanced = false;
						break;
					}
				}

				else if (c == ')' && inQuotes == false && inComments == false) {
					if (stack.isEmpty() == true) {
						System.err.println("Closed symbol w/o opening symbol");
						isBalanced = false;
						break;

					}

					if (stack.pop() != '(') {
						System.out.println(
								"Unbalanced! Symbol )s is mismatched.");
						/*
						 * There is a mismatch between closing and opening
						 * symbols (for example: { [ } ] )
						 */
						isBalanced = false;
						break;
					}

				}

				else if (c == '"' && inComments == false) {
					if (inQuotes) {
						if (stack.isEmpty() == true) {
							System.err.println(
									"Closed symbol w/o opening symbol");
							isBalanced = false;
							break;

						} else if (stack.pop() != '"') {
							System.out.println(
									"Unbalanced! Symbol \" is mismatched.");
							/*
							 * There is a mismatch between closing and opening
							 * symbols (for example: { [ } ] )
							 */

							isBalanced = false;
							break;
						}
						inQuotes = false;
					} else {
						stack.push(c);
						inQuotes = true;
					}

				}

				else if (c == '*' && prev == '/' && inQuotes == false
						&& inComments == false) {
					stack.push('/');
					inComments = true;
				} else if (c == '/' && prev == '*' && inQuotes == false
						&& inComments == true) {
					if (stack.isEmpty() == true) {
						System.err.println("Closed symbol w/o opening symbol");
						isBalanced = false;
						break;

					} else if (stack.pop() != '/') {
						System.out.println(
								"Unbalanced! Symbol (Comment) is mismatched.");
						isBalanced = false;
						break;
					}
					inComments = false;
				}

				prev = c;

			}

		}

		if (stack.isEmpty() == false && isBalanced == true) {
			System.err.println(
					"File ends with one or more opening symbols missing their corresponding closing symbols");
		} else if (isBalanced == true) {
			System.out.println("Program is balanced");
		}
		in.close();
	}

}

// push left values on

// when get to right symbol

// pop last value off
// compare to left value
// if match continue
// if mismatch
// print mismatch and break
// if stack is empty
// closing symbol without opening symbol

// if done and size of the stack is >0
// file ends with one or more opening symbols

// push left values on

// when get to right symbol

// pop last value off
// compare to left value
// if match continue
// if mismatch
// print mismatch and break
// if stack is empty
// closing symbol without opening symbol

// if done and size of the stack is >0
// file ends with one or more opening symbols
