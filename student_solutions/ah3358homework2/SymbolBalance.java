/**
 * Name: Anlan Huang  UNI: ah3358
 *
 * Take the name of a java file as a command line argument. Read in the
 * file and check that all { }'s, ( )'s, [ ]'s, " "'s are properly balanced.
 * Ignore characters within literal strings and comment blocks.
 *
 * The program should output whether or not the symbols are all appropriately
 * balanced. If they are not, indicate which error condition occurred and
 * what symbol type caused the problem.
 *
 * Created by anlan on 9/30/16.
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SymbolBalance {

    public static void checkBalance(String path) {
        try {
            checker(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void checker(String path) throws IOException {
        MyStack<Character> myStack = new MyStack<Character>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader
                (path));

        try {
            String line;
            boolean hasBeginningQuotationMark = false;
            boolean hasBeginningCommentMark = false;
            int lineNumber = 0;

            // Using bufferedReader to read line by line
            while ((line = bufferedReader.readLine()) != null) {
                line = line.trim();
                lineNumber++;

                // Examine each character in a line
                for (int i = 0; i < line.length(); i++) {
                    char symbol = line.charAt(i);

                    // Examine whether there is a closing comment block
                    // given there is an opening comment mark
                    if (hasBeginningCommentMark) {
                        if (symbol == '*') {
                            if (i + 1 < line.length() && line.charAt(i + 1)
                                    == '/') {
                                myStack.pop();
                                hasBeginningCommentMark = false;
                                i++;
                            }
                        }
                        continue;
                    }

                    // Examine whether we have the closing quotation mark
                    // give there is an opening quotiation mark
                    if (hasBeginningQuotationMark) {
                        if (symbol == '"') {
                            myStack.pop();
                            hasBeginningQuotationMark = false;
                        }
                        continue;
                    }

                    // Check whether we have an annotation symbol. If
                    // yes, ignore the later characters
                    if (symbol == '/' && line.charAt(i + 1) == '*') {
                        hasBeginningCommentMark = true;
                        myStack.push(symbol);
                        i++;
                        continue;
                    }


                    // If we meet a closing annotation symbol without
                    // encountering the opening annotation symbol, report an
                    // error.
                    if (symbol == '*' && line.charAt(i + 1) == '/') {
                        noCorrespondingOpeningSymbol("*/", lineNumber);
                        return;
                    }

                    // If we meet an openiin quotation mark, ignore all the
                    // later characters until we meet a closing quotation mark
                    if (symbol == '"') {
                        hasBeginningQuotationMark = true;
                        myStack.push(symbol);
                    }

                    // Push all the other opening symbols
                    if (symbol == '(' || symbol == '[' || symbol == '{') {
                        myStack.push(symbol);
                        continue;
                    }

                    // Pop the opening symbols if meet a closing symbol.
                    // Otherwise (no closing symbol) there is an error.
                    if (symbol == ')') {
                        if (myStack.isEmpty()) {
                            noCorrespondingOpeningSymbol(Character.toString
                                    (symbol), lineNumber);
                            return;
                        }

                        if (myStack.top() != '(') {
                            misMatch(Character.toString(symbol), lineNumber);
                            return;
                        }
                        myStack.pop();
                        continue;
                    }

                    if (symbol == ']') {
                        if (myStack.isEmpty()) {
                            noCorrespondingOpeningSymbol(Character.toString
                                    (symbol), lineNumber);
                            return;
                        }

                        if (myStack.top() != '[') {
                            misMatch(Character.toString(symbol), lineNumber);
                            return;
                        }

                        myStack.pop();
                        continue;
                    }

                    if (symbol == '}') {
                        if (myStack.isEmpty()) {
                            noCorrespondingOpeningSymbol(Character.toString
                                    (symbol), lineNumber);
                            return;
                        }

                        if (myStack.top() != '{') {
                            misMatch(Character.toString(symbol), lineNumber);
                            return;
                        }
                        myStack.pop();
                    }
                }
            }

            // If the stack is not empty, there is no corresponding closing
            // symbol and there is an error.
            if (!myStack.isEmpty()) {
                while (!myStack.isEmpty()) {
                    if (myStack.top() == '/') {
                        noCorrespondingClosingSymbol("/*");
                        return;
                    }
                    if(myStack.top() == '"'){
                        noCorrespondingClosingSymbol(Character.toString
                                (myStack.pop()));
                        return;
                    }
                    noCorrespondingClosingSymbol(Character.toString
                            (myStack.pop()));
                }
                return;
            }

            noSymbolBalancingError();

        } finally {
            bufferedReader.close();
        }

    }

    private static void misMatch(String symbol, int lineNumber) {
        System.out.println("Unbalanced! Symbol " + symbol + " is mismatched " +
                "at line " + lineNumber);
    }

    private static void noCorrespondingOpeningSymbol(String symbol, int
            lineNumber) {
        System.out.println("Unbalanced! Symbol " + symbol + " has no " +
                "corresponding opening symbol at line " + lineNumber);
    }

    private static void noCorrespondingClosingSymbol(String symbol) {
        System.out.println("Unbalanced! Symbol " + symbol + " has no " +
                "corresponding closing symbol.");
    }

    private static void noSymbolBalancingError() {
        System.out.println("The file has no symbol balancing error.");
    }

    public static void main(String[] args) {
        checkBalance(args[0]);

    }
}
