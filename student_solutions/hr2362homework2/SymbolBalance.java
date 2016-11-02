/* Kelly Ryu
 * hr2362
 * SymbolBalance.java - prints first symbol balance error 
 * detected in java file
 */

import java.io.BufferedReader;
import java.io.FileReader;

public class SymbolBalance {

    public static void main(String[] args){
        
        String fileName = args[0];
        try{
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String nextLine = br.readLine();
            String entire = "";
            while (nextLine != null){
                entire += nextLine + " /n";
                nextLine = br.readLine();
            }
            
            // create character array from file
            char[] charArr = entire.toCharArray();
            br.close();
            
            // call method on array
            System.out.println(check(charArr));
        }
        
        catch(Exception e){
            System.out.println("Problem finding " + fileName);
            System.out.println(e);
        }
    }
    
    // method returns String specifying type of mismatch
    public static String check(char[] charList){
        
        //create Character stack to store bracket characters
        MyStack<Character> stack = new MyStack<Character>();
        
        for (int i = 0; i < charList.length; i++){
            
            // when opening bracket is found
            if(charList[i] == '(' || charList[i] == '{' || charList[i] == '['){
                stack.push(charList[i]);
            }
            
            // when " is found, skip all characters in that line until " is
            // found again
            else if (charList[i] == '"'){ 
                if (i < charList.length-1){
                    i++;
                    while (i< charList.length && charList[i] != '"' &&
                           !(charList[i] == 'n' && charList[i-1] == '/')){
                        i++;
                    }
                    if (i == charList.length){
                        return ("Missing \" ");
                    }
                    else if (charList[i] == 'n' && charList[i-1] == '/'){
                        return ("Missing \" ");
                    }
                }
                else{
                    return ("Missing \" ");
                }
            }
            
            //when /* is found, skip all characters in file until */ is found
            else if (charList[i] == '/'){
                if (i < charList.length-1 && charList[i+1] == '*'){
                    i++;
                    while (i< charList.length && !(charList[i] == '/' && 	
			   charList[i-1] == '*')){
                        i++;
                    }
                    if (i == charList.length){
                        return "Missing /*";
                    }
                }
            }
            
            // situations where ending bracket is found
            else if(charList[i] == ')'){
                if (stack.empty()){
                    return ("Mismatch of )");
                }
                else if (stack.peek() == '('){
                    stack.pop();
                }
                else{
                    return ("Mismatch of )");
                }
            }

            else if(charList[i] == ']'){
                if (stack.empty()){
                    return ("Mismatch of ]");
                }
                else if (stack.peek() == '['){
                    stack.pop();
                }
                else{
                    return ("Mismatch of ]");
                }
            }

            else if(charList[i] == '}'){
                if (stack.empty()){
                    return ("Mismatch of }");
                }
                else if (stack.peek() == '{'){
                    stack.pop();
                }
                else{
                    return ("Mismatch of }");
                }
            }
            
            // situation when */ is found
            else if(charList[i] == '*'){
                if (i < charList.length-1){
                    i++;
                    if (charList[i] == '/'){
                        return ("Missing /*");
                    }
                }
            }
        }
        
        // after moving through entire list of characters
        if (stack.empty()){
            return ("No Problem");
        }
        else{
            return ("Mismatch of " + stack.peek());
        }
    }
}

