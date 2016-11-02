/* Boya Wang
 * bw2462
 * SymbolBalance.java
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.io.FileInputStream;

public class SymbolBalance {
	static boolean is_balance;

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(    //Using buffered reader to read the java file
   			new InputStreamReader(
        	new FileInputStream(new File(args[0])),
        	Charset.forName("UTF-8")));
		MyStack<Character> mystack = new MyStack<Character>();
		Character chr;
		Character pop;
		boolean in_comment = false;  //boolean to check if a character being read is in a block comment.
		boolean in_string = false;   //boolean to check if a character being read is in a string. 
		boolean is_balance = true;   //boolean to check if all the elements are in balance.
		int c;

		while ((c = reader.read()) != -1) {  //c is the character being read. If c=-1, it means there's no more character.
			chr = (char) c;

			//check comment block balance
			if (in_comment) {
				if (chr == '*') {
					int next_chr;
					if ((next_chr = reader.read()) == -1) {
						is_balance = false;
						break;
					}
					if ((char) next_chr == '/') {
						in_comment = false;
					}
				}
				continue;
			}
			if (chr == '/') {
				int next_chr;
				if ((next_chr = reader.read()) == -1) {
					is_balance = false;
					break;
				}
				if ((char) next_chr == '*') {					
					in_comment = true;
					continue;
				}
				chr = (char) next_chr;
			}

			//check string balance
			if (in_string) {
				if (chr == '"') {
					in_string = false;
				}
				continue;
			}
			if (chr == '"') {
				in_string = true;
				continue;
			}
			
            //Check the other braces
			if ((chr == '{') || (chr == '(') || (chr == '[')) {
				mystack.push(chr);
			} else if (chr == '}') {
				if (mystack.isEmpty()) {
					unbalanced('}');
					is_balance = false;
					break;
				}
				pop = mystack.pop();
				if (pop != '{') {
					unbalanced('}');
					is_balance = false;
					break;
				}
			} else if (chr == ')') {
				if (mystack.isEmpty()) {
					unbalanced(')');
					is_balance = false;
					break;
				}
				pop = mystack.pop();
				if (pop != '(') {
					unbalanced(')');
					is_balance = false;
					break;
				}
			} else if (chr == ']') {
				if (mystack.isEmpty()) {
					unbalanced(']');
					is_balance = false;
					break;
				}
				pop = mystack.pop();
				if (pop != '[') {
					unbalanced(']');
					is_balance = false;
					break;
				}
			}
		}
		//To check in the end, if the string is properly closed.
		if (in_string) {
			unbalanced('"');
			is_balance = false;
		}
		//To check in the end, if the stack is not empty.
		if (!mystack.isEmpty() && is_balance) {
			pop = mystack.pop();
			unbalanced(pop);
			is_balance = false;
		} 
		if (is_balance) {
			System.out.println("Symbols are balanced!");
		}
	}
    
	//The method to print out corresponding error messages. 
	public static void unbalanced(char c) {
		System.out.println("Unbalanced! Symbol " + Character.toString(c) + " is mismatched.");
	}
}