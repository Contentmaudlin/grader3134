import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class SymbolBalance {
public static void main(String[] args) throws FileNotFoundException, IOException{
String fileData = ReadDocument(args[0]);
	System.out.println("Input file:\n"+fileData);	

MyStack<Character> previousChar = new MyStack<Character>();			



for (int i = 0; i < fileData.length(); i++){
    char current_char = fileData.charAt(i);        
    switch(current_char){
    case'{':
    	{previousChar.push(current_char);
    	}
    break;
    case'}':
    	{	if(previousChar.isEmpty()){System.out.println("There is a closing symbol } withought an opening symbol");}
    		if(previousChar.peek()!='{'){
    			System.out.println("There is a mismatch between opening symbol "+ previousChar.pop() + " and closing symbol }");}
    			else previousChar.pop();
    	}
    break;
    case'(':
    	{previousChar.push(current_char);
    	}
    break;
    case')':
    	{	if(previousChar.isEmpty()){System.out.println("There is a closing symbol ) withought an opening symbol");}
    		if(previousChar.peek()!='('){
    			System.out.println("There is a mismatch between opening symbol "+ previousChar.pop() + " and closing symbol )");}
    		else previousChar.pop();
    	}
    break;        
    case'[':
    	{previousChar.push(current_char);
    	}
	break;
    case']':
    	{	
    		if(previousChar.isEmpty()){System.out.println("There is a closing symbol ] withought an opening symbol");}
    		if(previousChar.peek()!='['){
    			System.out.println("There is a mismatch between opening symbol "+ previousChar.pop() + " and closing symbol ]");}
    		else previousChar.pop();
    	}
	break;
    case'/':
    {if (fileData.charAt(i+1)=='*'){
    	previousChar.push(current_char);
    do{i++;}while(!((fileData.charAt(i-1)=='*')&&(fileData.charAt(i)=='/'))&&i < fileData.length());
    if((fileData.charAt(i-1)=='*')&&(fileData.charAt(i)=='/'))
    	previousChar.pop();
    }}
	break;
    case'*':
    {if (fileData.charAt(i+1)=='/'){System.out.println("There is a closing symbol */ withought an opening symbol");}}
    break;
    case'"':{
    	previousChar.push(current_char);
    	do{i++;}while((!(fileData.charAt(i)=='"'))&&i < fileData.length());
    	if((fileData.charAt(i)=='"'))
        	previousChar.pop();
    }break;

    }
}

while (!previousChar.isEmpty()){
	System.out.println("Unbalanced! Symbol " + previousChar.pop()+ " is opened withought the corresponding closing symbol" );
	
	
}




// single " are encountered Always as Opening symbols.
}

//=========================================== ReadDocuments() ================================================
/** We read the documents from the file and we put them in the ArrayList documents.
* @param fileName The filename that contains the Documents.
* @param documents An ArrayList that contains in each cell the Document that included in the fileName.*/    
//============================================================================================================
static public String ReadDocument(String fileName) throws FileNotFoundException, IOException{
BufferedReader br = new BufferedReader(new FileReader(fileName));
String line;
String allData="";
while((line =br.readLine()) != null){
	allData=allData.concat(line+"\n");
}br.close();    
//System.out.println(discarded_documents+ " documents are discarded.");
return allData;
}//====================================== End of Class ReadDocuments() ======================================


}
