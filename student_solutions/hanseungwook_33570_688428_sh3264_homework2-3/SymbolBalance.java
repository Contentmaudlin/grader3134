/* Author: Seungwook Han
 * UNI: sh3264
 * Data Structures
 * SymbolBalance - Using the Stack class defined by MyStack,
 * this class takes in a command line argument of the file to 
 * check whether the symbols are balanced or not
 */

import java.io.*;
import java.util.*;

public class SymbolBalance {

	public static void main(String[] args) {

		/* This reads the command line argument as the name of the file
		 * to be checked whether the symbols are balanced or not
		 * If the file is not in the same directory this try catch will
		 * print the error statement and exit
		 * If no command line argument is given, it will print the respective
		 * statement and exit
		 * @param args is the array used to take in the command line argument
		 */
		if (args[0] != null) {
			String fileName = args[0];

			try {	 
				String text = new Scanner(new File(fileName)).useDelimiter("\\Z").next();
				String result = isBalanced(text);

				if (result.equals("Balanced")) {
					System.out.println("This file is balanced!");
				} else {
					System.out.println("Unbalanced! " + result + " is mismatched.");
				}
			}

			catch (IOException e) {
				System.out.println("Error: File Not Found!");
				System.exit(1);
			}
		}

		else {
			System.out.println("Please provide the test file name as a command line argument.");
			System.exit(1);
		}
	}
	
	/* This is the method that checks whether the specified file, 
	 * which is parsed into a String, has balanced symbols
	 * @param text is the parsed String that contains all the data 
	 * of the specified file
	 * @return this method returns the String unbalancedSymbol
	 * which is compared to see if the file is balanced and, if not,
	 * which symbol is unbalanced
	 */
	private static String isBalanced(String text) {

		// Initializing the variables to be used in the operations below
		
		MyStack<String> stack = new MyStack<>();
		String[] textArr = text.split("(?!^)");
		boolean quotationComplete = true;
		boolean commentComplete = true;
		String unbalancedSymbol = "Balanced";
		int quotationCount = 0;
		int commentCount = 0;
		String cCombined = null;

		/* This for loop goes through the String text character by character
		 * String c is the variable containing each of the element of the String text
		 * String cCombined is the variable concatenating the character and its next
		 * in order to make the comparison with comment open/close symbol which is
		 * two characters long
		 */
		
		for (int i = 0; i < textArr.length; i++) {
			String c = textArr[i];
			if (i < textArr.length - 1) {
				cCombined = textArr[i] + textArr[i + 1];
			} else {
				cCombined = "";
			}

			/* This part deals with the quotation symbol and using the continue
			 * and commentComplete boolean it makes sure that this particular part
			 * is run until the next quotation is found and does not run when the
			 * comment symbol is not closed yet
			 */
			
			if (commentComplete && isQuotation(c)) {
				quotationComplete = false;
				quotationCount++;
				if (quotationCount % 2 == 1) {
					stack.push(c);
					unbalancedSymbol = c;
					continue;
				} else {
					String popS = stack.pop();
					if (!popS.equals("\"")) {
						return unbalancedSymbol = c;
					} else {
						quotationComplete = true;
						unbalancedSymbol = "Balanced";
					}
				}
			}
			
			/* This part deals with the comment symbol and very similar to the
			 * quotation symbol part above, it uses the continue and quotationComplete
			 * boolean in order to ensure that this particular algorithm is run until
			 * the next comment closer is found and does not run the matching quotation 
			 * symbol is not found yet
			 */
			
			if (quotationComplete && isComment(cCombined)) {
				if (isCommentOpen(cCombined)) {
					commentComplete = false;
					if (commentCount == 0) {
						stack.push(cCombined);
						unbalancedSymbol = cCombined;
					}
					commentCount++;
					continue;
				} else {
					if (stack.isEmpty()) {
						return unbalancedSymbol = cCombined;
					} else {
						String popS = stack.pop();
						if (!popS.equals("/*")) {
							return unbalancedSymbol = cCombined;
						} else {
							commentComplete = true;
							commentCount = 0;
							unbalancedSymbol = "Balanced";
						}
					}
				}

			}

			/* This part deals with the {} [] () symbols 
			 * The opening symbols are always pushed to the stack
			 * The close symbols are compared to their respective opening symbols
			 * and if they do not match, unbalancedSymbol is set as the last element
			 * of the stack which is popped and set as a String popS
			 */
			
			if (quotationComplete && commentComplete) {
				if (isOpenSymbol(c)) {
					stack.push(c);
					unbalancedSymbol = c;
				} else if (isCloseSymbol(c)) {
					if (stack.isEmpty()) {
						return unbalancedSymbol = c;
					} else if (c.equals("}")) {
						String popS = stack.pop();
						if (!popS.equals("{")) {
							return unbalancedSymbol = popS;
						} else {
							unbalancedSymbol = "Balanced";
						}
					} else if (c.equals("]")) {
						String popS = stack.pop();
						if (!popS.equals("[")) {
							return unbalancedSymbol = popS;
						} else {
							unbalancedSymbol = "Balanced";
						}
					} else if (c.equals(")")) {
						String popS = stack.pop();
						if (!popS.equals("(")) {
							return unbalancedSymbol = popS;
						} else {
							unbalancedSymbol = "Balanced";
						}
					}

				}
			}
		}

		/* Just in case the stack is still not empty and hasn't returned the 
		 * unbalancedSymbol, this part will ensure that the element in the stack
		 * is popped and set to unbalancedSymbol
		 */
		
		if (!stack.isEmpty()) {
			unbalancedSymbol = stack.pop();
		}

		return unbalancedSymbol;
	}

	/* This method checks whether the string is a quotation
	 * @param c is the string of the character being looked through from the file
	 * @return boolean of whether the string is a quotation or not
	 */
	private static boolean isQuotation(String c) {
		if (c.equals("\"")) {
			return true;
		} else {
			return false;
		}
	}

	/* This method checks whether the string is a comment opener/closer
	 * @param c is the string of the character being looked through from the file
	 * @return boolean of whether the string is a comment opener/closer or not
	 */
	private static boolean isComment(String c) {
		if (c.equals("/*") || c.equals("*/")) {
			return true;
		} else {
			return false;
		}
	}

	/* This method checks specifically whether the string is a comment opener symbol
	 * @param c is the string of the character being looked through from the file
	 * @return boolean of whether the string is a comment opener or not
	 */
	private static boolean isCommentOpen(String c) {
		if (c.equals("/*")) {
			return true;
		} else {
			return false;
		}
	}

	/* This method checks if the string is an opening symbol of {, [, or (
	 * @param c is the string of the character being looked through from the file
	 * @return boolean of whether the string is an opening symbol or not
	 */
	private static boolean isOpenSymbol(String c) {

		if (c.equals("{") || c.equals("[") || c.equals("(")) {
			return true;
		} else {
			return false;
		}
	}

	/* This method checks if the string is a closing symbol of }, ], or )
	 * @param c is the string of the character being looked through from the file
	 * @return boolean of whether the string is a closing symbol or not
	 */
	private static boolean isCloseSymbol(String c) {

		if (c.equals("}") || c.equals("]") || c.equals(")")) {
			return true;
		} else {
			return false;
		}
	}

}
