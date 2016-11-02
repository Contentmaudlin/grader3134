import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.List;
import java.util.ArrayList;

public class SymbolBalance {
  /*
    There are two stacks, inputChars and unComplete.
      inputChars takes in all of the following input characters: (, ), {, }, [, ]
      unComplete is a stack for currently unmatched characters as the inputChars stack is being read.
    main() reads the file in, and for each line, checks for comments and string literals. It ignores
    everything in comments and strings, and checks if comments and strings are matched properly.
    In addition, at the end, it checks if anything is left in unComplete, and reports anything remaining
    as an automatic unmatched character (if nothing has been reported yet).
  */
  public static void main(String[] args) {
    if (args.length != 1) {
      System.out.println("Please enter only 1 argument for the file.");
    }
    else {
      MyStack<Character> inputChars = new MyStack();
      MyStack<Character> unComplete = new MyStack();
      boolean comment = false;
      boolean stop = false;

      // The code to read a file came from StackOverflow:
      // http://stackoverflow.com/questions/4716503/reading-a-plain-text-file-in-java
      try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
        String s = br.readLine();
        readLoop: {
          while (s != null) {
            boolean str = false;
            Character prevC = '\0';
            for (int i = 0; i < s.length(); i++) {
              Character currentC = s.charAt(i);

              // Check for single line comments
              if (currentC == '/' && prevC == '/') {
                break;
              }
              else if (currentC == '*' && prevC == '/') {
                comment = true;
              }
              else if (currentC == '/' && prevC == '*') {
                if (comment = false) {
                  stop = true;
                  printMessage("*/");
                  break readLoop;
                }
                comment = false;
              }
              else if (!comment && currentC == '"') {
                str = !str;
              }
              else if (!comment && !str && (currentC == '{' || currentC == '(' || currentC == '[' || currentC == '}' || currentC == ')' || currentC == ']')) {
                inputChars.push(currentC);
              }
              prevC = currentC;
            }

            if (str) {
              stop = true;
              printMessage("\"");
              break readLoop;
            }

            s = br.readLine();
          }
        }
        if (comment) {
          printMessage("/*");
        }
        else if (!stop) {
          if (!analyzeStack(inputChars, unComplete)) {
            if (unComplete.canPop()) {
              printMessage(String.valueOf(unComplete.pop()));
            }
            else {
              System.out.println("No errors found!");
            }
          }
        }
      }
      catch (FileNotFoundException ex) {
        System.out.println(ex);
      }
      catch(IOException ex) {
        System.out.println(ex);
      }
    }
  }

  /*
    analyzeStack() puts any ending characters -- ), }, ] -- into the unComplete stack, since they are unpaired at the moment.
    Then when a completing character is found -- (, {, [ -- it checks to see if it's at the top of unComplete.
    Due to the nature of the stack, the ending characters should be at the top of the unComplete stack for its complementary
    pair at the top of the inputChars stack, so if that doesn't match then there is an unpaired character set.
  */
  public static boolean analyzeStack(MyStack<Character> inputChars, MyStack<Character> unComplete) {
    while(inputChars.canPop()) {
      Character badChar = '\0';
      Character currentC = inputChars.pop();
      if (currentC == ')' || currentC == '}' || currentC == ']') {
        unComplete.push(currentC);
      }
      else if (currentC == '(') {
        if (!unComplete.canPop() || (badChar = unComplete.pop()) != ')') {
          printMessage(String.valueOf(determineBad(currentC, badChar, inputChars, unComplete)));
          return true;
        }
      }
      else if (currentC == '[') {
        if (!unComplete.canPop() || (badChar = unComplete.pop()) != ']') {
          printMessage(String.valueOf(determineBad(currentC, badChar, inputChars, unComplete)));
          return true;
        }
      }
      else if (currentC == '{') {
        if (!unComplete.canPop() || (badChar = unComplete.pop()) != '}') {
          printMessage(String.valueOf(determineBad(currentC, badChar, inputChars, unComplete)));
          return true;
        }
      }
    }
    return false;
  }

  /*
    One issue with analyzeStack() is once it finds an unpaired set, it is unsure which of the two unmatched characters
    is truly the "unpaired" character. That's why determineBad() checks the surrounding characters in the stacks
    to see which character is truly unpaired.
  */
  public static Character determineBad(Character currentC, Character badChar, MyStack<Character> inputChars, MyStack<Character> unComplete) {
    if (badChar == '\0') {
      return currentC;
    }
    else if (inputChars.canPop()) {
      Character left = inputChars.pop();
      if (unComplete.canPop()) {
        Character right = unComplete.pop();
        if (left == badChar) {
          return currentC;
        }
        return badChar;
      }
      else {
        return currentC;
      }
    }
    return badChar;
  }

  /*
    A modularized way to print error messages.
  */
  public static void printMessage(String mes) {
    System.out.println("Unbalanced! " + mes + " is a mismatch.");
  }
}
