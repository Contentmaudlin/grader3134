/* Kendall Dabaghi
KD 2602

 */

import java.io.*;

public class SymbolBalance {

    private static void analyzeFile(char[] text, MyStack<Character> openingSymbols,
                            MyStack<Character> closingSymbols) {

        // Function takes an array of characters from the file to analyze, and
        // two stacks of opening and closing symbols to make the program extensible.
        // For instance - could easily add '' or other characters to the stack
        // and have them compared in addition to [, (, {


        // If there is no text, return case 4 (file empty or something went wrong in read)
        if(text == null || text.length == 0) {
            outputResults(4, ' ', ' ', 0);
        }

        // booleans used to track if inside a comment or quote block, since they take higher
        // precedence than normal closing/opening symbols
        boolean insideComment = false;
        boolean insideQuote = false;

        // outputtedResults used to track if have reached an error or end of file and sent
        // results already to be output to prevent continued iterating over file after error
        boolean outputtedResults = false;
        
        // index tracks the current character being examined
        int index = 0;

        // symbolComparison used to track the results of a function that compares the 
        // opening and closing symbol stacks to look for mismatch
        int symbolComparison;

        // lastChar stores the most recent character on the stack
        Character lastChar;

        // symbolStack tracks the symbols that the iterator comes across while looking through the 
        // file.  When it sees a new one it pops the previous one to compare
        MyStack<Character> symbolStack = new MyStack<>();

        // Iterate over the text until the index reaches the end
        while(index < text.length) {

            // If inside a comment, then keep iterating across the comment block until you reach
            // the end marked by */.  If you reach the end of the file before you terminate the 
            // comment block, then return error 5 (file ended with open comment).
            if(insideComment) {
                while(index < text.length) {
                    if(text[index] == '*' && index+1 < text.length && text[index+1] == '/') {
                        insideComment=false;
                        symbolStack.pop();
                        symbolStack.pop();
                        index+=2;
                        break;
                    } else {
                        index++;
                    }
                }
                if(index == text.length) {
                    outputResults(5, ' ', ' ', text.length);
                    outputtedResults = true;
                    break;
                }

            } else if(insideQuote) {

                // If inside a quote block, keep iterating across it until you find the 
                // matching quote.  Must use two different ASCII character values as
                // there is a standard double quote as well as a closing double quote
                while(index < text.length) {
                    if(text[index] == 34 || text[index] == 8221) {
                        insideQuote = false;
                        lastChar = symbolStack.pop();
                        index++;
                        break;
                    } else {
                        index++;
                    }
                }
            } else if(text[index] == '/') {
                // If you find a '/', check that it is not the start of a comment block.
                // If it is, set insideComment to true, increment index to the part inside
                // the comment block and go to top of loop (unless you've reached the end
                // of the file in which case return error 5).  

                // If it's not the start of a comment block, increment index
                if(index+1 < text.length && text[index+1] == '*') {
                    symbolStack.push(text[index]);
                    symbolStack.push(text[index+1]);
                    insideComment=true;
                    index+=2;
                    if(index == text.length) {
                        outputResults(5, ' ', ' ', text.length);
                        outputtedResults = true;
                        break;
                    }
                } else {
                    index++;
                }
            } else if(text[index] == 34 || text[index] == 8220) {
                // Check if beginning of a quote field using standard double quote ASCII
                // value as well as ASCII value for opening double quotes
                insideQuote = true;
                symbolStack.push(text[index]);
                index++;
            } else if(text[index] == '{' || text[index] == '(' || text[index] == '[') {
                // If it's an opening symbol, push it to the stack of symbols to compare
                symbolStack.push(text[index]);
                index++;
            } else if(text[index] == '}' || text[index] == ')' || text[index] == ']') {

                // If it's a closing symbol, pop the most recent symbol off the stack
                // and ue the compareSymbols function to compare them
                
                lastChar = symbolStack.pop();

                // If there is no most recent symbol, then you have a closing symbol without
                // an opening symbol and return error case 2.
                if(lastChar == null) {
                    outputResults(2, ' ', text[index], index);
                    outputtedResults = true;
                    break;
                } else {

                    // Otherwise, pass in the most recent symbol popped, the current one you're 
                    // comparing, and the stacks of opening and closing symbols to compare on
                    symbolComparison = compareSymbols(openingSymbols, closingSymbols, lastChar, text[index]);
                    if (symbolComparison > 0) {

                        // If the symbols are not the same, output the results with the corresponding error
                        // code and set outputtedResults to true so program knows reached an error.
                        // This is necessary for comparisons that take place at the end of the file.
                        // Normally reaching the end of the file would be a sign of success, but in this
                        // case you've reached the end of the file and found an error on the very last character
                        // so you must make sure the program doesn't take reaching the end of the file as success.
                        outputResults(symbolComparison, lastChar, text[index], index);
                        outputtedResults = true;
                        break;
                    } else {

                        // If the symbols are the same, continue iterating over the file
                        index++;
                        if (index == text.length) {
                            break;
                        }
                    }
                }
            } else {
                // If the character at this index is not any of the above, go to the next one
                index++;
            }
        }
        
        // If reach end of file and haven't sent any error codes on last character, then...
        if(index == text.length && !outputtedResults) {

            // If there are no remaining symbols on the stack, success!
            if(symbolStack.empty()) {
                outputResults(0, ' ', ' ', text.length);
            } else {
                // If there are remaining symbols on the stack, then return error code
                // 1 for open symbols left
                outputResults(1, symbolStack.pop(), text[index-1], index);
            }
        }

    }


