import java.awt.geom.Path2D;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SymbolBalance {

    static List<String> symbolOpen = new ArrayList<String>() {
        {
            add("{");
            add("[");
            add("(");
            add("\"");
            add("/*");
        }
    };

    static List<String> symbolClose = new ArrayList<String>() {
        {
            add("}");
            add("]");
            add(")");
            add("\"");
            add("*/");
        }
    };

    public static void main(String[] args) {
        // TODO code application logic here
        List<String> file = new ArrayList<String>();
        FileInputStream inputStream;
        try {
		//Take in args[0] as file name to test
            inputStream = new FileInputStream(args[0]);
            Reader reader = new InputStreamReader(inputStream);
            BufferedReader buffer = new BufferedReader(reader);
            int index;
            String previous = "";
            boolean literalString = false;
            boolean literalComment = false;
            while ((index = buffer.read()) != -1) {
                String c = String.valueOf((char) index);
                // Add {[( )]} to the arrayList
                if (!literalString && !literalComment
                        && !c.equals("/") && !c.equals("*") && !c.equals("\"")) {
                    if (symbolOpen.contains(c)
                            || symbolClose.contains(c)) {
                        file.add(String.valueOf(c));
                    }
                }
                //handle literal in Comment BLOCK
                if ((c.equals("/") && previous.equals("*")) && !literalString ) {
                    literalComment = false;
                    file.add(String.valueOf(previous) + String.valueOf(c));
                }
                if ((c.equals("*") && previous.equals("/")) && !literalString && !literalComment) {
                    literalComment = true;
                    file.add(previous + c);
                }
                //Handle litterl String between ""
                if (c.equals("\"") && !literalComment) {
                    if (literalString) {
                        literalString = false;
                    } else {
                        literalString = true;
                    }
                    file.add(c);
                }
                previous = c;

            }
        } catch (Exception e) {
        }
        
        //Check balance now
        CheckBalance(file);
    }

    public static void CheckBalance(List file) {
        MyStack<String> stack = new MyStack<String>();
        for (int i = 0; i < file.size(); i++) {
            String c = String.valueOf(file.get(i));
            if (symbolOpen.contains(c) && !c.equals("\"")) { // If it is opening symbol ---> Add to stack
                stack.pushOn(c);
            } else if (c.equals("\"") && stack.search("\"") == -1) {// Make sure there is none " before add to stack
                stack.pushOn(c);
            } else if (!stack.isEmpty()) { // If it is closing symbol --> handle below
                int checkRight = -1;
                int checkLeft = -1;
                String top = String.valueOf(stack.popOut());
                if (symbolClose.indexOf(c) != symbolOpen.indexOf(top)) { // if we dont have correct pair of symbol
                    //Check if there is opening symbol previously on the stack
                    checkLeft = stack.search(String.valueOf(symbolOpen.get(symbolClose.indexOf(c))));
                    
                    //Check if there is closing symbol towards the end of the file
                    checkRight = checkExistence(file, i + 1, symbolClose.get(symbolOpen.indexOf(top)));
                  
                    if (checkLeft == -1) {
                        System.out.println("Unbalanced! Missing openning symbol for " + c );
                        return;
                    }
                    if (checkRight == -1) {
                        System.out.println("Unbalanced! Missing closing symbol for " + top);
                        return;
                    }
                    System.out.println("Mismatch " + top + c);
                    return;
                }
            } else {
                // No opening symbol in Stack to match
                System.out.println("Unbalanced! Missing openning symbol for " + c);
                return;
            }

        }
        if (stack.isEmpty()) {
            System.out.println("balance!");
        } else { 
            // Symbol not matched 
            System.out.println("Unbalanced! Missing closing symbol for " + stack.popOut());
        }

    }

    public static int checkExistence(List file, int beginIndex, String ch) {
        int count = 1;
        for (int i = beginIndex; i < file.size(); i++) {
            if (file.get(i).equals(symbolOpen.get(symbolClose.indexOf(ch)))) {
                count++;
            }
            if (file.get(i).equals(ch)) {
                count--;
                if (count == 0) {
                    return 1;
                }
            }
        }
        return -1;
    }

}