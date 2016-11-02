
// ***********************************
// Homework 2, SymbolBalance.java
// Written by Jennifer Bi
// jb3495
// ***********************************



import java.util.Scanner;
import java.io.FileReader;
import java.io.*;

public class SymbolBalance{

    public static void main (String[] args) throws FileNotFoundException, IOException{

    // prompts user for file to be read
          System.out.println("Please enter the name of the file you would like "
           + "to be checked.");
          Scanner input = new Scanner(System.in);

    FileReader inFile = new FileReader(input.next());

    // creates the stack to be filled 
    MyStack stack = new MyStack();

    boolean match = true;
    boolean comment = false;
    boolean quote = false;
    char c = '0';
    char d = '0'; // an extra char to hold * and / 

    // perform the check when the file is not empty and we find no mismatches
    while(inFile.ready() && match){
        c = (char) inFile.read();
       
        // push opening symbols to stack
        if ((c == '{' || c == '[' || c == '(') && !quote && !comment){
            stack.push(c);
            //stack.printStack();
        }

        // enter comment mode; pause checking
        else if (c == '/' && (char) inFile.read() == '*' && !quote && !comment) {
            comment = true;
        }

        // exit comment mode; resume checking
        else if (c == '*' && (char) inFile.read() == '/' && comment && !quote){
            comment = false;
        }

        // enter quote mode; pause checking
        else if (c == '\"' && !quote && !comment) {
            quote = true;
        }

        // exit quote mode; resume checking
        else if (c == '\"' && quote && !comment) {
            quote = false;
        }


        // recognize closing symbols, match with opening symbols in stack

        else if (c == '}' && !quote && !comment){
            if (stack.top()==0){
                match = false;
            }
            else {
            c = '{';
            d = (char) stack.pop();
            //stack.printStack();
            match = (d == c);
            }
        }
        else if (c == ']' && !quote && !comment){
            if (stack.top()==0){
                match = false;
            }

            c = '[';
            d = (char) stack.pop();
            //stack.printStack();
            match = (d == c);
            
        }
        else if (c == ')' && !quote && !comment){
            if (stack.top()==0){
                match = false;
            }

            c = '(';
            d = (char) stack.pop();
            //stack.printStack();
            match = (d == c);
    
        }
        
    }

    inFile.close();

    // additional errors
    if (stack.top() != 0){
        match = false;
    }
    if (quote){
        match = false;
        c = '\"';
    }
    if (comment){
        match = false;
        c = '*';
    }

    // report error
    if (!match){
        System.out.println("You have a mismatch of " + c);
    }
    }


}
        
    
	




