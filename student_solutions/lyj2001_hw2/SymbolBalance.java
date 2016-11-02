/******************************************************************************
 * By: Lydia Jiang
 * Class; SymbolBalance
 * Checks to see if brackets, quotes, and comment blocks are balanced and
 * output the first type of error if any.
 ******************************************************************************/

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class SymbolBalance {

	public SymbolBalance() {

	}

	/*
	 * @name balance
	 * 
	 * @param String fileName
	 * 
	 * @return void
	 * 
	 * checks to see if brackets, quotes, and block comments are balanced in a
	 * given file of code
	 */

	public static void balance(String fileName) {

		// stack of symbols to be balanced
		MyStack<Character> symbolStack = new MyStack<Character>();
		char currentSymbol;

		// true when an error is found to terminate program, false otherwise
		boolean end = false;

		// negative for false, positive for true. This is to ignore code in
		// quotations and block comments. It is also used to distinguish between
		// quotation ignore and block comment ignore
		int ignore = -1;

		// try catch to read an input file
		try {
			Scanner in = new Scanner(new FileReader(fileName));

			// read file line by line
			while (in.hasNextLine()) {
				String code = in.nextLine();

				// read line character by character
				for (int i = 0; i < code.length(); i++) {
					currentSymbol = code.charAt(i);

					// if in a quote and end quote is found, set ignore back
					// to false, pop the stack
					if (ignore == 1) {
						if (currentSymbol == '"') {
							ignore = -2;
							symbolStack.pop();
						}
					}

					// if in a block comment and end comment is found, set
					// ignore back to false, pop the stack, increment i to
					// skip over the next character
					else if (ignore == 2) {
						if (currentSymbol == '*') {

							// make sure * isn't the end of the line
							if (i < code.length() - 1) {
								if (code.charAt(i + 1) == '/') {
									ignore = -2;
									symbolStack.pop();
									i++;
								}
							}
						}
					}

					// if ignore is false
					if (ignore == -1) {

						switch (currentSymbol) {
						case '(':
							symbolStack.push(currentSymbol);
							break;

						case '[':
							symbolStack.push(currentSymbol);
							break;

						case '{':
							symbolStack.push(currentSymbol);
							break;

						// opening quote
						case '"':
							ignore = 1; // ignore = true
							symbolStack.push(currentSymbol);
							break;

						// opening comment block
						case '/':

							if (i < code.length() - 1) {

								if (code.charAt(i + 1) == '*') {
									i++;
									symbolStack.push(currentSymbol);
									ignore = 2; // ignore is true
								}

							}
							break;

						case ')':
							if (!symbolStack.isEmpty()) {
								char top = symbolStack.pop();
								if ('(' != top) {
									System.out.println("Symbol ) is " + 
								"mismatched!");

									// terminate program
									end = true;
									return;
								} else
									break;
							} else {
								System.out.println(currentSymbol + " has no " + 
							"opening");
								end = true;
								return;
							}

						case ']':
							if (!symbolStack.isEmpty()) {
								char top = symbolStack.pop();
								if ('[' != top) {
									System.out.println("Symbol ] is " + 
								"mismatched!");
									end = true;
									return;
								} else
									break;
							} else {
								System.out.println(currentSymbol + " has no " + 
							"opening");
								end = true;
								return;
							}
						case '}':
							if (!symbolStack.isEmpty()) {
								char top = symbolStack.pop();
								if ('{' != top) {
									System.out.println("Symbol } is " + 
								"mismatched!");
									end = true;
									return;
								} else
									break;
							} else {
								System.out.println(currentSymbol + " has no " + 
							"opening");
								end = true;
								return;
							}
						}

					}
					// set ignore back to -1 false again
					if (ignore == -2)
						ignore = -1;
				}

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (end == false && symbolStack.isEmpty()) //no left overs in stack
				System.out.println("Brackets are balanced!");

			else {
				// accounts for empty symbolStack but just a closing
				if (end == false && !symbolStack.isEmpty()) {
					if (symbolStack.peek() == '/')
						System.out.println("/* is not closed!");
					else
						System.out.println("Symbol " + symbolStack.peek() + 
								" is not closed");
				}
			}
		}

	}

	public static void main(String[] args) {
		try {
			String code = args[0];
			balance(code);
		} catch (Exception e) {
			System.out.println("Error");
		}
	}

}

