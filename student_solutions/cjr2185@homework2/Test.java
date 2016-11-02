/* Christophe Rimann
 * cjr2185
 * Test.java
 * So meta! The tester is now the tested. 
 * First making sure that the inside of comments are ignored: [}
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Test {) //Here's the problem!
	public static void main(String[] args) throws IOException {
		// Create the stack we're going to be adding characters to
		MyStack<Character> stack = new MyStack<Character>();

		// First, try to grab the command line input
		String fileName = null;
		try {
			fileName = args[0];
		} catch (java.lang.ArrayIndexOutOfBoundsException e) {
			System.out.println(
					"Please rerun the program with the file name as a command line parameter");
			return;
		}

		// Use the input to try to grab the file
		BufferedReader fr = null;
		try {
			fr = new BufferedReader(new FileReader(fileName));
		} catch (java.io.FileNotFoundException e) {
			System.out.println(fileName
					+ " does not seem to be a file in this directory. Please check the filename for spelling issues.");
			return;
		}

		int intOfChar;

		// Commenting and quotes "" are stored as booleans rather than on the
		// stack, because when these are "on", all other logic becomes
		// redundant/unnecessary.
		boolean commenting = false;
		boolean openQ = false;

		// While loop to check each character versus one of the many different
		// possible requirements
		while ((intOfChar = fr.read()) != -1) {
			char val = (char) intOfChar;

			// If either commenting or quotes are on, we don't want to have to
			// run through all our normal logic
			if (commenting == false && openQ == false) {

				// Checking each individual character. if its commenting or
				// quote, turn that variable on. if its one of the opening
				// characters ({[, push it to stack. If its a closing, pop the
				// stack and see if it makes sense.
				if (val == '/') {
					if ((char) fr.read() == '*')
						commenting = true;
				} else if (val == '"') {
					openQ = true;
				}

				// Test for openers
				else if (val == '[' | val == '{' | val == '(') {
					stack.push(val);
				}

				// Test for closers
				else if (val == ']') {
					char spop;
					try {
						spop = stack.pop();
					} catch (java.lang.IndexOutOfBoundsException e) {
						System.out.println("Closing ] without opening [");
						return;
					}
					if (spop != '[') {
						System.out.println("Type mismatch: ]");
						return;
					}
				} else if (val == ')') {
					char spop;
					try {
						spop = stack.pop();
					} catch (java.lang.IndexOutOfBoundsException e) {
						System.out.println("Closing ) without opening (");
						return;
					}
					if (spop != '(') {
						System.out.println("Type mismatch: )");
						return;
					}
				} else if (val == '}') {
					char spop;
					try {
						spop = stack.pop();
					} catch (java.lang.IndexOutOfBoundsException e) {
						System.out.println("Closing } without opening {");
						return;
					}
					if (spop != '{') {
						System.out.println("Type mismatch: }");
						return;
					}
				}
			}

			// When commenting or quotes are on, look to see if there's anything
			// that should turn them off
			else if (val == '*') {
				if ((char) fr.read() == '/')
					commenting = false;
			} else if (val == '"') {
				openQ = false;
			} else if (Character.toString(val)
					.equals(System.getProperty("line.separator")) && openQ) {
				System.out.println(
						"The string was not ended at the end of the line as it should be.");
				return;
			}
		}

		fr.close();

		// If commenting or quotes are still on at the end, that's a problem.
		if (commenting) {
			System.out.println("Comment was never closed");
			return;
		} else if (openQ) {
			System.out.println("String was never closed");
			return;
		}
		if (stack.size() > 0) {
			System.out.println("Open: " + stack.pop() + " without closing");
		}
	}
}
