// SymbolBalance.java
// Data Structures - Homework 2
// Connor Goggins

import java.io.File;
import java.util.Scanner;

public class SymbolBalance {
  public static void main(String[] args) {
    // Lines with "SO" comments are from Stack Overflow on reading the text from a Java file into a String.
    File file = new File(args[0]); // SO
    try {
      String contents = new Scanner(file).useDelimiter("\\Z").next(); // SO

      // Instantiates a new stack object of strings using my generic stack class.
      MyStack<String> openClose = new MyStack<String>();

      // Variables for checking if the loop is currently in an area of the String within a comment or a literal string.
      // If the loop is inside a comment or literal string, no symbols should be pushed to the stack as they are irrelevant for our purposes.
      boolean inComment = false;
      boolean inString = false;

      // Variable for checking if the loop has thrown an error.
      boolean threwError = false;

      // Iterate through the string composed of the file contents and push the opening symbols to the stack.  When a closing symbol is encountered,
      // check if the symbol at the top of the stack is its opposite (ex. the opposite of } would be {).  If not, there is an error.
      for(int i = 0; i < contents.length(); i++) {
        char currentChar = contents.charAt(i);
        String pushString = "" + currentChar;

        // Push opening symbols
        if((currentChar == '{' || currentChar == '[' || currentChar == '(') && inComment == false && inString == false) {
          openClose.push(pushString);
        }

        else if(currentChar == '}' && inComment == false && inString == false) {
          if (openClose.isEmpty() == true) {
            System.out.println("Error: Closing symbol } has no corresponding opening symbol.");
            threwError = true;
            break;
          }
          else if(openClose.top().compareTo("{") == 0) {
            openClose.pop();
          }
          else {
            System.out.println("Error: Mismatched symbol }");
            threwError = true;
            break;
          }
        }

        else if(currentChar == ']' && inComment == false && inString == false) {
          if (openClose.isEmpty() == true) {
            System.out.println("Error: Closing symbol ] has no corresponding opening symbol.");
            threwError = true;
            break;
          }
          else if(openClose.top().compareTo("[") == 0) {
            openClose.pop();
          }
          else {
            System.out.println("Error: Mismatched symbol ]");
            threwError = true;
            break;
          }
        }

        else if(currentChar == ')' && inComment == false && inString == false) {
          if (openClose.isEmpty() == true) {
            System.out.println("Error: Closing symbol ) has no corresponding opening symbol.");
            threwError = true;
            break;
          }
          else if(openClose.top().compareTo("(") == 0) {
            openClose.pop();
          }
          else {
            System.out.println("Error: Mismatched symbol )");
            threwError = true;
            break;
          }
        }

        // Logic for handling literal strings
        else if (currentChar == '"') {
          if (i > 0) {
            if (contents.charAt(i - 1) != '\\' && inComment == false) {
              if (inString == false) {
                openClose.push(pushString);
                inString = true;
              }
              else {
                if (openClose.top().compareTo("\"") == 0) {
                  openClose.pop();
                  inString = false;
                }
                else {
                  System.out.println("Error: Mismatched symbol \"");
                  threwError = true;
                  break;
                }
              }
            }
          }
          else {
            openClose.push(pushString);
            inString = true;
          }
        }

        // Logic for handling block comments
        else if (i+1 < contents.length() && currentChar == '/' && contents.charAt(i + 1) == '*' && inString == false && inComment == false) {
          pushString = "/*";
          openClose.push(pushString);
          inComment = true;
          i = i+1;
        }
        else if (i+1 < contents.length() && currentChar == '*' && contents.charAt(i + 1) == '/' && inString == false) {
          if (openClose.isEmpty() == true) {
            System.out.println("Error: Closing symbol */ has no corresponding opening symbol.");
            threwError = true;
            break;
          }
          else if(openClose.top().compareTo("/*") == 0)
          {
            openClose.pop();
            inComment = false;
          }
          else {
            System.out.println("Error: Mismatched symbol */");
            threwError = true;
            break;
          }
        }
      }

      // Check if the program encountered an error in the for loop.  If not, check for any final unbalanced symbols.
      if (threwError == false) {
        if (openClose.top() != null) {
          System.out.println("Error: Unbalanced symbol " + openClose.top());
        }
        else {
          System.out.println("All symbols are balanced");
        }
      }
    }
    catch(Exception e){
      System.out.println(e);
    }
  }
}
