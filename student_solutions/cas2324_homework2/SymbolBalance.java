import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Reads in a file and checks for symbol imbalances of {}, (), [], / * * /, and ""
 */

public class SymbolBalance {
    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
            String line;
            MyStack<Character> openStack = new MyStack<>();

            // Create two strings of our opening and closing symbols; order needs to be the same as we check for the
            // matching closing symbol via index in the string.
            String openSymbols = "{([";
            String closeSymbols = "})]";

            // Booleans to keep track of whether we're still looking for either an ending comment symbol `*/` or a
            // double quote to end a string.
            boolean needQuote = false;
            boolean needCommentClose = false;

            // Read in our file line by line.
            while ((line = br.readLine()) != null) {
                // Create an array of characters for each line.
                char[] charArray = line.toCharArray();
                // And store the length of the array (the length of the line) so we know when we've reached the end.
                int lineLength = charArray.length;

                // Go through the line, character by character and check for our symbols.
                for (int i = 0; i < lineLength; i++) {
                    Character c = charArray[i];

                    if (c == '"' && !needCommentClose) {
                        if (needQuote) {
                            needQuote = false;
                            continue;
                        } else {
                            needQuote = true;
                            continue;
                        }
                    } else if (openSymbols.indexOf(c) >= 0 && !needQuote && !needCommentClose) {
                            // If we find an opening symbol we care about, push it to the stack.
                            openStack.push(c);
                    } else if (closeSymbols.indexOf(c) >= 0 && !needQuote && !needCommentClose) {
                        // Otherwise, if we find a closing symbol, pop off the most recent opening symbol from
                        // the stack.  If there's nothing to pop, we have an imbalance.  If it just doesn't
                        // match, we have a mismatch.
                        try {
                            Character lastOpen = openStack.pop();
                            if (openSymbols.indexOf(lastOpen) != closeSymbols.indexOf(c)) {
                                throw new RuntimeException("Unbalanced Error Type 3! " + lastOpen + " and " +
                                        c + " are mismatched!");
                            }
                        } catch (java.util.NoSuchElementException e) {
                            throw new RuntimeException("Unbalanced Error Type 2! " + c +
                                    " closed before opening!");
                        }
                    } else {
                        if (i == lineLength - 1) {
                            continue;
                        } else {
                            Character c2 = charArray[i + 1];
                            String s = c.toString() + c2.toString();
                            if (s.equals("/*")) {
                                needCommentClose = true;
                                i++;
                            } else if (s.equals("*/")) {
                                if (!needCommentClose) {
                                    throw new RuntimeException("Unbalanced Error Type 2! '*/' not preceded by '/*'");
                                } else {
                                    needCommentClose = false;
                                    i++;
                                }
                            }
                        }
                    }
                }

                // If we're still looking for a quote and we've completed the line, throw an error.
                if (needQuote) {
                    throw new RuntimeException("Unbalanced Error Type 1! String has no closing quote.");
                }
            }
            // Close the reader.
            br.close();

            // Check to make sure there's nothing left in the stack; if there it is means we didn't close something and
            // we should error out!
            try {
                Character leftOver = openStack.pop();
                throw new RuntimeException("Unbalanced Error Type 1! " + leftOver + " has no closing symbol.");
            } catch (java.util.NoSuchElementException e) {
                // Do nothing, we're good!
            }

            // Also check that all comments have been closed, if not, throw an error.
            if (needCommentClose) {
                throw new RuntimeException("Unbalanced Error Type 1! '/*' has no closing symbol.");
            }

            // If we've made it here, the file is good.
            System.out.println("Success! File looks good.");

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
