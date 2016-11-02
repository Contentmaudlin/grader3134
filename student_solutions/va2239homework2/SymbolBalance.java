import java.io.*;

/**
 * Name: Victor Au
 * UNI: va2239
 * COMS W3134
 * 
 * Homework 2
 * Programming #1: Symbol Balancing
 * 
 * This takes a Java file as a command line argument. It reads in the file
 *   and checks to make sure that all {, (, [, ", and /* are balanced!
 * 
 * Error cases:
 * 1. One or more opening symbols missing corresponding closing symbols.
 * 2. Closing symbol without corresponding opening symbol.
 * 3. Mismatch between closing and opening symbol.
 */
public class SymbolBalance {
    private MyStack<Character> stack = new MyStack<>();
    private boolean stringLiteral = false;
    private boolean blockComment = false;
    private char previous = ' ';

    /**
     * Constructor.
     */
    public SymbolBalance() {}
    
    /**
     * Creates an instance of SymbolBalance.
     * Creates a File object for args[0] and runs the method
     *   readFile() on file. That method is where the symbol
     *   checking actually happens!
     */
    public static void main(String[] args) {
        SymbolBalance sb = new SymbolBalance();
        
        if (args.length == 0) {
            System.out.println("Please enter a file name.");
            return;
        }
        
        try {
            File file = new File(args[0]);
            sb.readFile(file);
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
        catch (IOException e) {
            System.out.println("IO Exception!");
        }

    }
    
    /**
     * (1) Creates a BufferedReader based off of the file.
     * (2) Reads the file line by line, traversing through each character.
     * (3) It records the current char as c and the previous char as well.
     * (4) If it isn't in a block comment, checks for start/end of a string.
     * (5) If it isn't in a string, checks for start/end of block comment.
     * (6) If it's in neither a block comment nor string, checks for {, (, [.
     * (7) It then closes the reader and checks if there's an unfinished
     *   block comment OR if the stack is empty. If there's a char remaining,
     *   checkRestOfStack() will print that there's a missing char.
     * (8) At the end, if a mistake hasn't been found yet, it prints a
     *   message saying that there isn't a symbol imbalance.
     */
    private void readFile(File file) throws IOException {
        FileReader fileReader = new FileReader(file);
        BufferedReader br = new BufferedReader(fileReader);
        String line = null;
        
        while ((line = br.readLine()) != null) {
            for (int i = 0; i < line.length(); i++) {
                if (i == 0) {
                    previous = ' ';     // resets the previous char
                } else {
                    previous = line.charAt(i - 1);  // previous char
                }
                char c = line.charAt(i);    // current char
                
                if (blockComment == false) {
                    stringCheck(c);         // checks for string literal
                }
                
                if (stringLiteral == false) {
                    commentCheck(c);        // checks for block comment
                }
                
                if (stringLiteral == false && blockComment == false) {
                    symbolCheck(c);     // can't be in string or comment!
                                        // checks for {}, (), and []
                }
            }
        }
        
        br.close();             // closes the reader.
        checkRestOfStack();     // checks if stack has anything in it.
        System.out.println("Looks like there's no imbalance!");
    }
    
    /**
     * This is where the symbol-checking for " takes place.
     * If c is a ", it peeks at the top. If it's ", it pops the stack to
     *   signify the end of the string literal. If peek doesn't reveal ", it
     *   pushes c to the stack to signify the start of a string literal.
     * It also uses the boolean stringLiteral to keep track of the status.
     */
    private void stringCheck(char c) {
        if (c == '"') {
            if (stack.peek() == '"') {
                stack.pop();
                stringLiteral = false;   // end of string literal
            } else {
                stack.push(c);
                stringLiteral = true;    // start of string literal
            }
        }
    }
    
    /**
     * This is where the symbol-checking for block comments takes place.
     * If previous is a / and c is a * (meaning the start of a block comment),
     *   AND peek doesn't show * (meaning that we're not currently in a
     *   block comment), then this will push * to the stack (to signify
     *   that we're now in a block comment).
     * If previous is a * and c is a / (meaning the end of a block comment),
     *   then this will check if blockComment is true, it means we were in a
     *   block comment and are now ending it. It'll pop the stack.
     * If blockComment is false, then there's a missing /* (because we should
     *   be in a block comment!).
     * This uses the boolean blockComment to keep track of the status.
     */
    private void commentCheck(char c) {
        if (previous == '/' && c == '*' && blockComment == false) {
            stack.push(c);
            blockComment = true;        // start of block comment
        }
        
        if (previous == '*' && c == '/') {
            if (blockComment == true) {
                stack.pop();
                blockComment = false;    // end of block comment
            } else {    // if there's a */, we should be in a block comment!
                System.out.println("Unbalanced! Missing /*.");
                System.exit(0);
            }
        }
    }
    
    /**
     * This is where the symbol-checking for {, (, and [ takes place.
     * This method is split into three parts.
     * (1) If c is }, ), or [, this pushes c to the stack.
     * (2) If c is }, ), or ], this checks if the stack is empty.
     *   If it is empty, this prints the corresponding missing opening symbol.
     *   If it's not empty, this pops the stack and checks if the popped symbol
     *   (an opening symbol) pairs with c (the closing symbol). If it doesn't
     *   pair, then it prints out a message saying the mismatch.
     */
    private void symbolCheck(char c) {
        if (c == '{' || c == '(' || c == '[') {
            stack.push(c);
            return;
        }
        
        if (c == '}') {
            if (stack.isEmpty()) {
                System.out.println("Unbalanced! Missing {.");
                System.exit(0);;
            }
            char popped = stack.pop();
            if (popped != '{') {
                System.out.println("Unbalanced! Left " + popped 
                + " is mismatched with right }.");
                System.exit(0);
            }
        } else if (c == ')') {
            if (stack.isEmpty()) {
                System.out.println("Unbalanced! Missing (.");
                System.exit(0);;
            }
            char popped = stack.pop();
            if (popped != '(') {
                System.out.println("Unbalanced! Left " + popped 
                + " is mismatched with right ).");
                System.exit(0);;
            }
        } else if (c == ']') {
            if (stack.isEmpty()) {
                System.out.println("Unbalanced! Missing [.");
                System.exit(0);;
            }
            char popped = stack.pop();
            if (popped != '[') {
                System.out.println("Unbalanced! Left " + popped 
                + " is mismatched with right ].");
                System.exit(0);;
            }
        }
    }
    
    /**
     * After doing most of the symbol checking in symbolCheck(),
     *   readFile() calls this method to see if there are any
     *   opening symbols remaining in the stack. (It basically
     *   prints if any closing symbols are missing.)
     */
    private void checkRestOfStack() {
        if (stack.size() > 0) {
            if (stack.peek() == '"') {
                System.out.println("Unbalanced! Missing \".");
                System.exit(0);
            } else if (stack.peek() == '*') {
                System.out.println("Unbalanced! Missing */.");
                System.exit(0);
            } else if (stack.peek() == '{') {
                System.out.println("Unbalanced! Missing }.");
                System.exit(0);
            } else if (stack.peek() == '(') {
                System.out.println("Unbalanced! Missing ).");
                System.exit(0);
            } else {
                System.out.println("Unbalanced! Missing ]");
                System.exit(0);
            }
        }
    }
}
