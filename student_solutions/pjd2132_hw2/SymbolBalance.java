/* Name : Peter Drake
 * UNI : pjd2132
 *  
 *  SymbolBalance.java - Uses stacks to see if inputed file properly 
 *  balances various symbols
 */
import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class SymbolBalance {
    public static void main(String[] args) throws IOException{
    //Main method that checks if symbols are balanced in the first
    //file denoted by the first string in String[] args
        
        //Stack to be used to check if balanced. Input to checkBalance method 
        MyStack<Character> stack = new MyStack<Character>(); 
        
        Scanner sc = null;   //Initializes sc so it can be closed in finally
        stack.push('S');     //Ensures stack isn't empty to prevent errors

        if (args.length != 0){
            try{
                
                File file = new File(args[0]);
                sc = new Scanner(file);
                
                boolean isUnbalanced = false;  //Stores if file is unbalanced
                
                //Loop goes through each line of file, checking for any
                //imbalances. If an imbalance is found, the loop ends
                //since !isUnbalanced becomes false.
                while (sc.hasNextLine() && !isUnbalanced){
                    String line = sc.nextLine();
                    isUnbalanced = checkBalance(line, stack);
                }
                
                //All that should be left in the stack is 'S'. If no errors
                //were found, but the top of the stack is not 'S', that means
                //a symbol opening did not get closed. This checks for that.
                if (!isUnbalanced && stack.top() != 'S'){
                    char c = stack.pop();
                    System.out.println("Unbalanced! " + c + " is mismatched");
                    isUnbalanced = true;
                }
                
                //If file balances all symbols
                if (!isUnbalanced){
                    System.out.println("Congrats! All symbols are balanced.");
                }
            }
            
            //Exception catching
            catch (IOException e){
                System.err.println("IOException: " + e.getMessage());
            }
            catch (Exception e){
                System.out.println("Something went wrong :(" + e.getMessage());
            }
            
            finally{
                if (sc != null){
                    sc.close();     //Closes the input file
                }
            }
        }
        //If no file name provided in String[] args
        else{
            System.out.println("You did not enter a file name as an argument");
        }
    }
    
    public static boolean checkBalance(String line, MyStack<Character> stack){
    //Helper method that takes one line of the file as input and the
    //stack being used. Checks to see if (),{}, [], "", /* */ are balanced
    //using a stack as discussed in class. Returns false if no error found 
    //for that line and true if there is an error in that line. 
    //Also prints the error.
        
        //Go through each character of the line and run through conditionals
        for (int i = 0; i < line.length(); i++){
            
            //Only check conditionals if not currently in quote or comment
            if (stack.top() != '"' && stack.top() != '*'){
                if(line.charAt(i) == '"'){
                    stack.push('"');
                }
                else if(line.charAt(i) == '{'){
                    stack.push('{');
                }
                else if(line.charAt(i) == '('){
                    stack.push('(');
                }
                else if(line.charAt(i) == '['){
                    stack.push('[');
                }
                else if(line.charAt(i) == '/'){
                    i = i + 1;  //Check the next character to see if comment
                    if(line.length() > i && line.charAt(i) == '*'){
                        stack.push('*');
                    }
                    else{           //If not part of comment
                        i = i - 1;  //Decrement i so character isn't skipped 
                    }
                }
                else if(line.charAt(i) == '}'){
                    if(stack.pop() != '{'){
                        System.out.println("Unbalanced! } is mismatched");
                        return true;
                    }
                }
                else if(line.charAt(i) == ')'){
                    if(stack.pop() != '('){
                        System.out.println("Unbalanced! ) is mismatched");
                        return true;
                    }
                }
                else if(line.charAt(i) == ']'){
                    if(stack.pop() != '['){
                        System.out.println("Unbalanced! ] is mismatched");
                        return true;
                    }
                }                
            } 
            else if(stack.top() == '"'){
                if (line.charAt(i) == '"'){
                    if(stack.pop() != '"'){
                        System.out.println("Unbalanced! \" is mismatched");
                        return true;
                    }
                }
            }
            else if(stack.top() == '*'){
                if (line.charAt(i) == '*'){
                    i = i + 1;
                    if(line.length() > i && line.charAt(i) == '/'){
                        if(stack.pop() != '*'){
                            System.out.println("Unbalanced! /* is mismatched");
                            return true;
                        }
                    }
                }
            }
        }
        if (stack.top() == '"'){   //Line cannot end while still in quote
            System.out.println("Unbalanced! \" not matched properly");
            return true;
        }
        return false;   //If no errors in this line, return false
    }    
}