//*************************************************************
//SymbolBalance.java
//
//by Sophie Ishak
//*************************************************************

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class SymbolBalance {
	
	public static void readFile(String f) throws IOException {
		FileInputStream inputStream = new FileInputStream(f);
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		MyStack<Character> myStack = new MyStack<Character>();
		
		boolean check = true;
		int val;
		String problem = "";
		
		while((val = bufferedReader.read()) != -1 ){
			char c = (char) val;
			char p = ' ';
			char c2 = ' ';
			// push opening special characters in: { }'s, ( )'s, [ ]'s, " "'s, and /* */'s
			if (c=='{' || c=='(' || c=='[' ) {
				myStack.push(c);
			}		
			
			else if (c=='}' ){
				p = myStack.pop();				
				if (p!='{') {
					problem = "}";
					check=false;
					break;
				}
			}
			else if (c==')' ) {
				p = myStack.pop();
				if (p!='(') {
					problem = ")";
					check=false;
					break;
				}
			}
			else if (c==']') {
				p = myStack.pop();
				if (p!='[') {
					problem = "]";
					check=false;
					break;
				}
			}
			
			//checking for quotes
			else if (c=='"') {
				boolean quotes = false;
				while ((val = bufferedReader.read()) != -1){
					c2 = (char) val;
					
					if (c2=='"'){
						quotes=true;
					} 
				
					if (quotes==false) {
						problem="\"";
						check=false;
						break;
					}
				}				
			}
			
			//checking for s
			else if (c=='/') {
				if((val = bufferedReader.read()) != -1){
					c2 = (char) val;
					if ((c2=='*')) {	
						outer:
						while ((val = bufferedReader.read()) != -1){
							c = (char) val;
							if (c=='*'){
								val = bufferedReader.read();
								c2 = (char) val;
								if (c2=='/'){
									break outer;
								} 	
							}
						}					
					}
				}
			}	
		}
		
		if (check==false) {
			System.out.println("Unbalanced! Symbol "+problem+" is mismatched.");
			inputStream.close();
			inputStreamReader.close();
			bufferedReader.close();
			return;
		} else if (check==true && myStack.isEmpty()){ //stack is empty and symbols balanced
			System.out.println("Success!");	
			inputStream.close();
			inputStreamReader.close();
			bufferedReader.close();
		} else { //in the case that the stack ISN'T empty even if check is true.
			System.out.println("Unbalanced! Symbol "+myStack.pop()+" is mismatched.");	
			inputStream.close();
			inputStreamReader.close();
			bufferedReader.close();
		}
	}
	
	public static void main(String args[]) throws IOException{
		if (args.length>0){ //i.e. if the command-line argument is not empty
			readFile(args[0]);	
		}
	}	
}
