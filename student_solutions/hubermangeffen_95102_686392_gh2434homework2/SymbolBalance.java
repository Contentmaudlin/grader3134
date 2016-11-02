import java.io.*;

public class SymbolBalance {

	public static void SymbolBalanceChecker(BufferedReader x){
		//reads letters in the file
		//i need to update java to 1.8

		MyStack<Character> stackie = new MyStack<Character>();
		MyStack<Character> tempStackie = new MyStack<Character>();
		String line; //only declare and do not initialize to save first line
		boolean loneCloseSymbol = false; //used for special circumstance of lone close symbol
		boolean contains = false;
		try {
			while ((line=x.readLine()) != null){ //reading through the entire file until null
				char[] lineChars = line.toCharArray();
				for (int i = 0; i < lineChars.length; i++){
					//checking currentChar for a symbol
					char currentChar = lineChars[i];
					char nextChar;
					if (i < lineChars.length - 1){
						nextChar = lineChars[i+1];
					}
					else{
						nextChar = 0;
					}

					//checking for brackets, curly brackets, parentheses
					if (isOpenSymbol(currentChar)){
						stackie.push(currentChar);
					}
					if (isCloseSymbol(currentChar)){
							if(!stackie.isEmpty()
							&& !OpenCloseEqual(stackie.top(), currentChar)){
								tempStackie.push(stackie.top());
								stackie.pop();
								if (OpenCloseEqual(stackie.top(), currentChar)){
									contains = true;
									stackie.push(tempStackie.top());
									while ((line = x.readLine()) != null){
										line = x.readLine();
									}
								}
								else {
										stackie.push(tempStackie.top());
										stackie.push(currentChar);
										loneCloseSymbol = true;
							    	i = lineChars.length-1;
							    	while ((line = x.readLine()) != null){
							    		line = x.readLine();
							    	}
									}
							}

					  	if(stackie.isEmpty()){
					    	stackie.push(currentChar);
					    	//loneCloseSymbol = true;
					    	while ((line = x.readLine()) != null){
					    		line = x.readLine();
					    	}
							}
					    }

					//checking for comments
					if (i < lineChars.length - 1){
					if (isOpenComment(currentChar, nextChar)){
						//slash is an identifier in the stack
						//for the open quote
						stackie.push(currentChar);
						int m = i + 2; //skips the */ part of the array
						//iterate until we find a comment or reach the end of the line (array)
						int quoteIndex1 = CommentIterator(lineChars, m);
						//case: if comment closes at the end of the line
						if ((quoteIndex1 != -1) && isSlash(stackie.top())){
							stackie.pop();
							i = quoteIndex1;
						}
						//case: if comment continues to another line
						else if (quoteIndex1 == -1){
							boolean foundComment = false;
							while ((foundComment == false && ((line = x.readLine()) != null))){
								char[] lineCharsTemp = line.toCharArray();
								for (int z = 0; z < lineCharsTemp.length - 1; z++){
									if (isCloseComment(lineCharsTemp[z], lineCharsTemp[z+1])){
										stackie.pop();
										foundComment = true;
									}
								}
							}
						}

					}
					}
					//checking for brackets, curly brackets, parentheses
					if (isCloseSymbol(currentChar)
						&& stackie.isEmpty() == false
						&& OpenCloseEqual(stackie.top(), currentChar)){
						stackie.pop();
					}

					//checking for quotations
					if (isQuotations(currentChar)){
						stackie.push(currentChar);
						int y = i + 1;
						//iterate until we find a quotation or reach the end of the line (array)
						//what about lots of extra random triple quotes
						int quoteIndex = StringIterator(lineChars, y);
						if (quoteIndex != -1){
							stackie.pop();
							i = quoteIndex;
						}
						else{
							while ((line = x.readLine()) != null){
					    		line = x.readLine();}
						}
					}
				}
		}
	}
		catch (IOException e) {
			e.printStackTrace();
		}
		if (stackie.isEmpty()){
			System.out.println("Congratulations. Your file is balanced!");
		}
		else if (!stackie.isEmpty() || loneCloseSymbol){
			System.out.println("I am sorry. Your file is unbalanced.");
			System.out.println(createErrorMessage(stackie.top()));
		}
	}

	private static boolean isOpenSymbol(char x){
		//checks three possibilities for open symbols
		//not for quotations/comments
		if (x == '{' || x == '[' || x == '('){
			return true;
		}
		else{
			return false;
		}
	}

	private static boolean isCloseSymbol(char y){
		//checks three possibilities for close symbols
		//not for quotations/comments
		if (y == '}' || y == ']' || y == ')'){
			return true;}
		else{
			return false;}
	}

	private static boolean OpenCloseEqual(char openSymbol, char closeSymbol){
		//checks matching symbols
		//not for quotations or comments
		if (openSymbol == '{' && closeSymbol == '}'){
			return true;
		}

		else if (openSymbol == '(' && closeSymbol == ')'){
			return true;
		}

		else if (openSymbol == '[' && closeSymbol == ']'){
			return true;
		}

		else{
			return false;
		}
	}

	private static boolean isQuotations(char quote){

		if (quote == '"'){
			return true;
		}
		else{
			return false;
		}
	}

	private static boolean isOpenComment(char slash, char star){

		if (slash == '/' && star == '*'){
				return true;
			}
		else{
			return false;
		}
	}

	private static boolean isSlash(char slash){

		if (slash == '/'){
			return true;
		}
		else{
			return false;
		}
	}
	private static boolean isCloseComment(char star, char slash){

		if (star == '*' && slash == '/'){
				return true;
			}
		else{
				return false;
		}
	}

	private static int StringIterator(char[] charsInLine, int y){

		int x = y;
		while(x < charsInLine.length && isQuotations(charsInLine[x]) != true){
			x++;
		}
		if (x == charsInLine.length){
			return -1;
		}
		else{
			return x;
		}
	}

	private static int CommentIterator(char[] charsInLine, int y){

		int x = y;
		while ((isCloseComment(charsInLine[x], charsInLine[x+1]) != true) && x < charsInLine.length - 2){
			x++;
		}

		if (x >= charsInLine.length - 2 && (isCloseComment(charsInLine[x], charsInLine[x+1]) != true)){
			return -1;
		}
		else{
			return x;
		}
	}

	private static String createErrorMessage(char x){

		String message = "There is an error";
		if (isSlash(x)){
			message =  "You have an unmatched comment";
		}

		else if (isOpenSymbol(x)){
			if (x == '[')
				message = "You have an unmatched open bracket";
			else if (x == '{')
				message = "You have an unmatched open curly bracket";
			else if (x == '(')
				message = "You have an unmatched open parentheses";
		}

		else if (isCloseSymbol(x)){
			if (x == ']')
				message = "You have an unmatched close bracket";
			else if (x == '}')
				message = "You have an unmatched close curly bracket";
			else if (x == ')')
				message = "You have an unmatched close parentheses";
		}

		else if (isQuotations(x)){
			message = "You have an unmatched quotation";
		}

		return message;
	}
	public static void main(String[] args){
	//must input a file name
	try{
        BufferedReader in = new BufferedReader(new FileReader(args[0]));
        SymbolBalanceChecker(in);
        in.close();
        }
	catch (FileNotFoundException e){
		e.getStackTrace();
		System.err.println("Please input one file name");}
	catch (IOException e) {
		e.printStackTrace();
		System.err.println("File close failed.");
	}

	}
}
