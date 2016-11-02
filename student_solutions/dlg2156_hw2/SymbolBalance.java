import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.*;

//argument should be a file name i.e. Test1.java
public class SymbolBalance {
		
		//stack to keep track of balance
		private static MyStack<Character> s = new MyStack<Character>();
		private static String words;
		private static char unbal = '0';
		
		
		//deals with checking if the close symbol had a matching open on the stack
		//char open input should be the coordinating open symbol to the close symbol
		private static void closeSymbol(char close, char open){
			//if there wasn't the open symbol then stack is empty, so break
			if (s.isEmpty() || s.top() != open){
				 unbal = close;
			 }
			
			else {
				s.pop();
			}
		}
		
		
		public static void main (String[] args) throws FileNotFoundException{
		
		//if file is found
			try{
				
				File file = new File(args[0]);
				Scanner scan = new Scanner(file);
				StringBuilder stringFile = new StringBuilder((int)file.length());
				while(scan.hasNextLine()){
					stringFile.append(scan.nextLine());
				}
				words = stringFile.toString();
				
				//keep track of whether chars are inside comments or quotes
				//if inside, then balancing is irrelevant
				boolean comment = false;
				boolean quote = false;
				
				//turn strings in file into char array
				char[] arr = words.toCharArray();
				//iterate through the chars
				for(int i = 0 ; i<arr.length; i++){
					if (!comment && !quote){
				
						//if open symbol
						if (arr[i]== '{' || arr[i]=='(' || arr[i]== '['){
							//push char onto stack
							s.push(arr[i]);
						}
	                    
						//if close )
						else if (arr[i]== ')'){
							closeSymbol(')', '(');
						}
						
						//if close ]
						else if (arr[i]== ']'){
							closeSymbol(']', '[');
						}
						
						//if close }
						else if (arr[i]== '}'){
							closeSymbol('}', '{');
						}
						
						//if any of these resulted in an imbalance, then go to end
						if (unbal != '0'){
							break;
						}
						
						//if /
						else if (arr[i]== '/'){
							
							//if nothing on stack, then clearly the start of comment, push
							 if(s.isEmpty()){
								 s.push(arr[i]);
								 comment = true;
							 }
							 //if the top is not a /, then push
							 else if(s.top() != '/'){
								 s.push(arr[i]);
								 comment = true;
							 }
							 //if the top is a /, end of comment so pop
							 else{
								 s.pop();
								 comment = false;
							 }
						}
						else {
							
						}
					}
					
					//if *
					else if ((arr[i]== '*') && !quote){
						//if you just had step 1 of begin comment, indicate we're in a comment
						//and push the * onto the stack
						 if(s.top() == '/'){
							 comment = true;
							 s.push(arr[i]);
						 }
						 //if the next char is the /, end of comment so exit comment mode and pop
						 else if((arr[i+1] == '/') && (s.top()=='*')){
					    	 comment = false;
					    	 s.pop();
					     }
						 //if the stack is empty, push * onto the stack, clearly the start
						 else if(s.isEmpty() && !comment){
							 s.push(arr[i]);
						 }
						 //if the top is not a *, not already in a started, then push it on the stack
						 else if(s.top() != '*' && !comment){
							 s.push(arr[i]);
						 }
						 //else do nothing
						 else{
						 }
					}
					
					
					//if "
					if ((arr[i] == '"') && !comment){
						 //if nothing on stack, begin the quote
						if(s.isEmpty()){
							 quote = true;
							 s.push(arr[i]);
						 }
						//not a quote within a quote, begin the quote
						 else if(s.top() != '\"'){
							 quote = true;
							 s.push(arr[i]);
						 }
						//if it's not those, end the quote
						 else{
							 quote = false;
							 s.pop();
						 }
					}
					//else do nothing
					else {
					}
				}
				
				
				
				//if unbal doesn't exist :)
				if (s.isEmpty() && unbal == '0') {	
					System.out.println("no symbol errors");
				}
				
				//if there is an unbal
				else if(unbal != '0'){
					System.out.println("unbalanced symbol: " + unbal);
				}
				//if there's something left on stack
				else{
					unbal = s.top();
					System.out.println("unbalanced symbol: " + unbal);
				}
				
					
			}
			// if file not found
			catch(FileNotFoundException e){
				System.out.println("File not found");	
			}
		}
}

