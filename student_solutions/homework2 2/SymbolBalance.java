//Homework2 - Problem1
//Kehan Lu - kl2858

import java.io.*;


public class SymbolBalance {
	
	private static String s="";
	private static int f;
	private static int p;
	
	public String isSymbolBalance(String a) {
		MyStack<Character> stack=new MyStack<>();
		a=" "+a+" ";
		f=0; p=0;
		for (int i=1; i<a.length()-1; i++) {
			if (a.charAt(i)=='(' || a.charAt(i)=='[' || a.charAt(i)=='{') {
				stack.push(a.charAt(i));
			}
			else if (p==0 && a.charAt(i)=='"'){
				stack.push(a.charAt(i));
				p=1;
			}

			else if (f==0 && a.charAt(i)=='/' && a.charAt(i+1)=='*'){
				stack.push(a.charAt(i));
				f=1;
			}	
			else if (a.charAt(i)=='/' && a.charAt(i-1)=='*') {
				f=0;
				while ((stack.peek()!='/')&&(!stack.empty()))
					stack.pop();
				if (!stack.empty()) stack.pop(); else return ("More closing symbol "+a.charAt(i));
			}
			else if ((f==0) && (a.charAt(i)==')' || a.charAt(i)==']' || a.charAt(i)=='}') && stack.empty())
				return ("More closing symbol "+a.charAt(i));
			else if ((p==1)&&(a.charAt(i)=='"')&&(stack.empty()))
				return ("More closing symbol "+a.charAt(i));
			else if ((f==0) && ((a.charAt(i)==')'&& stack.peek()!='(') || (a.charAt(i)==']'&&stack.peek()!='[') || (a.charAt(i)=='}'&&stack.peek()!='{'))) {
				return ("Unbalance! Symbol "+a.charAt(i)+" is mismatched.");
			}
			else if ((p==1)&&(a.charAt(i)=='"')&&(stack.peek()!='"'))
				return ("Unbalance! Symbol "+a.charAt(i)+" is mismatched.");
			else if ((f==0) && ((a.charAt(i)==')'&& stack.peek()=='(') || (a.charAt(i)==']'&&stack.peek()=='[') || (a.charAt(i)=='}'&&stack.peek()=='{')))
				stack.pop();
			else if ((p==1)&&(a.charAt(i)=='"'&&stack.peek()=='"')){
				p=0;
				stack.pop();
			}
			
		}
		
		if (stack.empty())
			return ("Balance");
		else
			return("More opening symbol "+stack.peek());
		
	}
	
	public static void main(String[] args){
		// TODO Auto-generated method stub
		try{    
			BufferedReader br=new BufferedReader(new FileReader(args[0]));
			String line;
			
			while ((line=br.readLine())!=null){
				s=s+line;
			}
			s=s.replaceAll("[a-zA-Z]", "");
			s=s.replaceAll("[0-9]", "");
			br.close();
			System.out.println(new SymbolBalance().isSymbolBalance(s));
			
		}
		catch(FileNotFoundException e) {
			System.out.println("File not found!");
		}
		catch(IOException e) {
			System.out.println("IO Exception");
		}

	}
}
