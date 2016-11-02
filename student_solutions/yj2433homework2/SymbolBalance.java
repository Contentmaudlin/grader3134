/* Yuncheng Jiang
 *  UNI:yj2433
 *Find whether the symbol is balanced in the Test file
 */
import java.io.*;
import java.util.*;
public class SymbolBalance{
    public static <AnyType extends MyStack<AnyType>> String balanceCheck(String line){
        Stack<Character> stack=new Stack<Character>();//create the new stack
        Stack<Character> stackquotation=new Stack<Character>();//create the new stack to test quatation mark
        String output="Balanced";
        boolean whetherInComment=false;
    outerloop:
	       for(int i=0;i<line.length();i++){
               if(line.charAt(i)=='/' && line.charAt(i+1)=='*'){//ignore everything after /*
                   whetherInComment=true;
                   i++;
               }
               
               if(whetherInComment==true){
                   for(int j=i;j<line.length();j++){
                       if(line.charAt(j)=='*' && line.charAt(j+1)=='/'){//stop ignore everything after */
                           whetherInComment=false;
                           i=j+2;
                           break;
                       }
                       if(j==line.length()-1){
                           return "Unbalanced! Symbol */ is unmatched1!";//if can't find the closing comment, return error
                       }
                   }
               }
               
               if(whetherInComment==false){
                   
                   if(line.charAt(i)=='"'){//check quotation mark
                       if(stackquotation.isEmpty()){
                           stackquotation.push('"');
                           for(int j=i+1;j<line.length();j++){//ingore everything after the first "
                               if(line.charAt(j)=='"'){
                                   stackquotation.pop();
                                   i=j;
                                   break;
                               }
                               if(line.charAt(j)=='\n'){
                                   return "unblance! \" ";
                               }
                           }
                       }else if(stackquotation.isEmpty()==false){//if stackquotation is not empty, pop the "
                           stackquotation.pop();
                       }
                   }
                   
                   
                   if(line.charAt(i)=='{'){//when meet {, push {
                       stack.push('{');
                   } else if(line.charAt(i)=='('){//when meet (, push (
                       stack.push('(');
                   } else if(line.charAt(i)=='['){//when meet [, push [
                       stack.push('[');
                   } else if(line.charAt(i)=='/' && line.charAt(i+1)=='*'){//when meet /*, pop
                       stack.push('/');
                       stack.push('*');
                   } else if(line.charAt(i)=='}'){
                       if(stack.isEmpty()){
                           output= "Unbalanced! Symbol } is unmatched";
                           break outerloop;
                       }else if(stack.pop()!='{'){
                           output= "Unbalanced! Symbol  }  is unmatched";
                           break outerloop;
                       }
                   } else if(line.charAt(i)==')'){
                       if(stack.isEmpty()==true){
                           output= "Unbalanced! Symbol ) is unmatched";
                           break outerloop;
                       }else if(stack.pop()!='('){
                           output=  "Unbalanced! Symbol ) is unmatched";
                           //stack.pop();
                           break outerloop;
                       }
                   }else if(line.charAt(i)==']'){
                       if(stack.isEmpty()){
                           output= "Unbalanced! Symbol [ is unmatched";
                           break outerloop;
                       }
                       else if(stack.pop()!='['){
                           output= "Unbalanced! Symbol ] is unmatched";
                           //stack.pop();
                           break outerloop;
                       }
                   }else if(line.charAt(i)=='*' && line.charAt(i+1)=='/'){
                       if(stack.isEmpty()){
                           output="Unbalanced! Symbol */ is unmatched";
                           break;
                       }else if(stack.pop()!='*'){
                           output="Unbalanced! Symbol */ is unmatched";
                           break outerloop;
                       }else{
                           stack.pop();
                       }
                   }
                   
               }
               
               
               
               
               
           }
        
        
        if(stack.isEmpty()==false && output=="Balanced"){
            output=" Unbalanced! Symbol " + Character.toString(stack.pop())+" is unmatched 88";
        }
        
        if(stackquotation.isEmpty()==false&& output=="Balanced"){
            output="\" not balanced";
        }
        
        return output;
    }
    public static String readFile(String fileName) throws IOException {//read the input file and convert it to string
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            
            while (line != null) {
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }
            return sb.toString();
        }
        finally {
            br.close();
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader filename = new BufferedReader(new FileReader(args[0]));
        String file="";
        try {
            file=readFile(args[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }
        balanceCheck(file);
        System.out.println(balanceCheck(file));
        
    }
}