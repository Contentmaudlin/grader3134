//Yilun Ying yy2658
//symbol balance checker for HW2
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class SymbolBalance {

	public static void main(String[] args) {
		
		//importing the file name
		String fileName = new String();
		fileName = args[0];
		ArrayList<String> lineByLine = new ArrayList<String>(); //takes in the file line by line
		MyStack<Integer> symbolStack = new MyStack<Integer>(); //stores the symbols

		try {//error handling in case file not found
			File inFile = new File(fileName);
			Scanner input = new Scanner(inFile);
			while (input.hasNext()) {
				lineByLine.add(input.nextLine());
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		boolean pausePush = false;// stops pushing symbols onto stack when encounter " or /*
		boolean errorFound = false;// terminates error checking once error is found

		for (int j = 0; j < lineByLine.size(); j++) {
			for (int k = 0; k < lineByLine.get(j).length(); k++) {
				
				if (!errorFound) {//runs if no error is found yet
					
					char toTest;//current character to test
					toTest = lineByLine.get(j).charAt(k);
					int symbolCode;//assigns each symbol with a code for easy comparison
					symbolCode = whatSymbol(toTest);
					
					if (!pausePush) {//if not in any block comments or literals
						
						if (symbolCode == 4) {// " symbol, pause push
							pausePush = true;
							symbolStack.push(symbolCode);
						}
						
						else if (symbolCode == 5) {// / symbol
							if (k < lineByLine.get(j).length() - 1) {// check if there is a next character
								k++;
								toTest = lineByLine.get(j).charAt(k);// reads the next character
								symbolCode = whatSymbol(toTest);
								
								if (symbolCode == 6) {//checks if the next character is a *
									
									symbolStack.push(symbolCode);
									pausePush = true;// if it is a /*, then pause push
								} else {
									k--;
								}
							}
						}
						
						else if (symbolCode == 1) {// { symbol
							symbolStack.push(symbolCode);
						}
						
						else if (symbolCode == 2) {// [ symbol
							symbolStack.push(symbolCode);
						}
						
						else if (symbolCode == 3) {// ( symbol
							symbolStack.push(symbolCode);
						}
						
						else if (symbolCode == 6) {// unmatched */ symbol
							if (k < lineByLine.get(j).length() - 1) {
								k++;
								toTest = lineByLine.get(j).charAt(k);
								symbolCode = whatSymbol(toTest);
								if (symbolCode == 5) {
									errorFound = true;
									symbolStack.push(symbolCode);
								} else {
									k--;
								}
							}
						}
						
						else if (symbolCode > 6) {// },],) symbols
							
							if (symbolStack.sizeOfStack() == 0) {// check if it is only remaining unmatched
								errorFound = true;
								symbolStack.push(symbolCode);
							} else {// check if it is matched
								int symbolPeek = symbolStack.peek();
								if (symbolCode == 7 && symbolPeek == 3) {
									symbolStack.pop();
								} else if (symbolCode == 8 && symbolPeek == 2) {
									symbolStack.pop();
								} else if (symbolCode == 9 && symbolPeek == 1) {
									symbolStack.pop();
								} else {
									errorFound = true;// if unmatched
								}
							}
						}
						
					} else {// after encountering a /* or "
						
						if (symbolStack.peek() == 6) {//encounter a *
							if (symbolCode == 6) {
								if (k < lineByLine.get(j).length() - 1) {
									k++;
									toTest = lineByLine.get(j).charAt(k);
									symbolCode = whatSymbol(toTest);
									if (symbolCode == 5) {//check if followed by /
										symbolStack.pop();
										pausePush = false;
									} else {
										k--;
									}
								}
							}
							
						} else if (symbolStack.peek() == 4) {// " symbol
							if (symbolCode == 4) {
								symbolStack.pop();
								pausePush = false;
							} else if ((k + 1) == lineByLine.get(j).length()) {// if line ends without a "
								errorFound = true;
							}
						}
					}
				}

			}
		}

		if (symbolStack.sizeOfStack() != 0) {//outputs the error
			System.out.println("Unbalanced! The first unbalanced symbol is: ");
			System.out.print(errorType(symbolStack.pop()));
		} else {
			System.out.println("Success!");
		}

	}

	private static String errorType(int errorCode) {//converts the symbol code back into a error type
		if (errorCode == 1) {
			return "{";
		}
		if (errorCode == 2) {
			return "[";
		}
		if (errorCode == 3) {
			return "(";
		}
		if (errorCode == 4) {
			return "\"";
		}
		if (errorCode == 5) {
			return "*/";
		}
		if (errorCode == 6) {
			return "/*";
		}
		if (errorCode == 7) {
			return ")";
		}
		if (errorCode == 8) {
			return "]";
		}
		if (errorCode == 9) {
			return "}";
		}
		return null;
	}

	private static int whatSymbol(char charTested) {//converts a symbol into a symbol code for comparison
		if (charTested == '{') {
			return 1;
		}
		if (charTested == '[') {
			return 2;
		}
		if (charTested == '(') {
			return 3;
		}
		if (charTested == '"') {
			return 4;
		}
		if (charTested == '/') {
			return 5;
		}
		if (charTested == '*') {
			return 6;
		}
		if (charTested == ')') {
			return 7;
		}
		if (charTested == ']') {
			return 8;
		}
		if (charTested == '}') {
			return 9;
		} else {
			return 0;
		}
	}

}
