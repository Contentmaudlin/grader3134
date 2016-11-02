
//Name: Yiwei Lian
//UNI: yl3434
//Date: 10/10
//Assignment: HW2
import java.io.*;
import java.util.*;

public class SymbolBalance {
	// implementing stack from MyStack
	static MyStack<Character> thisStack;

	// main method takes in argument and calls methods
	public static void main(String[] args) throws FileNotFoundException {
		// take name of java file as command line argument
		thisStack = new MyStack<Character>();
		File file = new File(args[0]);
		// if there is no arg then print out message
		if (!file.exists()) {
			System.out.println(args[0] + " does not exist.");
			return;
		}
		// call method balanced
		String isBalanced = balanced(readFile(file));
		if (isBalanced == " ") {
			System.out.println("Balanced! There are no mismatched symbols");
		} else
			System.out.println("Unbalanced! Symbol " + isBalanced + " is " + "mismatched.");
	}

	// method to convert File type to string type using Scanner
	private static String readFile(File file) throws FileNotFoundException {

		StringBuilder contents = new StringBuilder((int) file.length());
		Scanner scanner = new Scanner(file);
		try {
			while (scanner.hasNextLine()) {
				contents.append(scanner.nextLine());
			}
			return contents.toString();
		} finally {
			scanner.close();
		}
	}

	// call methods from MyStack.java to return boolean if symbols are
	// balanced
	private static String balanced(String file) {
		boolean commentBlock = false;
		boolean quotes = false;
		// read file token by token
		for (int i = 0; i < file.length(); i++) {
			Character ch = file.charAt(i);
			// testing for comment block symbol
			if (i < file.length() - 1) {
				Character chNext = file.charAt(i + 1);
				// set boolean to true when finding open symbols and continue
				if (ch == '/' && chNext == '*' && quotes == false) {
					commentBlock = true;
					continue;
				}
				// set boolean to false when finding close symbols
				if (commentBlock == true && quotes == false && ch == '*' && chNext == '/') {
					commentBlock = false;
				}
				// set boolean to true if find opening quotes
				if (ch == '"' && commentBlock == false) {
					quotes = true;
					continue;
				}
				// set boolean back to false if find closing quotes
				if (quotes == true && ch == '"' && commentBlock == false) {
					quotes = false;
				}

				// if not comment block symbol or quotes
				if (commentBlock == false && quotes == false) {
					// find open symbol and push to stack
					if (ch == '(' || ch == '[' || ch == '{')
						thisStack.push(ch);
					// if find close symbol and don't find corresponding symbol
					// in stack then return the close symbol
					else if (ch == ']') {
						if (thisStack.isEmpty() || thisStack.pop() != '[')
							return "]";
					} else if (ch == ')') {
						if (thisStack.isEmpty() || thisStack.pop() != '(')
							return ")";
					} else if (ch == '}') {
						if (thisStack.isEmpty() || thisStack.pop() != '{') {
							System.out.println("asdf");
							return "}";
						}
					}
				}

			}
		}
		// if boolean is still true means that there is no closing
		// comment block or quotes, so return it
		if (commentBlock == true)
			return "/*";
		if (quotes == true)
			return "\"";
		// if stack is not empty at the end then also give error
		if (!thisStack.isEmpty())
			return " not closed";
		// everything is balanced, return " "
		String balanced = " ";
		return balanced;
		
	}

}