    private static int compareSymbols(MyStack<Character> opening, MyStack<Character> closing,
                               Character last, Character curr) {
        
        // Returns 0 if matched successfully, otherwise returns error code
        
        // Uses two stacks of opening and closing characters that are arranged so the indices
        // of the pair of opening and closing symbols is the same in each.
        // For example, curly brackets are first, square brackets second, and parentheses third
        // in each stack.  This allows you to compare if the opening and closing symbols match
        // by looking at the indices of where they appear in the opening/closing stacks.

        // I designed it this way to make it easily extensible to add additional symbols to compare.

        int indexOpen = opening.search(last);
        int indexClose = closing.search(curr);
        if(indexOpen == -1 || last == null) {
            return 2;
        } else if(indexOpen != indexClose) {
            return 3;
        } else {
            return 0;
        }
        
    }

    private static void outputResults(int result, char prev, char curr, int index) {

        // Takes an error code (result), the last character popped from the symbol stack,
        // the current character you're looking at, and the index of the error
        // to provide maximum specificity
        String message;
        switch(result) {
            case 0: message = "Success!";
                    break;
            case 1: message = "Error - open symbols remaining.  Last open: " + prev;
                    break;
            case 2: message = "Error - closing symbol with no opening: '" + curr + "' at index " + index + ".";
                    break;
            case 3: message = "Error - symbol mismatch.  Last open: '" + prev + "', received '" + curr + "' at index " +
                index + ".";
                    break;
            case 4: message = "Error - file empty or something went wrong during analysis";
                    break;
            case 5: message = "Error - file ended with open comment";
                    break;
            default: message = "Error - something went wrong during file analysis";
                    break;
        }
        System.out.println(message);

    }

    private static File accessFile(String filename) throws NullPointerException {
        
        // Nest file access in try/catch to handle errors

        try {
            File file1 = new File(filename);
            return file1;
        }
        catch (NullPointerException e) {
            System.err.println(e);
        }

        return null;
    }

    private static char[] readFile(File file1) throws FileNotFoundException, IOException {
            
            // Test that file not null and exists or throw not found
            if(file1 == null) {
                System.out.println("No file specified");
                return null;
            }
            if(!file1.exists()) {
                throw new FileNotFoundException("File not found");
            }
            if(!file1.isFile()) {
                throw new IllegalArgumentException("Not a valid file");
            }

            // Read file in to a stringbuilder, then return the full text as
            // an array of characters to iterate over one by one

            StringBuilder sb = new StringBuilder();
            String line;
            BufferedReader reader = null;

            try {
                reader = new BufferedReader(new FileReader(file1));
                while((line = reader.readLine()) != null) {
                    sb.append(line);
                }
            }
            catch (IOException e) {
                System.err.println("Error: " + e);
            }
            finally {
                try {
                    if(reader != null) {
                        reader.close();
                    }
                } catch(IOException e) {
                    System.err.println("Error: " + e);
                }
            }

            char[] fileText = new char[sb.length()];
            sb.getChars(0, fileText.length, fileText, 0);

            return fileText;

    }

    public static void main (String[] args) throws IOException {

        // Define the dictionary of opening and closing symbols to compare, then
        // read the file, analyze the symbols, and output the results.

        MyStack<Character> openingSymbols = new MyStack<>();
        openingSymbols.push('{');
        openingSymbols.push('[');
        openingSymbols.push('(');

        MyStack<Character> closingSymbols = new MyStack<>();
        closingSymbols.push('}');
        closingSymbols.push(']');
        closingSymbols.push(')');

        analyzeFile(readFile(accessFile(args[0])), openingSymbols, closingSymbols);

    }
}
