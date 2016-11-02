/* Tianwu Wang
 * tw2576
 * SymbolBalance.java
 * check if symbols in a file is balanced
 * and ignore the unbalanced symbols in
 * comments and string literals
 */

import java.io.*;
import java.util.*;

public class SymbolBalance {
	
	public static void main(String[] args) throws FileNotFoundException{
			
		String st = "";
		Scanner scan = new Scanner(new File (args[0]));     //read files using scanner
		scan.useDelimiter("\r\n");                          //read line breakers
		while(scan.hasNext()){
			st += scan.next();	
		}	
		System.out.println(symbolBalance(st));
	}
	
	public static <AnyType extends MyStack<AnyType>> String symbolBalance(String s){
		Stack<Character> myStack = new Stack<Character>();
		Boolean notInCom = true;           //not in comments is set to be true at first 
		Boolean notInQuo = true;           //not in quotes is set to be true at first 
		int i = 0;
		
		for(i = 0; i < s.length(); i++){
			char ch = s.charAt(i);
			if(s.charAt(i) == '/' && s.charAt(i+1) == '*') {    //try to find the start of the comment
				if(i+2 == s.length() ){                         //check if the test only contents first half of the comment  
					return "Unbalanced! Symbol /* is mismatched."; 
				}else{	
					notInCom = false;                           //set no in comment to be false
				}
			}
			
			if(notInCom == false){
				for (int j = i; j < s.length(); j++){ 								// try to find the closing of the comment
					if(s.charAt(j) == '*' && s.charAt(j+1) == '/' && notInCom == false){
						i = j + 1;													//update i if find the closing 
						notInCom = true;											//update that not in comment is now true
						break;
					}
					
					if ((j == s.length() - 1) && notInCom == false){    //if cannot find the closing until the end 
						return "Unbalanced! Symbol /* is mismatched.";  // return mismatched 
					} 
			    }
			}
			
			if(s.charAt(i) == '"') {                       //try to find the start of the comment
				if(i+1 == s.length() ){                    //check if the test only contents first half of "
					return "Unbalanced! Symbol \" is mismatched."; 
				}else{	
					notInQuo = false;
				}
			}
	
			if(notInQuo == false){
				for (int l = i + 1; l < s.length(); l++){ 		

					if(s.charAt(l) == '\n' && l != s.length()-1){ //check if we meet a line break before we meet another " mark
						notInQuo = true;						  
						return "Unbalanced! Symbol \" is mismatched."; //means there are " marks not in the same line 
					}
					
					if(s.charAt(l) == '"'){             		//try to find the second " mark
						i = l + 1;
						notInQuo = true;						//find it and update that we are no in quotation
						break;
					}
					
					if ((l == s.length() - 1) && notInQuo == false){  //if we go through the file and cannot find the match of "
						return "Unbalanced! Symbol \" is mismatched."; //then return mismatch
					} 
			    }
			}
			
			if(notInCom == true && notInQuo == true){  				   //if we are not in quotations and comments
				
				if (ch == '{' || ch == '[' || ch == '(' || ch == '<'){ //check the first half of the braces
					myStack.push(ch);								   //and pop them into the stack
					
				}else if (ch == '}'){								   //check if {} is matched 
					if(myStack.isEmpty()){	
						return "Unbalanced! Symbol } is mismatched.1";
					}if(myStack.pop() != '{'){
						return "Unbalanced! Symbol } is mismatched.2";
					}
				
				}else if (ch == ']'){								   //check if [] is matched
					if(myStack.isEmpty()){
						return "Unbalanced! Symbol ] is mismatched.";
					}if(myStack.pop() != '['){
						return "Unbalanced! Symbol ] is mismatched.";
					}
				}else if (ch == ')'){								   //check if () is matched
					if(myStack.isEmpty()){
						return "Unbalanced! Symbol ) is mismatched.1";
					}
					if(myStack.pop() != '('){
						return "Unbalanced! Symbol ) is mismatched.2";
					}
				}else if (ch == '>'){								   //check if <> is matched
					if(myStack.isEmpty()){
						return "Unbalanced! Symbol > is mismatched.";
					}if(myStack.pop() != '<'){
						return "Unbalanced! Symbol > is mismatched.";
					}	
				}
			}
		}
		
		if(myStack.isEmpty()==false){                              //if there are still symbols in the stack at the end
			return "Unbalanced! Symbol "+ myStack.pop()+" is mismatched.3"; // then pop that symbol and report mismatch
		} else {
		return "Balanced!";
		}
	}
}