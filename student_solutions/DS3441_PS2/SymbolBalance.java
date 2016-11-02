import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//*****************************
//Class SymbolBalance  
//
//
//Name: Dengyuan Shi 
//UNI: DS3441
//This class checks if the file
//contains unbalanced symbols .
//*****************************

public class SymbolBalance {


	public static void main(String[] args) throws IOException{
		String line=null; 
		String fileName=null;
		String ls=System.getProperty("line5.separator");
		StringBuilder sb = new StringBuilder();
		fileName=args[0];
	
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		 
		while((line = br.readLine()) != null){
			sb.append(line); 
			sb.append(ls);
		}
		br.close();
		String content = sb.toString();
		checkError(content);
		
	}

	
	private static void checkError(String a){
		MyStack<Character> results = new MyStack<Character>(); 
		String content = a; 
		boolean error = false; //checks if error has occurred and printed. 
		
		//loops through the string
		//if error found, exits
		outerloop:
		for(int i=0;i<content.length();i++){
			char ch = content.charAt(i);
			boolean isString=false;//checks for literal literal strings. 
			boolean isComment=false;//checks for literal comment blocks. 
			String error1 = "Unbalanced! Symbol " + ch + " needs an opening symbol.";
			String error2 = "Unbalanced! Symbol " + ch + " is mismatched.";
			String error3 = "Unbalanced! Symbol " + ch + "needs to be closed";
			if(!isString&&!isComment){
			if(ch=='{' || ch=='[' || ch=='('){
				results.push(ch); 
			}
			else if(ch=='}'){
				if(results.isEmpty()){
					System.out.println(error1);
					error = true;
					break;
				}
				else if(results.pop()!= '{'){
					System.out.println(error2);
					error = true;
					break;
				}
			}
			else if(ch==']'){
				if(results.isEmpty()){
					System.out.println(error1);
					error = true;
					break;
				}
				else if(results.pop()!= '['){
					System.out.println(error2);
					error = true;
					break;
				}
			}       
			else if(ch==')'){
				if(results.isEmpty()){
					System.out.println(error1);
					error = true;
					break;
				}
				else if(results.pop()!= '('){
					System.out.println(error2);
					error = true;
					break;
				}
			}
			}
			if(ch=='\"'){
				boolean action=false;//checks for when there is one quote in one line. 
				for(int j = i+1; j<content.length();j++){
					if(content.charAt(j)=='\"'){
						action=true;
						isString=true; 
						if(content.length()-j>1){
							i=j; 
							isString=false;
							break;
						}
						else
							break outerloop; 
					}
					else if(content.charAt(j)=='\n'){
						action=true;
						System.out.println(error3);
						error=true;
						break outerloop;
					}
					
				}
				if(!action){
					System.out.println(error3);
					error=true;
					break;
				}
			}
			
			if(ch=='/'&&i<content.length()-1){
				if(content.charAt(i+1)=='*'){
					boolean action=false;
					for(int j = i+2; j<content.length();j++){
						if(content.charAt(j)=='*'){
						if(content.charAt(j+1)=='/'){
							isComment=true; 
							action=true;
							if(content.length()-j>2){
								i=j; 
								isComment=false;
								break;
							}
							else
								break outerloop; 
						}
						
						}
					}
					if(!action){
							System.out.println("Unbalanced!Comment block needs to be closed.");
							error=true; 
							break;
						
					}
				}
			}
			
			if(ch=='*'&&i<content.length()-1){
				if(content.charAt(i+1)=='/'){
					System.out.println("Unbalanced! Symbol */ needs an opening symbol.");
					error=true;
					break;
				}
			}
		}
		//after it loops through the string
			if(results.isEmpty()&&!error)
				System.out.println("Balanced!");
			else if(!results.isEmpty()&&!error)
				System.out.println("Unbalanced! Symbol " + results.pop() + " needs to be closed.");
		}
	}
	
	
