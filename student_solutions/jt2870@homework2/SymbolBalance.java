import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
public class SymbolBalance {
	private MyStack<Character> test;
	private char c,ignore;
	private char rem,top;
	private char cb;
	private String readLine;
	private int checksuccess;
	public SymbolBalance(){
		test=new MyStack<>();
		c='0';rem='0';top='0';cb='0';
		readLine=null;
		test.push('0');
		ignore='9';
		checksuccess=0;
	}
	public void Searchitem(File file){
		try{
			LineNumberReader check=new LineNumberReader(new FileReader(file));
			while((readLine=check.readLine())!=null){
            	for(int i=0;i<readLine.length();i++){
            		c=readLine.charAt(i);
            		//this if is to check whether the symbol will contained in /*..*/
            		if(c=='/'&&i<readLine.length()-1&&test.top()!='"'){
            			if(readLine.charAt(i+1)=='*'&&test.top()!=ignore){
            				test.push(ignore);}
            		}
            		if(c=='*'&&i<readLine.length()-1&&test.top()!='"'){
            			if(readLine.charAt(i+1)=='/'){
            				test.pop();}
            		}
            		//this if is to check whether we met symbol ".."
            		if(c=='"'&&test.top()!=ignore){
            			if(test.top()=='"'){
            				test.pop();}
            			else{
            				test.push(c);}
            		}
            			//add to the stack when character occur
            		if(test.top()!=ignore&&test.top()!='"'){
            			if(checksuccess==1)
            				break;
            			if(c=='('||c=='{'||c=='['){
            				test.push(c);
            				top=test.top();
            			}
            			if(c==')'||c=='}'||c==']'){
            				//this if for the situation that ),},] appears as first character or last character
            				if(test.top()=='0'){
            					System.out.println("Unbalanced! Symbol"+c+" is mismatched");
            					checksuccess=1;
            					break;
            				}
            				//eliminate the top of the stack and check whether it matches
            				rem=test.pop();
            				top=test.top();
            				//cb is used to check whether its balanced
            				if(c==')')
            					cb='(';
            				if(c=='}')
            					cb='{';
            				if(c==']')
            					cb='[';
            				if(cb!=rem){
            					System.out.println("Unbalanced! Symbol "+c+" is mismatched");
            					checksuccess=1;
            				}
            			}
            		}
            	}
			}
        	if(test.top()!='0'&&checksuccess==0){
        		System.out.println("Unbalanced! Symbol "+test.top()+" is mismatched");
        		checksuccess=1;
            }
        	if(checksuccess==0){
        		System.out.println("Success!");}
            check.close();
		}
		catch (IOException e) {  
			System.out.println("Please try again with correct input file name");
		}
	}
	public static void main(String[] args){
		SymbolBalance test=new SymbolBalance();
		File infile=new File(args[0]);
		test.Searchitem(infile);
	}
}
