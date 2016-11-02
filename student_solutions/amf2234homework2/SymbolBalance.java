// **************************************************
// SymbolBalance.java
// October 10, 2016
// Written by Aaron Friedman --> amf2234
//
// takes a command line file input and tests if its
// {},[],(),"", and /**/ symbols are paired correctly
// **************************************************
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.ArrayIndexOutOfBoundsException;
import java.util.Scanner;
import java.lang.Character;

public class SymbolBalance {

    public static MyStack<Character> check(MyStack<Character> stack, char c) {
        //if the stack is empty or the symbol is not in a quote/comment
        if ((stack.isEmpty()) || ((stack.peek().equals('"') == false)&&(stack.peek().equals('/') == false))) {
            if ((c=='{') || (c=='(') || (c=='[') || (c=='"'))
                stack.push(new Character(c));
            else if (c=='}') {
                if (stack.isEmpty()) {
                    stack.push(new Character('i')); //flag file as imbalanced
                    System.out.println("Unbalanced! Symbol } missing opening {");
                }
                else if ((stack.pop().equals('{') == false)) {
                    stack.push(new Character('i')); //flag file as imbalanced
                    System.out.println("Unbalanced! Symbol mismatch with }");
                }
            }
            else if (c==')') {
                if (stack.isEmpty()) {
                    stack.push(new Character('i')); //flag file as imbalanced
                    System.out.println("Unbalanced! Symbol ) missing opening (");
                }
                else if ((stack.pop().equals('(') == false)) {
                    stack.push(new Character('i')); //flag file as imbalanced
                    System.out.println("Unbalanced! Symbol mismatch with )");
                }
            }
            else if (c==']') {
                if (stack.isEmpty()) {
                    stack.push(new Character('i')); //flag file as imbalanced
                    System.out.println("Unbalanced! Symbol ] missing opening [");
                }
                else if ((stack.pop().equals('[') == false)) {
                    stack.push(new Character('i')); //flag file as imbalanced
                    System.out.println("Unbalanced! Symbol mismatch with ]");
                }
            }
        }
        
        //if the " is ending a String 
        else if ((stack.peek().equals('/') == false) && (c == '"')) {
            stack.pop();
        }

        return stack;
    }
    
    public static MyStack<Character> checkAsterisk(MyStack<Character> stack, String line, int i) {
        //if the * is empty or the symbol is not in a quote/comment
        if ((stack.isEmpty()) || ((stack.peek().equals('"') == false) && (stack.peek().equals('/') == false))) {
            //if the * appears as the first or last charactrer
            if ((i == 0) || (i==line.length()-1)) {
                stack.push(new Character('i')); //flag file as imbalanced
                System.out.println("Unbalanced! Symbol * is mismatched");
            }
            //if the * is in the sequence /*
            else if (line.charAt(i-1) == '/')
                stack.push(new Character('/'));
        }
        //if the * is ending a comment
        else if (stack.peek().equals('"') == false) {
            //if the * is in the sequence */
            if ((i != line.length()-1) && (line.charAt(i+1) == '/')) {
                if (stack.pop().equals('/') == false) {
                    stack.push(new Character('i')); //flag file as imbalanced
                    System.out.println("Unbalanced! Symbol /* is mismatched");
                }
            }
        }
        
        return stack;
    }

    public static final void main(String[] args) {
        try {
            MyStack<Character> stack = new MyStack<Character>();
            File file = new File(args[0]);
            Scanner in = new Scanner(file);
            while (in.hasNextLine()) {
                String line = in.nextLine();
                //read the characters in the line
                for (int i=0; i < line.length(); i++) {
                    char c = line.charAt(i);
                    //if an imbalance hasn't already been flagged
                    if ((stack.isEmpty()) || (stack.peek().equals('i') == false)) {
                        if (c == '*')
                            stack = checkAsterisk(stack, line, i);
                        else
                            stack = check(stack, c);
                    }
                }
            }
            if (stack.isEmpty())
                System.out.println("Fully Balanced");
            //if an imbalance hasn't already been flagged
            else if (stack.peek().equals('i') == false)
                if (stack.peek() == '/')
                    System.out.println("Unbalanced! Symbol " + stack.pop() + "* is mismatched");
                else
                    System.out.println("Unbalanced! Symbol " + stack.pop() + " is mismatched");
        }

        catch(FileNotFoundException e) {
            System.out.println(args[0] + " not found");
        }
        catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Must input a file name");
        }
    }
}