/* Trung Vu
 * UNI: ttv2107
 * COMS W3134
 * Homework 2
 * October 7th, 2016
 */
import java.io.*;

public class SymbolBalance {
	public static void main(String[] args) {
			balance(args[0]);
	}	

    public static boolean open(Character c) {
        // This function returns whether c is an opening symbol
        if ((c.equals('\"')) || (c.equals('(')) || (c.equals('{')) || 
                (c.equals('[')) || (c.equals('/'))) {
            return true;
        } 
        return false;
    }

    public static boolean close(Character c) {
        // This function returns whether c is a closing symbol
        if ((c.equals('\"')) || (c.equals(')')) || (c.equals('}')) || 
                (c.equals(']')) || (c.equals('*'))) {
            return true;
        }
        return false;
    }

    public static Character corr(Character c) {
        // This function returns the corresponding symbols for c, opening 
        // symbols are not considered because there are never queried.
        switch (c) {
            case ')': return '(';
            case ']': return '[';
            case '}': return '{';
            case '\"': return '\"';
            case '*': return '/';
            default: return null;
        }
    }
	public static void balance(String file){
        // This method checks the balanceness of the file by 
        // reading it line by line.
        //
        // A. Basic premise: The method checks for balanceness using a stack
        // containing all the opening symbols that have not been "closed"
        // by a corresponding closing symbol.
        //
        // B. Implementation outline:
        // If there is an opening symbol, that symbol is pushed into the stack.
        //
        // Imbalance is detected through 3 ways:
        // 1. If there is a closing symbol and it doesn't match the opening
        // symbol on top of the stack, then the method prints a "mismatch" error
        // and exits.
        // 2. If there is a closing symbol and the stack is empty, then the 
        // method prints a "closing symbol without opening symbol" error and
        // exits. 
        // 3. If the stack is not empty by the end of the file, then the method
        // prints a "more opening symbols than closing symbols" error and exits.
        //
        // C. Handling string literals and comment blocks
        // The method handles string literals and comment blocks by triggering
        // a free mode every time a " or /* symbol is encountered. In free mode,
        // the method will not be pushing new symbols to the stacks or 
        // checking for errors. Once another " or */ is encounter, the method
        // exits free mode and resumes checking erorrs.
        //
        // D. Some notes on handling ":
        // The " symbol constitutes an interesting "border" case, since 
        // the opening symbol and the closing symbol are the same. This issue
        // can be resolved by recognizing that a " is only a closing symbol 
        // when there is a " on top of the stack. Because a  " starts a string
        // literal, there will be no additional opening symbols pushed onto 
        // the stack until the next ", which must be the corresponding closing
        // symbol. Hence, all " are recognized as opening symbol, unless 
        // there is a corresponding " on top of the stack. Thus, the "
        // symbol cannot trigger the "mismatch" error and the "closing
        // without opening" error, and so these two errors are disabled for
        // the " symbol. 

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			MyStack<Character> stack = new MyStack<>();
			String line;
			boolean freeMode = false;
			while ((line = br.readLine()) != null) {
                line = line.replaceAll("\\s",""); //Trim all white spaces
                                                 //for faster processing
				for (int i = 0; i < line.length(); i++) {
                    Character c = line.charAt(i);
				    
					// The lines below checks for "/*" 
					// and "*/" symbols
					// by checking the next character 
					// in the line
                    if (c == '/') {
                        // If '/' isn't followed by '*',
                        // then the character's not going to be
                        // process, so we skip to next character
                        if (i == line.length() -1) {
                            continue; 
                        } else if (line.charAt(i+1) != '*') {
                            continue;
                        } 
                    } else if (c == '*') {
                        // If '/' isn't followed by '*',
                        // then the character's not going to be
                        // process, so we skip to next character
                         if (i == line.length() - 1) {
                            continue; 
                         } else if (line.charAt(i+1) != '/') {
                            continue;
                         }
                    }

                    // The if-block below handles the character in case it's 
                    // a closing symbol

					if (close(c) == true) { 
                        // The if-block below detects "closing symbol 
                        // without opening symbol" errors. 
                        // This detection is "disabled"
                        // during free mode. If the closing symbol is a ",
                        // then it is not considered for error detection.
						if ((stack.empty()) && (!freeMode) && 
                                !(c.equals('\"'))) {
                            System.out.println("Closing symbol " + c +
                                    " without opening symbol!");
                            return;
                        }
                        
                       if (!stack.empty()) {
                            // The if-block below detects "mismatch" errors. 
                            // This detection is "disabled" during free mode. If
                            // the closing symbol is a ", then it is not
                            // considered for error detection.
                        
                            if (!(corr(c).equals(stack.peek()))
                                && (!freeMode) && !(c.equals('\"'))) {
                                    System.out.println("Symbol " + c
                                            + " is mismatched!");
                                    return;
                                }
                            
                            // The if-block below checks if the closing symbol
                            // matches the opening symbol on top of the stack.
                            // If it does, then the opening symbol is popped.
                            // Furthermore, if the program is in free mode 
                            // (which means the opening symbol on top of the 
                            // stack is /* or "), then free mode ends.
                            if (corr(c).equals(stack.peek())) {
                                if (freeMode) {
                                    freeMode = false;
                                }
                                stack.pop();
                                continue;
                           }
                        }

                    }

                    // The if block below handles the character when it is 
                    // an opening symbol. It is disabled in free mode.
                    if ((open(c) == true) && (!freeMode)) {
                        // Push the opening symbol into a stack. If it is a "
                        // or /*, which signifies the start of a string literal
                        // or comment block, then free mode starts.
                        
                        stack.push(c);
                        if ((c.equals('\"')) || (c.equals('/'))) {
                            freeMode = true;
                        }
                    }
				}
			}

            // If the stack is not empty by the end of the file, then print
            // "more opening symbols than closing symbols" error. If the stack
            // is empty, then then file is balanced.
            if (!stack.empty()) {
                System.out.println("There are more opening symbols than closing" 
                        + " symbols in this file");
            } else {
                System.out.println("The file is balanced!");
            }
		} catch (IOException e) {
            e.printStackTrace();
        }
	}
}
