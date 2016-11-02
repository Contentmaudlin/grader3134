/**
 * @author Zoe Gordin
 * zeg2103
 *
 * This class aims to analyze a text file, and report if the symbols denotating Strings, comments, and brackets, i.e. ([{
 * are balanced. If there are imbalances within Strings or comments, it will ignore them.
 */
import java.io.*;
@SuppressWarnings("unchecked")//deals with unchecked casting when compiling on the command line
public class SymbolBalance {
    private static String endOfFile = Integer.toHexString(127);//denotates the end of a file
    private static String endOfLine = Integer.toHexString(13);//denotates the end of a line
    private static String newText = "";//the file string without comments and Strings to be created by getBrackets
    public static void main(String args[]) {

        MyStack<String> theStack = new MyStack<String>();//stack holds open brackets while program searches for a close
        File file = new File(args[0]);//the file taken from the command line
        String fileText = "";//the text removed from the file as a String
        String line = "";//each line of the file
        final int INDEX = 0;//the index at which the methods will start operating on the file
        //try... catch deals with possible file related errors
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            //loop makes a single string, with indicators for end of line and file, that holds the file
            while ((line = br.readLine()) != null) {
                fileText += line;
                fileText += endOfLine;
            }
            fileText += endOfFile;
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("The file is not found");
        } catch (IOException e) {
            System.out.println("The input is not of the proper type");
        }
        //creates a new string that has removed all comments and Strings to be passed on to fix brackets
        //returns true if mismatched brackets should be searched for, otherwise it will print out a statement about
        //mismatched comments or Strings
        if(getBrackets(fileText, INDEX))
        {
            System.out.println(fixBrackets(newText, INDEX, theStack));
            //prints out if there are mismatched brackets
        }
    }

    /**
     * peekChar is looking for the 'next next' character, to say that peekChar goes beyond the current index
     * @param s the string to be evaluated
     * @param index the current index
     * @return the character after the character after the current index
     */
    public static String peekChar(String s, int index)
    {
        if(index<s.length())
        {
            return s.substring(index+1, index+2);
        }
        else
        {
            return endOfFile;
        }
    }

    /**
     * finds the character after the current index
     * @param s the string to be evaluated
     * @param index the current index
     * @return the character after the current index
     */
    public static String getNextChar(String s, int index)
    {
        if (index < (s.length()))
        {
            return s.substring(index, index + 1);
        }

        else {
            return endOfFile;
        }
    }
    //pass in argument that the function sets
    /**
     * returns either that a String or comment is mismatched, or a string that is the original file String
     * without any comments or Strings, only with other text and brackets to be evaluated
     * @param s the String to be evaluated (from the file)
     * @param strIndex the current index
     * @return string for fixBrackets or a statement about mismatched comment or String
     */
    public static boolean getBrackets(String s, int strIndex) {
        //evaluates the string until the end of the file is reached
        while(!(getNextChar(s, strIndex).equals(endOfFile))) {
            String next = getNextChar(s, strIndex);
            //if the next character is the beginning of a string, the end is searched for
            //if the end of a line or the file is reached, the string is mismatched
            if (next.equals("\"")) {
                strIndex++;
                while (strIndex<s.length()) {
                    next = getNextChar(s, strIndex);
                    if(next.equals("\""))
                    {
                        break;
                    }
                    else if (peekChar(s, strIndex).equals(endOfFile) || peekChar(s, strIndex).equals(endOfLine))
                    {
                        System.out.println("Unbalanced! \" is mismatched.");
                        return false;
                    }
                    strIndex++;

                }
            }
            //if the next 2 characters are /* the end of the comment is searched for
            //if the end of the file is reached, the comment is mismatched
            else if (next.equals("/") && peekChar(s, strIndex).equals("*")) {
                getNextChar(s, strIndex);
                strIndex++;
                next = getNextChar(s, strIndex);
                while (strIndex < s.length()) {

                    if (next.equals("*") && peekChar(s, strIndex).equals("/")) {
                        break;
                    }
                    else if (peekChar(s, strIndex).equals(endOfFile)) {
                        System.out.println("Unbalanced! /* is mismatched.");
                        return false;
                    }
                    strIndex++;
                }
            }
            else
            {
                newText += next;
            }
            strIndex++;
        }
        return true;
    }

    /**
     * evaluates all brackets in the file string, and determines if any are mismatched
     * @param s the string to be evaluated from getBrackets
     * @param strIndex the current index
     * @param stack the stack on which to push open brackets while searching for closed
     * @return which if any brackets are mismatched
     */
    public static String fixBrackets(String s, int strIndex, MyStack stack) {
        String popped = "";
        while(!(getNextChar(s, strIndex).equals(endOfFile)))
        {
            String next = getNextChar(s, strIndex);
            if (next.equals("{") || next.equals("[") || next.equals("("))
            {
                stack.push(next);
            }
            else if(next.equals("}")||next.equals("]")||next.equals(")"))
            {
                if(!stack.isEmpty())
                {
                    popped = (String)stack.pop();
                    if(next.equals("}")&&!(popped.equals("{")))
                    {
                       return "Unbalanced! " + next + " is mismatched";
                    }
                    else if(next.equals("]")&&!(popped.equals("[")))
                    {

                        return "Unbalanced! " + next + " is mismatched!";
                    }
                    else if(next.equals(")")&&!(popped.equals("(")))
                    {
                        return "Unbalanced! " + next + " is mismatched!";
                    }

                }
                else
                {
                    return "Unbalanced! " + next + " is mismatched!";
                }
            }

            strIndex++;
            getNextChar(s, strIndex);
        }
        if(!stack.isEmpty())
        {
            popped = (String) stack.pop();
            return "Unbalanced! " + popped + " is mismatched!";
        }
        return "All symbols are balanced!";
    }
}


