
/* Data Structures Fall 2016
 * Homework 2
 * This program makes sure that all types of parentheses, quotation marks
 * and block comment symbols are properly balanced. Java files are taken
 * as command line argument. 
 * @author Natasha Porter
 */
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class SymbolBalance {

	public static void main(String[] args) throws IOException {

		MyStack<Character> stack = new MyStack(); //declare new stack
		char c;
		char topOfStack;
		boolean error = false;
		boolean complete = true;

		File testfile = new File(args[0]);


		try {
			Scanner s = new Scanner(testfile);
			s.useDelimiter("");


			//read file character by character
			while(s.hasNext() && error == false) { 
				c = s.next().charAt(0);

				//push open symbols onto stack
				if(c == '(' || c == '{'|| c == '[') {
					stack.push(c);
				}

				if( c == ')'|| c == '}' || c ==']') {
					if(stack.isEmpty() == true) {
						System.out.println("Unbalanced! Symbol " + c + " does not have an opening symbol.");
						error = true;
					}

					else { 
						//check that top of stack matches opening symbol
						topOfStack = (char) stack.pop();
						if( c == ')' && topOfStack != '(') {
							System.out.println("Unbalanced! Symbol " + c + " is mismatched.");
							error = true;
						}

						if( c == '}' && topOfStack != '{') {
							System.out.println("Unbalanced! Symbol " + c + " is mismatched.");
							error = true;
						}
						if( c == ']' && topOfStack == '['){
							System.out.println("Unbalanced! Symbol " + c + " is mismatched.");
							error = true;
						}

						//check that quote expressions are balanced
						if( c == '"'){

							boolean match = false;
							stack.push(c);
							c = s.next().charAt(0);

							//read until we reach closing "
							while( c != '"' && s.hasNext()) {
								c = s.next().charAt(0);
							}

							if (c == '"'){
								stack.pop();
								match = true;
							}
							if(match == false){
								System.out.println("Error: Expression missing " + c );
								error = true;
							}
						}

						//check that block comments are balanced 
						if( c == '/') {
							c = s.next().charAt(0);

							if(c == '*'){
								stack.push('/'); //push block comment symbol onto stack
								stack.push(c);	//push block comment symbol onto stack

								while(complete == false && s.hasNext()) {
									c = s.next().charAt(0); //keep reading until we reach closing symbol
									if(c == '*'){
										c = s.next().charAt(0);
										if(c == '/') {
											complete = true;
											stack.pop();
											stack.pop();
										}
									}
								}

								if(stack.isEmpty() != true && complete == false){
									System.out.println("Error. Unclosed block comment.");
									error = true;
								}
							}
						}

						if( c == '*'){
							if(s.next().charAt(0) == '/'){
								System.out.println("Error, the block comment does not have an opening symbol.");
								error = true;
							}
						}

					}
					if(stack.isEmpty() == false && error == false) {
						c = (char) stack.pop();
						System.out.println("Error: unclosed " + c);
					}
				}
			}
			s.close();
		}

		catch(IOException FileNotFoundException) {
			System.out.println("File not found. Please try again.");
		}
	}
}
