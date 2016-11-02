import java.io.BufferedReader;
import java.io.CharArrayReader;
import java.io.File;
import java.io.FileReader;

/**
 * Created by johnzhang on 9/28/16.
 *
 * Solves Symbol Balance Problem
 *
 * Implemented using a stack that only accepts Integers
 * IMPORTANT: Comparison will always be between characters in file and elements of left_mark or right_mark
 * OR between integer references themselves.
 * i.e.: 0 corresponds to both ( and ), 1 corresponds to both { and } , etc.
 *
 */
public class SymbolBalance {
    private static  myStack<Integer> inner_stack = new myStack<>();
    static private File infile;
    static final private String[] left_mark     = {"(", "{", "[", "\"" , "/"};
    static final private String[] right_mark    = {")", "}", "]", "\"", "*"};

    public static void main(String[] args) {
        if (args.length > 0) {
            infile = new File(args[0]);
        } else {
            System.exit(1);
        }
        search:
        try {

            System.out.println("Starting...");

            BufferedReader inputStream;
            String line;
            int linenumber = 0;
            boolean commented =  false;

            inputStream = new BufferedReader(new FileReader(infile));

            while ((line = inputStream.readLine()) != null){

                linenumber++;

                for (int i = 0; i < line.length(); i++) {

                    String c = Character.toString(line.charAt(i));

                    int k = 0;
                    int j = 0;
                    // If the line is still commented from an earlier comment or string mark,
                    // check to see if the current c corresponds to the appropriate mark.
                    // Otherwise ignore the current c and continue the search
                    if (commented && c.equals(right_mark[inner_stack.peek()])){
                        if (inner_stack.peek() == 3) { // 3 -> "
                            inner_stack.pop();
                            commented = false;
                        }
                        else if (inner_stack.peek() == 4 && i+1 != line.length()) { // 4-> *
                            i +=1;
                            if (Character.toString(line.charAt(i)).equals("/")){
                                // only pop if the following symbol completes the comment marker
                                inner_stack.pop();
                                commented = false;
                            }
                        }

                    }
                    // If the line is not commented, compare to see if c first matches any left markers
                    else if (!commented){
                        for (; j < 5; j++) {
                            if (c.equals(left_mark[j])) {
                                inner_stack.push(j);
                                break;
                            }
                        }
                        // j=3 -> c = "
                        if (j ==3){
                            commented = true;
                        }
                        // j=4 -> c = /
                        else if (j == 4){
                            i += 1;
                            if (Character.toString(line.charAt(i)).equals("*")){
                                // only comment if the symbol completes the comment marker
                                commented = true;
                            }
                            else {
                                inner_stack.pop();
                            }
                        }


                        /* Only proceed if character c does not equal any of the left marks
                         *
                         */
                        if (j == 5) {
                            for (; k < 5; k++){
                                if (c.equals(right_mark[k])){
                                    // System.out.println("Found " + c + " at line: " + linenumber );
                                    if (inner_stack.size() == 0){
                                        // Extra closing symbol error - only occurs if stack is empty and algorithm finds a closing symbol
                                        System.err.println("Error: Missing forward " + left_mark[k] + " for " + c + " at line: " + linenumber);
                                        break search;
                                    }
                                    else if (k != inner_stack.peek()){
                                        // mismatch error - k (integer) references the corresponding left_mark. If the current k mismatches with the integer
                                        // at the top of the stack, there is a mismatch between the opening and closing symbols
                                        System.err.println("Error: Mismatch with " + left_mark[inner_stack.peek()] + " and " + c + " at line: " + linenumber);
                                        inner_stack.pop();
                                        break search;

                                    }
                                    else {
                                        // k == inner_stack.peek()
                                        inner_stack.pop();
                                        break;

                                    }


                                }
                            }
                        }

                    }

                }
                // if reached the end of line without finding a closing "
                if (inner_stack.size() != 0 && left_mark[inner_stack.peek()].equals("\"")){
                    System.err.println("Error: no closing \" was found on line: " + linenumber);
                    break search;
                }

            }
            if (inner_stack.size() != 0){
                System.err.println("Error: Missing reverse " + right_mark[inner_stack.peek()] + " for " + left_mark[inner_stack.peek()] + " at " + linenumber);
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("Finished");


    }


}
