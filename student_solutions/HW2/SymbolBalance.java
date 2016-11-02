import java.io.*;
import java.util.Scanner;

public class SymbolBalance{
    public static char isMatching(String str){
        if (str.isEmpty())
            return 'y';
        MyStack<Character> stack = new MyStack<Character>();
        for (int i = 0; i < str.length(); i++){
            char current = str.charAt(i);
            if (current == '{' || current == '(' || current == '[' || current == '<'){
                stack.push(current);
            }
            if (current == '}' || current == ')' || current == ']' || current == '>'){
                if (stack.isEmpty())
                    return current;
                char last = stack.peek();
                if (current == '}' && last == '{' || current == ')' && last == '(' || current == ']' && last == '[' || current == '>' && last == '<')
                    stack.pop();
                else 
                    return current;
            }
            if (current == '"'){
                char last = stack.peek();
                if (last == '"'){
                    stack.pop();
                }
                else{
                    stack.push(current);
                }
            }
        }
        if (stack.isEmpty()){
            return 'y';
        }else{
            return stack.peek();
        }
    }


    public static String removeBlockComments(String in){
        StringBuilder result = new StringBuilder();
        try (StringReader sr = new StringReader(in)) {
            boolean inBlockComment = false;
            boolean out = true;
            int prev = sr.read();
            int cur;
            for(cur = sr.read(); cur != -1; cur = sr.read()) {
                if(inBlockComment) {
                    if (prev == '*' && cur == '/') {
                        inBlockComment = false;
                        out = false;
                    }
                }else {
                    if (prev == '/' && cur == '*') {
                        int next = sr.read();
                        if (next != '*') {
                            inBlockComment = true;
                        }
                    }else if (out){
                        result.append((char)prev);
                    } else {
                        out = true;
                    }
                }
                prev = cur;
            }
            if (prev != -1 && out)
                result.append((char)prev);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result.toString();
    }

    public static void main(String[] args) throws FileNotFoundException{
        String input = "";
        if(args.length == 0){
            System.out.println("Usage:"); 
            System.out.println("java SymbolBalance \"filename\"");
            System.exit(0);
        }
        input = new Scanner(new File(args[0])).useDelimiter("\\A").next();
        input = removeBlockComments(input);
        System.out.println(input);
        System.out.println("\n");
        char symb = isMatching(input);
        if (symb == 'y'){
            System.out.println("Balanced!");
        }else{
            System.out.println("Unbalanced!  Symbol " + symb + " is mismatched.");
        }
    }
}